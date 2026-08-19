interface Exportable {
    void export();
}

interface Compressible {
    void compress();
}

class BackupDocument implements Exportable, Compressible {

    @Override
    public void export() {
        System.out.println("匯出備份文件");
    }

    @Override
    public void compress() {
        System.out.println("壓縮備份文件");
    }
}

public class DocumentCapabilityDemo {
    public static void main(String[] args) {
        BackupDocument document = new BackupDocument();

        Exportable exportable = document;
        Compressible compressible = document;

        exportable.export();
        compressible.compress();

        System.out.println(exportable == compressible);
    }
}