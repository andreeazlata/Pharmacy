package service;

import domain.ClientCardsWithNumberOfPurchases;
import domain.Medicine;
import domain.MedicineWithNumberOfPurchases;
import domain.Transaction;
import repository.IRepository;
import repository.RepositoryException;

import java.util.*;

public class ServiceMedicine {

    private final IRepository<Medicine> medicineRepository;
    private final IRepository<Transaction> transactionsRepository;

    public ServiceMedicine(IRepository<Medicine> medicineRepository, IRepository<Transaction> transactionIRepository) {
        this.medicineRepository = medicineRepository;
        this.transactionsRepository = transactionIRepository;
    }



    /**
     * @param idEntity
     * @param name
     * @param manufacturer
     * @param price
     * @param needsPrescription
     * @param numberOfitems
     * @throws RepositoryException
     */
    public void addMedicine(int idEntity, String name, String manufacturer, float price, boolean needsPrescription, int numberOfitems) throws RepositoryException {
        Medicine medicine = new Medicine(idEntity, name, manufacturer, price, needsPrescription, numberOfitems);
        if (price > 0) {
            this.medicineRepository.create(medicine);
        }
    }

    public void updateMedicine(int idEntity, String name, String manufacturer, float price, boolean needsPrescription, int numberOfitems) throws RepositoryException {
        Medicine medicine = new Medicine(idEntity, name, manufacturer, price, needsPrescription, numberOfitems);
        this.medicineRepository.update(medicine);
    }

    public void delete(int idMedicine) throws RepositoryException {
        this.medicineRepository.delete(idMedicine);

    }

    /**
     * @return list of medicine sorted by number of purchases
     */
    public List<MedicineWithNumberOfPurchases> getMedicineOrderedByNumberOfPurchases() {
        Map<Integer, Integer> medicineWithNumberOfPurchases = new HashMap<>();
        for (Transaction t : this.transactionsRepository.read()) {
            int idMedicine = t.getMedicineId();
            if (!medicineWithNumberOfPurchases.containsKey(idMedicine)) {
                medicineWithNumberOfPurchases.put(idMedicine, 1);
            } else {
                medicineWithNumberOfPurchases.put(idMedicine, medicineWithNumberOfPurchases.get(idMedicine) + 1);
            }
        }
        List<MedicineWithNumberOfPurchases> results = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : medicineWithNumberOfPurchases.entrySet()) {
            int idMedicine = entry.getKey();
            int numberOfPurchases = entry.getValue();

            Medicine medicine = this.medicineRepository.readOne(idMedicine);
            results.add(new MedicineWithNumberOfPurchases(idMedicine, medicine.getName(), numberOfPurchases));
        }
        results.sort(Comparator.comparing(MedicineWithNumberOfPurchases::getNumberOfPurchases).reversed());
        return results;
    }

    public  List<ClientCardsWithNumberOfPurchases> getClientCardsOrderedByNumberOfPurchases() {
        Map<Integer, Integer> clientCardsWithNumberOfPurchases = new HashMap<>();
        for (Transaction t : this.transactionsRepository.read()) {
            int clientCard = t.getClientCard();
            if (!clientCardsWithNumberOfPurchases.containsKey(clientCard)) {
                clientCardsWithNumberOfPurchases.put(clientCard, 1);
            } else {
                clientCardsWithNumberOfPurchases.put(clientCard, clientCardsWithNumberOfPurchases.get(clientCard) + 1);
            }
        }
        List<ClientCardsWithNumberOfPurchases> results = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : clientCardsWithNumberOfPurchases.entrySet()) {
            int clientCard = entry.getKey();
            int numberOfPurchases = entry.getValue();

            Medicine medicine = medicineRepository.readOne(clientCard);
            results.add(new ClientCardsWithNumberOfPurchases(clientCard, numberOfPurchases));
        }
        results.sort(Comparator.comparing(ClientCardsWithNumberOfPurchases::getNumberOfPurchases).reversed());
        return results;
    }

    public List<Medicine> getAll() {
        return this.medicineRepository.read();
    }

}
