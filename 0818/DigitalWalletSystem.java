public class DigitalWalletSystem {

    static class DigitalWallet {
        private String walletId;
        private String owner;
        private double balance;

        private int depositCount;
        private int paymentCount;
        private int refundCount;

        public DigitalWallet(String walletId, String owner) {
            this.walletId = walletId;
            this.owner = owner;
            this.balance = 0;
        }

        public boolean deposit(double amount) {
            if (amount <= 0) {
                return false;
            }

            balance += amount;
            depositCount++;
            return true;
        }

        public boolean pay(double amount) {
            if (amount <= 0 || amount > balance) {
                return false;
            }

            balance -= amount;
            paymentCount++;
            return true;
        }

        public boolean refund(double amount) {
            if (amount <= 0) {
                return false;
            }

            balance += amount;
            refundCount++;
            return true;
        }

        public double getBalance() {
            return balance;
        }

        public void printStatistics() {
            System.out.println("儲值次數：" + depositCount);
            System.out.println("付款次數：" + paymentCount);
            System.out.println("退款次數：" + refundCount);
        }

        @Override
        public String toString() {
            return "錢包編號：" + walletId
                    + "，持有人：" + owner
                    + "，餘額：" + balance;
        }
    }

    public static void main(String[] args) {

        DigitalWallet wallet =
                new DigitalWallet("W001", "王小明");

        System.out.println("===== 初始狀態 =====");
        System.out.println(wallet);

        System.out.println("\n===== 正常儲值 =====");
        System.out.println("儲值 1000：" + wallet.deposit(1000));
        System.out.println(wallet);

        System.out.println("\n===== 正常付款 =====");
        System.out.println("付款 300：" + wallet.pay(300));
        System.out.println(wallet);

        System.out.println("\n===== 餘額不足 =====");
        System.out.println("付款 1000：" + wallet.pay(1000));
        System.out.println(wallet);

        System.out.println("\n===== 負數金額退款 =====");
        System.out.println("退款 -200：" + wallet.refund(-200));
        System.out.println(wallet);

        System.out.println("\n===== 正常退款 =====");
        System.out.println("退款 100：" + wallet.refund(100));
        System.out.println(wallet);

        System.out.println("\n===== 交易次數統計 =====");
        wallet.printStatistics();
    }
}