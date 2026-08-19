public class InventorySnapshotPractice {

    static final class InventorySnapshot {
        private final String warehouseId;
        private final int[] quantities;

        public InventorySnapshot(String warehouseId, int[] quantities) {
            this.warehouseId = warehouseId;

            if (quantities == null) {
                this.quantities = new int[0];
            } else {
                this.quantities = quantities.clone();
            }
        }

        public String getWarehouseId() {
            return warehouseId;
        }

        public int[] getQuantities() {
            return quantities.clone();
        }

        public int totalQuantity() {
            int total = 0;

            for (int quantity : quantities) {
                total += quantity;
            }

            return total;
        }

        public int outOfStockCount() {
            int count = 0;

            for (int quantity : quantities) {
                if (quantity == 0) {
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {

        int[] quantities = {5, 0, 3, 0};

        InventorySnapshot snapshot =
                new InventorySnapshot("W001", quantities);

        System.out.println("倉庫編號：" + snapshot.getWarehouseId());
        System.out.println("總數量：" + snapshot.totalQuantity());
        System.out.println("缺貨品項數：" + snapshot.outOfStockCount());

        quantities[0] = 100;

        System.out.println("修改原陣列後總數量：" + snapshot.totalQuantity());

        int[] copied = snapshot.getQuantities();
        copied[1] = 50;

        System.out.println("修改 getter 回傳陣列後總數量：" + snapshot.totalQuantity());

        InventorySnapshot emptySnapshot =
                new InventorySnapshot("W002", null);

        System.out.println("null 陣列總數量：" + emptySnapshot.totalQuantity());
        System.out.println("null 陣列缺貨品項數：" + emptySnapshot.outOfStockCount());
    }
}