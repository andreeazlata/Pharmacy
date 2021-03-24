package domain;

import java.sql.Time;
import java.util.Date;

public class Transaction extends domain.Entity {
        private String id;
        private String medicineId;
        private int clientCard;
        private int numberOfItems;
        private Date date;
        private Time time;

    public Transaction(int idEntity, String id, String medicineId, int clientCard, int numberOfItems, Date date, Time time) {
        super(idEntity);
        this.id = id;
        this.medicineId = medicineId;
        this.clientCard = clientCard;
        this.numberOfItems = numberOfItems;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public int getClientCard() {
        return clientCard;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", medicineId='" + medicineId + '\'' +
                ", clientCard=" + clientCard +
                ", numberOfItems=" + numberOfItems +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
