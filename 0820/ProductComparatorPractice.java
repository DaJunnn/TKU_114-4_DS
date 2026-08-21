import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StoreProduct implements Comparable<StoreProduct> {

    private int id;
    private String name;
    private double price;
    private int stock;

    public StoreProduct(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public int compareTo(StoreProduct other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "StoreProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

public class ProductComparatorPractice {

    public static void main(String[] args) {

        List<StoreProduct> products = new ArrayList<>();

        products.add(new StoreProduct(5, "Keyboard", 1500, 10));
        products.add(new StoreProduct(2, "Mouse", 800, 20));
        products.add(new StoreProduct(4, "Monitor", 5000, 5));
        products.add(new StoreProduct(1, "Headset", 1500, 20));
        products.add(new StoreProduct(3, "Webcam", 800, 5));

        System.out.println("原始順序：");
        printProducts(products);

        List<StoreProduct> idSorted = new ArrayList<>(products);
        idSorted.sort(null);

        System.out.println("\nNatural order：id 升冪");
        printProducts(idSorted);

        Comparator<StoreProduct> byPriceThenName =
                Comparator.comparingDouble(StoreProduct::getPrice)
                          .thenComparing(StoreProduct::getName);

        List<StoreProduct> priceSorted = new ArrayList<>(products);
        priceSorted.sort(byPriceThenName);

        System.out.println("\nprice 升冪，同價時依 name：");
        printProducts(priceSorted);

        Comparator<StoreProduct> byStockDescThenId =
                Comparator.comparingInt(StoreProduct::getStock)
                          .reversed()
                          .thenComparingInt(StoreProduct::getId);

        List<StoreProduct> stockSorted = new ArrayList<>(products);
        stockSorted.sort(byStockDescThenId);

        System.out.println("\nstock 降冪，同庫存時依 id：");
        printProducts(stockSorted);

        System.out.println("\n再次顯示原始 products：");
        printProducts(products);
    }

    public static void printProducts(List<StoreProduct> products) {
        for (StoreProduct product : products) {
            System.out.println(product);
        }
    }
}