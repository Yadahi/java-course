public class Student extends Person{
    public static final int BASE_FEE = 3000;
    public static final int FEE_INCREASE = 100;

    private int year;
    private double yearlyFee;

    public Student(String name, String address, int year) {
        super(name, address);
        this.year = year;
        this.yearlyFee = BASE_FEE + ((year - 1) * FEE_INCREASE);
    }

    public double getYearlyFee() {
        return yearlyFee;
    }

    public double calculateInstallmentFee() {
        return yearlyFee / 2;
    }

    public String toString() {
        return String.format("name=%s, address=%s, year=%d, fee=$%.2f", getName(), getAddress(), year, yearlyFee);
    }
}

