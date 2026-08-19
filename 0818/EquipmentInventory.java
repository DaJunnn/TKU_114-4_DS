public class EquipmentInventory {

    static class Equipment {
        private String id;
        private String name;
        private int availableCount;

        public Equipment(String id, String name, int availableCount) {
            if (id == null || id.trim().isEmpty()) {
                this.id = "Unknown";
            } else {
                this.id = id;
            }

            if (name == null || name.trim().isEmpty()) {
                this.name = "Unknown";
            } else {
                this.name = name;
            }

            if (availableCount < 0) {
                this.availableCount = 0;
            } else {
                this.availableCount = availableCount;
            }
        }

        public boolean borrowOne() {
            if (availableCount > 0) {
                availableCount--;
                return true;
            }

            return false;
        }

        public void returnItems(int quantity) {

            if (quantity > 0) {
                availableCount += quantity;
            }
        }

        @Override
        public String toString() {
            return "設備編號：" + id
                    + "，名稱：" + name
                    + "，可借數量：" + availableCount;
        }
    }

    public static void main(String[] args) {

        // 建立兩個設備
        Equipment equipment1 = new Equipment("E001", "Laptop", 2);
        Equipment equipment2 = new Equipment("E002", "Projector", 0);

        System.out.println("===== 初始設備資料 =====");
        System.out.println(equipment1);
        System.out.println(equipment2);

        // 測試借用成功
        System.out.println("\n===== 測試借用成功 =====");

        boolean result1 = equipment1.borrowOne();

        System.out.println("借用 Laptop：" + result1);
        System.out.println(equipment1);

        // 測試借用失敗
        System.out.println("\n===== 測試借用失敗 =====");

        boolean result2 = equipment2.borrowOne();

        System.out.println("借用 Projector：" + result2);
        System.out.println(equipment2);

        // 測試歸還
        System.out.println("\n===== 測試歸還 =====");

        equipment2.returnItems(3);

        System.out.println("歸還 3 個 Projector");
        System.out.println(equipment2);

        // 再次借用
        System.out.println("\n===== 歸還後再次借用 =====");

        boolean result3 = equipment2.borrowOne();

        System.out.println("借用 Projector：" + result3);
        System.out.println(equipment2);

        // 測試負數歸還
        System.out.println("\n===== 測試錯誤歸還數量 =====");

        equipment2.returnItems(-5);

        System.out.println("嘗試歸還 -5 個");
        System.out.println(equipment2);

        // 測試 Constructor 邊界條件
        System.out.println("\n===== 測試 Constructor =====");

        Equipment equipment3 = new Equipment("", "", -10);

        System.out.println(equipment3);
    }
}