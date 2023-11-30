import java.util.Random;
public class EmployeeWageCalculation1 {

    // Constants for employee attendance
    public static final int FULL_TIME = 1;
    public static final int PART_TIME = 2;
    public static final int FULL_DAY_HOURS = 8;
    public static final int PART_TIME_HOURS = 4;

    // Instance variables for company-specific information
    private String companyName;
    private int wagePerHour;
    private int maxWorkingDays;
    private int maxWorkingHours;
    private int totalWage;

    // Constructor to initialize company-specific information
    public EmpWageBuilder(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.totalWage = 0;
    }


    public static int checkingAttendance()
    {
        Random random = new Random();
        return random.nextInt(3); // 0 for absent, 1 for full time, 2 for part time
    }


    // Method for calculating daily wage
    private int calculateDailyWage(int empHours) {
        return empHours * wagePerHour;
    }


    // Method for calculating employee wage
    public void calculateEmployeeWage() {
        int totalWorkingHours = 0;
        int totalWorkingDays = 0;

        while (totalWorkingDays < maxWorkingDays && totalWorkingHours <= maxWorkingHours) {
            totalWorkingDays++;
            int empCheck = checkingAttendance();
            int empHours;

            switch (empCheck) {
                case FULL_TIME:
                    empHours = FULL_DAY_HOURS;
                    break;
                case PART_TIME:
                    empHours = PART_TIME_HOURS;
                    break;
                default:
                    empHours = 0;
            }

            totalWorkingHours += empHours;
            int dailyWage = calculateDailyWage(empHours);
            totalWage += dailyWage;

            System.out.println("Daily Wage for " + companyName + "= " + dailyWage);
        }

        System.out.println("Total Wage for " + companyName + "= " + totalWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        EmpWageBuilder companyA = new EmpWageBuilder("CompanyA", 20, 20, 100);
        companyA.calculateEmployeeWage();

        EmpWageBuilder companyB = new EmpWageBuilder("CompanyB", 25, 25, 120);
        companyB.calculateEmployeeWage();
    }
}

