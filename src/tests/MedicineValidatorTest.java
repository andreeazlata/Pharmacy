package tests;

import domain.Medicine;
import domain.MedicineValidator;
import org.junit.jupiter.api.Test;
import repository.IRepository;
import repository.InMemoryRepository;

import static org.junit.jupiter.api.Assertions.*;

class MedicineValidatorTest {

    @Test
    void validateShouldThrowWhenThePriceIsSmallerOrEqualToZero() {
        IRepository<Medicine> repositoryMedicine = new InMemoryRepository<>();
        Medicine medicine = new Medicine(1, "a", "b", -2, false, 10);
        MedicineValidator medicineValidator = new MedicineValidator();

        try {
            medicineValidator.validate(medicine);
            fail("The price is not >= 0 doesn't throw");
        } catch (Exception exception) {
            assertEquals("Price needs to be positive and bigger than 0", exception.getMessage());
        }

    }
}