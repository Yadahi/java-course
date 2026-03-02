public class Staff extends Person {
    public static final int BASE_SALARY = 50000;
    public static final int STEP_INCREASE = 500;
    private int yearsOfService;
    private double yearlySalary;

    public Staff(String name, String address, int yearsOfService) {
        super(name, address);
        this.yearsOfService = yearsOfService;
        this.yearlySalary = BASE_SALARY + (yearsOfService * STEP_INCREASE);
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public double calculateBiWeeklyPay() {
        return yearlySalary / 26;
    }

    public String toString() {
        return String.format("name=%s, address=%s, years=%d, pay=$%.2f", getName(), getAddress(), yearsOfService, yearlySalary);
    }
}

