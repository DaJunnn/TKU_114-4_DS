public class WalletHistoryManager {

    static class Transaction {
        private int sequence;
        private String type;
        private int amount;
        private int balanceAfter;

        public Transaction(int sequence, String type, int amount, int balanceAfter) {
            this.sequence = sequence;
            this.type = type;
            this.amount = amount;
            this.balanceAfter = balanceAfter;
        }

        public int getSequence() {
            return sequence;
        }

        public String getType() {
            return type;
        }

        public int getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "#" + sequence
                    + " " + type
                    + " 金額：" + amount
                    + " 餘額：" + balanceAfter;
        }
    }

    static class DigitalWallet {
        private String walletId;
        private String owner;
        private int balance;
        private Transaction[] transactions;
        private int transactionCount;
        private int nextSequence;

        public DigitalWallet(String walletId, String owner, int capacity) {
            this.walletId = walletId;
            this.owner = owner;
            this.balance = 0;
            this.transactions = new Transaction[capacity];
            this.transactionCount = 0;
            this.nextSequence = 1;
        }

        public boolean deposit(int amount) {
            if (amount <= 0 || transactionCount >= transactions.length) {
                return false;
            }

            balance += amount;
            addTransaction("DEPOSIT", amount);
            return true;
        }

        public boolean pay(int amount) {
            if (amount <= 0 || amount > balance) {
                return false;
            }

            if (transactionCount >= transactions.length) {
                return false;
            }

            balance -= amount;
            addTransaction("PAY", amount);
            return true;
        }

        public boolean refund(int amount) {
            if (amount <= 0 || transactionCount >= transactions.length) {
                return false;
            }

            balance += amount;
            addTransaction("REFUND", amount);
            return true;
        }

        public boolean transferTo(DigitalWallet target, int amount) {
            if (target == null || target == this) {
                return false;
            }

            if (amount <= 0 || balance < amount) {
                return false;
            }

            if (transactionCount >= transactions.length
                    || target.transactionCount >= target.transactions.length) {
                return false;
            }

            balance -= amount;
            target.balance += amount;

            addTransaction("TRANSFER_OUT", amount);
            target.addTransaction("TRANSFER_IN", amount);

            return true;
        }

        private void addTransaction(String type, int amount) {
            transactions[transactionCount] =
                    new Transaction(nextSequence, type, amount, balance);

            transactionCount++;
            nextSequence++;
        }

        public Transaction findTransaction(int sequence) {
            for (int i = 0; i < transactionCount; i++) {
                if (transactions[i].getSequence() == sequence) {
                    return transactions[i];
                }
            }

            return null;
        }

        public int totalByType(String type) {
            int total = 0;

            if (type == null) {
                return total;
            }

            for (int i = 0; i < transactionCount; i++) {
                if (transactions[i].getType().equalsIgnoreCase(type)) {
                    total += transactions[i].getAmount();
                }
            }

            return total;
        }

        public void printStatement() {
            System.out.println("===== 錢包對帳單 =====");
            System.out.println("錢包編號：" + walletId);
            System.out.println("持有人：" + owner);
            System.out.println("目前餘額：" + balance);
            System.out.println("交易紀錄：");

            if (transactionCount == 0) {
                System.out.println("無交易紀錄");
            } else {
                for (int i = 0; i < transactionCount; i++) {
                    System.out.println(transactions[i]);
                }
            }
        }
    }

    public static void main(String[] args) {

        DigitalWallet wallet1 =
                new DigitalWallet("W001", "王小明", 10);

        DigitalWallet wallet2 =
                new DigitalWallet("W002", "李小華", 10);

        wallet1.deposit(2000);
        wallet1.pay(300);
        wallet1.refund(100);

        wallet2.deposit(500);

        System.out.println("轉帳結果：" +
                wallet1.transferTo(wallet2, 600));

        System.out.println();

        wallet1.printStatement();

        System.out.println();

        wallet2.printStatement();

        System.out.println("\n===== 查詢交易 =====");

        Transaction transaction =
                wallet1.findTransaction(2);

        if (transaction != null) {
            System.out.println(transaction);
        } else {
            System.out.println("找不到交易");
        }

        System.out.println("\n===== 指定類型總金額 =====");

        System.out.println(
                "DEPOSIT 總額：" +
                wallet1.totalByType("DEPOSIT")
        );

        System.out.println(
                "PAY 總額：" +
                wallet1.totalByType("PAY")
        );

        System.out.println(
                "TRANSFER_OUT 總額：" +
                wallet1.totalByType("TRANSFER_OUT")
        );
    }
}