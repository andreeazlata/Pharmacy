package domain;

public class Transaction extends Entity {
        private int medicineId;
        private int clientCard;
        private int numberOfItems;
        private String dateAndHour;


    public Transaction(int idEntity, int medicineId, int clientCard, int numberOfItems, String dateAndHour) {
        super(idEntity);
        this.medicineId = medicineId;
        this.clientCard = clientCard;
        this.numberOfItems = numberOfItems;
        this.dateAndHour = dateAndHour;

    }

    public int getMedicineId() {
        return medicineId;
    }

    public int getClientCard() {
        return clientCard;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public String getDateAndHour() {
        return dateAndHour;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id= " + getIdEntity()+'\''+
                ", medicineId='" + medicineId + '\'' +
                ", clientCard=" + clientCard +
                ", numberOfItems=" + numberOfItems +
                ", dateAndHour='" + dateAndHour + '\'' +
                '}';
    }
}
