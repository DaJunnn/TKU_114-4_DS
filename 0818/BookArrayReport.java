public class BookArrayReport {

    static class Book {
        private String bookId;
        private String title;
        private double price;
        private int stock;

        public Book(String bookId, String title, double price, int stock) {
            this.bookId = bookId;
            this.title = title;
            this.price = price;
            this.stock = stock;
        }

        public String getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public double getPrice() {
            return price;
        }

        public int getStock() {
            return stock;
        }

        @Override
        public String toString() {
            return "書號：" + bookId
                    + "，書名：" + title
                    + "，價格：" + price
                    + "，庫存：" + stock;
        }
    }

    public static void main(String[] args) {

        Book[] books = {
            new Book("B001", "Java程式設計", 650, 5),
            new Book("B002", "資料結構", 720, 3),
            new Book("B003", "人工智慧", 850, 2),
            new Book("B004", "機器學習", 780, 6)
        };

        System.out.println("===== 所有書籍 =====");

        for (Book book : books) {
            System.out.println(book);
        }

        double totalValue = 0;

        for (Book book : books) {
            totalValue += book.getPrice() * book.getStock();
        }

        System.out.println("\n庫存總價值：" + totalValue);

        Book highestPriceBook = books[0];

        for (Book book : books) {
            if (book.getPrice() > highestPriceBook.getPrice()) {
                highestPriceBook = book;
            }
        }

        System.out.println("\n===== 價格最高的書 =====");
        System.out.println(highestPriceBook);

        System.out.println("\n===== 庫存小於或等於 3 的書 =====");

        for (Book book : books) {
            if (book.getStock() <= 3) {
                System.out.println(book);
            }
        }
    }
}