package userInterface;

import domain.ClientCardsWithNumberOfPurchases;
import domain.Medicine;
import domain.MedicineWithNumberOfPurchases;
import domain.Transaction;
import service.ServiceMedicine;
import service.ServiceTransaction;

import java.util.List;
import java.util.Scanner;

public class Console {

    private final ServiceMedicine serviceMedicine;
    private final Scanner scanner = new Scanner(System.in);
    private final ServiceTransaction serviceTransaction;

    public Console(ServiceTransaction serviceTransaction, ServiceMedicine serviceMedicine) {
        this.serviceMedicine = serviceMedicine;
        this.serviceTransaction = serviceTransaction;
    }

    private void showMenu() {
        System.out.println("1. Add medicine");
        System.out.println("2. Remove medicine");
        System.out.println("3. Update medicine");
        System.out.println("4. Add transaction");
        System.out.println("5. Remove transaction");
        System.out.println("6. Update transaction");
        System.out.println("7. Show all the medicine");
        System.out.println("8. Show all the transactions");
        System.out.println("9. List medicines by number of sales");
        System.out.println("10. List client cards by number of purchases");
        System.out.println("11. Medicines cheaper than max");
        System.out.println("x. Exit");
    }

    public void startConsole() {
        label:
        while (true) {
            this.showMenu();
            System.out.println("Choose an option:");
            String option = scanner.next();
            switch (option) {
                case "1":
                    this.handleAddMedicine();
                    break;
                case "2":
                    this.handleRemoveMedicine();
                    break;
                case "3":
                    this.handleUpdateMedicine();
                    break;
                case "4":
                    this.handleAddTransaction();
                    break;
                case "5":
                    this.handleRemoveTransaction();
                    break;
                case "6":
                    this.handleUpdateTransaction();
                    break;
                case "7":
                    this.handleShowAllMedicine();
                    break;
                case "8":
                    this.handleShowAllTransactions();
                    break;
                case "9":
                    this.handleMadicineWithNumberOfPurchases();
                    break;
                case "10":
                    this.handleClientCardsWithNumberOfPurchases();
                    break;
                case "11":
                    this.handleCheaperThanMax();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Optiune invalida");
                    break;
            }
        }
    }

    private void handleAddMedicine() {
        try {
            System.out.println("Write the id of the medicine: ");
            int idMedicine = scanner.nextInt();
            System.out.println("Write the name of the medicine: ");
            String medicineName = scanner.next();
            System.out.println("Write the manufacturer of the medicine: ");
            String manufacturer = scanner.next();
            System.out.println("Write the price:");
            float price = scanner.nextFloat();
            System.out.println("Needs prescriptions?");
            boolean needsPrescription = Boolean.parseBoolean(scanner.next());
            System.out.println("Write the number of items available:");
            int numberOfitems = scanner.nextInt();
            this.serviceMedicine.addMedicine(idMedicine, medicineName, manufacturer, price, needsPrescription, numberOfitems);
        } catch (Exception exception) {
            System.out.println("You have the following errors:");
            System.out.println(exception.getMessage());
        }

    }

    private void handleUpdateMedicine() {
        try {
            System.out.println("Write the id of the medicine you want to update: ");
            int idMedicine = scanner.nextInt();
            System.out.println("Write the name of the medicine: ");
            String medicineName = scanner.next();
            System.out.println("Write the manufacturer of the medicine: ");
            String manufacturer = scanner.next();
            System.out.println("Write the price:");
            float price = scanner.nextFloat();
            System.out.println("Needs prescriptions?");
            boolean needsPrescription = Boolean.parseBoolean(scanner.next());
            System.out.println("Write the number of items available:");
            int numberOfitems = scanner.nextInt();
            this.serviceMedicine.updateMedicine(idMedicine, medicineName, manufacturer, price, needsPrescription, numberOfitems);
        } catch (Exception exception) {
            System.out.println("You have the following errors:");
            System.out.println(exception.getMessage());
        }

    }


    private void handleRemoveMedicine() {
        try {
            System.out.println("Write the id of the medicine: ");
            int idMedicine = scanner.nextInt();
            this.serviceMedicine.delete(idMedicine);
        } catch (Exception exception) {
            System.out.println("You have the following errors:");
            System.out.println(exception.getMessage());
        }

    }



    private void handleAddTransaction() {
        try {
            System.out.println("Write the id of the transaction: ");
            int idTransaction=  scanner.nextInt();
            System.out.println("Write the id of the medicine: ");
            int idMedicine = scanner.nextInt();
            System.out.println("Write the client card number: ");
            int clientCard = scanner.nextInt();
            System.out.println("Write the number of items: ");
            int numberOfItems = scanner.nextInt();
            System.out.println("Write the date and hour: ");
            String dateAndHour = scanner.next();
            this.serviceTransaction.addTransaction(idTransaction, idMedicine, clientCard, numberOfItems,dateAndHour);
//            this.serviceMedicine.updateMedicine(idMedicine,numberOfItems);
        } catch (Exception exception) {
            System.out.println("You have the following errors:");
            System.out.println(exception.getMessage());
        }

    }

    private void handleUpdateTransaction() {
        try {
            System.out.println("Write the id of the transaction you want to update: ");
            int idTransaction=  scanner.nextInt();
            System.out.println("Write the id of the medicine: ");
            int idMedicine = scanner.nextInt();
            System.out.println("Write the client card number: ");
            int clientCard = scanner.nextInt();
            System.out.println("Write the number of items: ");
            int numberOfItems = scanner.nextInt();
            System.out.println("Write the date and hour: ");
            String dateAndHour = scanner.next();
            this.serviceTransaction.updateTransaction(idTransaction, idMedicine, clientCard, numberOfItems,dateAndHour);
        } catch (Exception exception) {
            System.out.println("You have the following errors:");
            System.out.println(exception.getMessage());
        }

    }

    private void handleRemoveTransaction() {
        try {
            System.out.println("Write the id of the transaction: ");
            int idTransaction = scanner.nextInt();
            this.serviceTransaction.deleteTransaction(idTransaction);
        } catch (Exception exception) {
            System.out.println("You have the following errors:");
            System.out.println(exception.getMessage());
        }

    }

    private void handleCheaperThanMax(){
        try{
            System.out.println("Write the max price: ");
            float maxPrice=scanner.nextFloat();
            List<Medicine> medicines= this.serviceMedicine.getMedicinesCheaperThan(maxPrice);
            System.out.println(medicines);
        }
        catch (Exception exception) {
            System.out.println("You have the following errors:");
            System.out.println(exception.getMessage());
        }
    }
    private void handleMadicineWithNumberOfPurchases() {
        for (MedicineWithNumberOfPurchases medicineWithNumberOfPurchases : this.serviceMedicine.getMedicineOrderedByNumberOfPurchases()) {
            System.out.println(medicineWithNumberOfPurchases);
        }
    }

    private void handleClientCardsWithNumberOfPurchases() {
        for (ClientCardsWithNumberOfPurchases clientCardsWithNumberOfPurchases : this.serviceMedicine.getClientCardsOrderedByNumberOfPurchases()) {
            System.out.println(clientCardsWithNumberOfPurchases);
        }
    }

    private void handleShowAllMedicine() {

        for (Medicine medicine : this.serviceMedicine.getAll()) {
            System.out.println(medicine.toString());
        }
    }

    private void handleShowAllTransactions() {

        for (Transaction transaction : this.serviceTransaction.getAll()) {
            System.out.println(transaction.toString());
        }
    }

}
