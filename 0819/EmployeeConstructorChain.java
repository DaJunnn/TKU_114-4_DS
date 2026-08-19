abstract class EmployeeBase {
    protected int id;
    protected String name;

    public EmployeeBase(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("EmployeeBase constructor");
    }

    public abstract int calculatePay();
}

class FullTimeEmployee extends EmployeeBase {
    private int monthlySalary;

    public FullTimeEmployee(int id, String name, int monthlySalary) {
        super(id, name);
        System.out.println("FullTimeEmployee constructor");

        if (monthlySalary < 0) {
            monthlySalary = 0;
        }

        this.monthlySalary = monthlySalary;
    }

    @Override
    public int calculatePay() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends EmployeeBase {
    private int hourlyRate;
    private int hours;

    public PartTimeEmployee(int id, String name, int hourlyRate, int hours) {
        super(id, name);
        System.out.println("PartTimeEmployee constructor");

        if (hourlyRate < 0) {
            hourlyRate = 0;
        }

        if (hours < 0) {
            hours = 0;
        }

        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    public int calculatePay() {
        return hourlyRate * hours;
    }
}

public class EmployeeConstructorChain {
    public static void main(String[] args) {
        System.out.println("建立 FullTimeEmployee：");
        FullTimeEmployee fullTime =
                new FullTimeEmployee(1, "Amy", 40000);

        System.out.println("薪資：" + fullTime.calculatePay());

        System.out.println();

        System.out.println("建立 PartTimeEmployee：");
        PartTimeEmployee partTime =
                new PartTimeEmployee(2, "Tom", 200, 80);

        System.out.println("薪資：" + partTime.calculatePay());
    }
}