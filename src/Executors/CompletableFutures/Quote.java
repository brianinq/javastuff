package Executors.CompletableFutures;

public class Quote {
    private final int price;

    private final String site;

    public Quote(int price, String site) {
        this.site = site;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getSite() {
        return site;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "price=" + price +
                ", site='" + site + '\'' +
                '}';
    }
}
