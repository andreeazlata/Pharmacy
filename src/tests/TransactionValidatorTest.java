package tests;

import domain.Medicine;
import domain.Transaction;
import domain.TransactionValidator;
import org.junit.jupiter.api.Test;
import repository.IRepository;
import repository.InMemoryRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransactionValidatorTest {

    @Test
    void validateShouldThrowWhenThereIsNoMedicineWithTheGivenId() {

        IRepository<Medicine> repositoryMedicine = new InMemoryRepository<>();
        repositoryMedicine.create(new Medicine(1, "a", "b", 1000, false, 10));

        Transaction t = new Transaction(10, 8, 13, 11, "2020-11-08/14:50");

        TransactionValidator transactionValidator = new TransactionValidator();

        try{
            transactionValidator.validate(t,repositoryMedicine);

            fail("There is no medicine with the given id doesn't throw exception.");
        } catch (Exception exception) {
            assertEquals("There is no medicine with the given id!", exception.getMessage());
        }
    }

    @Test
    void validateShouldThrowWhenTheNumberOfItemsForTransactionIsBiggerThanTheTotal() {

        IRepository<Medicine> repositoryMedicine = new InMemoryRepository<>();
        repositoryMedicine.create(new Medicine(1, "a", "b", 1000, false, 10));

        Transaction t = new Transaction(8, 1, 13, 11, "2020-11-08/14:50");

        TransactionValidator transactionValidator = new TransactionValidator();

        try{
            transactionValidator.validate(t,repositoryMedicine);

            fail("The number of requested items is bigger than the medicine in stock doesn't throw exception.");
        } catch (Exception exception) {
            assertEquals("Cannot add transaction unless number of items for transaction <= number of items in stock", exception.getMessage());
        }
    }
}