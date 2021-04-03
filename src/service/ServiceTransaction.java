package service;

import domain.*;
import repository.IRepository;

import java.util.*;

public class ServiceTransaction {
    private IRepository<Transaction> repositoryTransaction;
    private IRepository<Medicine> repositoryMedicine;
    private TransactionValidator transactionValidator;

    public ServiceTransaction(IRepository<Transaction> repositoryTransaction,
                              IRepository<Medicine> repositoryMedicine,
                              TransactionValidator transactionValidator){
        this.repositoryTransaction = repositoryTransaction;
        this.repositoryMedicine = repositoryMedicine;
        this.transactionValidator =transactionValidator;
    }

    /**
     * creates a transaction
     * @param idEntity the id of the entity
     * @param medicineId the id of the medicine
     * @param clientCard the client card number
     * @param numberOfItems the number of items
     * @param dateAndHour the date and hour
     * @throws Exception
     */
    public void addTransaction(int idEntity, int medicineId, int clientCard, int numberOfItems, String dateAndHour) throws Exception {
        Transaction transaction = new Transaction(idEntity,medicineId,clientCard,numberOfItems,dateAndHour);
        this.transactionValidator.validate(transaction, this.repositoryMedicine);
        this.repositoryTransaction.create(transaction);
    }

    /**
     * updates a transaction.
     * @param idEntity the id of the entity
     * @param medicineId the id of the medicine
     * @param clientCard the client card number
     * @param numberOfItems the number of items
     * @param dateAndHour the date and hour
     * @throws Exception
     */
    public void updateTransaction(int idEntity, int medicineId, int clientCard, int numberOfItems, String dateAndHour) throws Exception {
        Transaction transaction = new Transaction(idEntity,medicineId,clientCard,numberOfItems,dateAndHour);
        this.transactionValidator.validate(transaction, this.repositoryMedicine);
        this.repositoryTransaction.update(transaction);
    }

    /**
     * deletes a transaction by its id
     * @param idEntity
     */
    public void deleteTransaction(int idEntity){
        this.repositoryTransaction.delete(idEntity);
    }
    /**
     *
     * @return a list of all the transactions
     */
    public List<Transaction> getAll(){
        return this.repositoryTransaction.read();
    }


}
