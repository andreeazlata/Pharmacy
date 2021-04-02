package domain;

public class MedicineWithNumberOfPurchases {
    private int idMedicine;
    private String name;
    private int numberOfPurchases;

    public MedicineWithNumberOfPurchases(int idMedicine, String name, int numberOfPurchases) {
        this.idMedicine = idMedicine;
        this.name = name;
        this.numberOfPurchases = numberOfPurchases;
    }

    public int getIdMedicine() {
        return idMedicine;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    @Override
    public String toString() {
        return "MedicineWithNumberOfPurchases{" +
                "idMedicine=" + idMedicine +
                ", name='" + name + '\'' +
                ", numberOfPurchases=" + numberOfPurchases +
                '}';
    }
}
