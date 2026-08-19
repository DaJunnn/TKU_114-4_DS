abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class MonthlyEmployee extends Employee {
    private double monthlySalary;

    public MonthlyEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary < 0 ? 0 : monthlySalary;
    }

    @Override
    public double calculatePay() {
        return monthlySalary;
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hours;

    public HourlyEmployee(String name, double hourlyRate, double hours) {
        super(name);
        this.hourlyRate = hourlyRate < 0 ? 0 : hourlyRate;
        this.hours = hours < 0 ? 0 : hours;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hours;
    }
}

class CommissionEmployee extends Employee {
    private double sales;
    private double commissionRate;

    public CommissionEmployee(String name, double sales, double commissionRate) {
        super(name);
        this.sales = sales < 0 ? 0 : sales;
        this.commissionRate = commissionRate < 0 ? 0 : commissionRate;
    }

    @Override
    public double calculatePay() {
        return sales * commissionRate;
    }
}

public class PayrollPolymorphismSystem {
    public static void main(String[] args) {
        Employee[] employees = {
            new MonthlyEmployee("Amy", 45000),
            new HourlyEmployee("Tom", 200, 120),
            new CommissionEmployee("Jack", 300000, 0.08),
            new MonthlyEmployee("Mary", 52000)
        };

        double totalPay = 0;
        double highestPay = 0;
        Employee highestEmployee = null;

        for (Employee employee : employees) {
            double pay = employee.calculatePay();

            System.out.println(
                employee.getName() + " 薪資：" +
                String.format("%.0f", pay)
            );

            totalPay += pay;

            if (highestEmployee == null || pay > highestPay) {
                highestPay = pay;
                highestEmployee = employee;
            }
        }

        System.out.println("薪資總額：" + String.format("%.0f", totalPay));
        System.out.println(
            "最高薪資：" + highestEmployee.getName() +
            "，薪資：" + String.format("%.0f", highestPay)
        );
    }
}