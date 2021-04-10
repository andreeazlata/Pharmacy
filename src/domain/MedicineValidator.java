package domain;

import repository.IRepository;

public class MedicineValidator {

    public void validate(Medicine medicine) throws Exception {
        if (medicine.getPrice() <= 0) {
            throw new Exception("Price needs to be positive and bigger than 0");
        }
    }
}