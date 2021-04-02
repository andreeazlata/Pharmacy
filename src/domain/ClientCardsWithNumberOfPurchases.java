package domain;

public class ClientCardsWithNumberOfPurchases {

    private int clientCard;
    private int numberOfPurchases;

    public ClientCardsWithNumberOfPurchases(int clientCard, int numberOfPurchases) {
        this.clientCard = clientCard;
        this.numberOfPurchases = numberOfPurchases;
    }

    public int getClientCard() {
        return clientCard;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    @Override
    public String toString() {
        return "ClientCardsWithNumberOfPurchases{" +
                "clientCard=" + clientCard +
                ", numberOfPurchases=" + numberOfPurchases +
                '}';
    }
}
