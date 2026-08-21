import java.util.ArrayList;

class Repository<T> {

    private ArrayList<T> data;

    public Repository() {
        data = new ArrayList<>();
    }

    public void add(T item) {
        data.add(item);
    }

    public T get(int index) {
        if (index < 0 || index >= data.size()) {
            return null;
        }

        return data.get(index);
    }

    public T remove(int index) {
        if (index < 0 || index >= data.size()) {
            return null;
        }

        return data.remove(index);
    }

    public int size() {
        return data.size();
    }

    public void printAll() {
        for (T item : data) {
            System.out.println(item);
        }
    }
}

class Product {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class GenericRepositorySystem {

    public static void main(String[] args) {

        // Repository<String>
        Repository<String> stringRepository = new Repository<>();

        stringRepository.add("Java");
        stringRepository.add("Python");
        stringRepository.add("C++");

        System.out.println("=== Repository<String> ===");

        System.out.println("全部資料：");
        stringRepository.printAll();

        System.out.println("size: " + stringRepository.size());

        System.out.println("get(1): " + stringRepository.get(1));

        System.out.println("remove(0): " + stringRepository.remove(0));

        System.out.println("刪除後：");
        stringRepository.printAll();

        System.out.println();

        // Repository<Product>
        Repository<Product> productRepository = new Repository<>();

        productRepository.add(new Product(1, "Mouse", 800));
        productRepository.add(new Product(2, "Keyboard", 1500));
        productRepository.add(new Product(3, "Monitor", 5000));

        System.out.println("=== Repository<Product> ===");

        System.out.println("全部商品：");
        productRepository.printAll();

        System.out.println("size: " + productRepository.size());

        System.out.println("get(1): " + productRepository.get(1));

        System.out.println("remove(0): " + productRepository.remove(0));

        System.out.println("刪除後：");
        productRepository.printAll();
    }
}