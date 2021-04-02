package domain;

public class Medicine extends Entity {
    private String name;
    private String manufacturer;
    private float price;
    private boolean needsPrescription;
    private int numberOfitems;

    public Medicine(int idEntity, String name, String manufacturer, float price, boolean needsPrescription, int numberOfitems) {
        super(idEntity);
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.needsPrescription = needsPrescription;
        this.numberOfitems = numberOfitems;
    }


    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public float getPrice() {
        return price;
    }

    public boolean isNeedsPrescription() {
        return needsPrescription;
    }

    public int getNumberOfitems() {
        return numberOfitems;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", needsPrescription=" + needsPrescription +
                ", numberOfitems=" + numberOfitems +
                '}';
    }
}
