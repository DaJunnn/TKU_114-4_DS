public class AccountTransferService {

    static class Account {
        private String accountId;
        private int balance;

        public Account(String accountId, int balance) {
            this.accountId = accountId;
            this.balance = balance;
        }

        public String getAccountId() {
            return accountId;
        }

        public int getBalance() {
            return balance;
        }

        private void withdraw(int amount) {
            balance -= amount;
        }

        private void deposit(int amount) {
            balance += amount;
        }

        @Override
        public String toString() {
            return "帳戶：" + accountId + "，餘額：" + balance;
        }
    }

    static class TransferService {

        public boolean transfer(Account source, Account target, int amount) {

            if (source == null || target == null) {
                return false;
            }

            if (source == target) {
                return false;
            }

            if (amount <= 0) {
                return false;
            }

            if (source.getBalance() < amount) {
                return false;
            }

            source.withdraw(amount);
            target.deposit(amount);

            return true;
        }
    }

    public static void main(String[] args) {

        Account account1 = new Account("A001", 1000);
        Account account2 = new Account("A002", 500);

        TransferService service = new TransferService();

        System.out.println("===== 初始帳戶 =====");
        System.out.println(account1);
        System.out.println(account2);

        System.out.println("\n===== 成功轉帳 =====");
        System.out.println("轉帳結果：" +
                service.transfer(account1, account2, 300));
        System.out.println(account1);
        System.out.println(account2);

        System.out.println("\n===== 餘額不足 =====");
        System.out.println("轉帳結果：" +
                service.transfer(account1, account2, 1000));
        System.out.println(account1);
        System.out.println(account2);

        System.out.println("\n===== 同帳戶轉帳 =====");
        System.out.println("轉帳結果：" +
                service.transfer(account1, account1, 100));
        System.out.println(account1);

        System.out.println("\n===== null 目標 =====");
        System.out.println("轉帳結果：" +
                service.transfer(account1, null, 100));
        System.out.println(account1);
        System.out.println(account2);
    }
}