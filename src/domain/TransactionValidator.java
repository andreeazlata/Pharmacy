package domain;

import repository.IRepository;

public class TransactionValidator {
    /**
     *
     * @param transaction
     * @param medicineIRepository
     * @throws Exception
     */
    public void validate(Transaction transaction, IRepository<Medicine> medicineIRepository) throws Exception {
        Medicine givenMedicine = medicineIRepository.readOne((transaction.getMedicineId()));
        if (givenMedicine == null) {
            throw new Exception("There is no medicine with the given id!");
        }
        if (givenMedicine.getNumberOfitems() < transaction.getNumberOfItems()) {
            throw new Exception("Cannot add transaction unless number of items for transaction <= number of items in stock");
        }
//        if(transaction.getClientCard()!=Integer.parseInt(transaction.getClientCard())){
//            throw new Exception("Client card number is not an integer");
//        }
        }
    }

