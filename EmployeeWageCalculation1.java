import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Class to encapsulate company-specific information
class CompanyEmpWage {
    private String companyName;
    private int wagePerHour;
    private int maxWorkingDays;
    private int maxWorkingHours;
    private int totalWage;
    private List<Integer> dailyWages;

    public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.totalWage = 0;
        this.dailyWages = new ArrayList<>();
    }

    // Getters and setters for company-specific information
    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getMaxWorkingDays() {
        return maxWorkingDays;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }

    // Setter for total wage
    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    // Getter for total wage
    public int getTotalWage() {
        return totalWage;
    }

    // Getter for daily wages
    public List<Integer> getDailyWages() {
        return dailyWages;
    }

    // Method to add daily wage
    public void addDailyWage(int dailyWage) {
        dailyWages.add(dailyWage);
    }
}

// Class implementing the interface
public class EmployeeWageCalculation1 {

    // Constants for employee attendance
    public static final int FULL_TIME = 1;
    public static final int PART_TIME = 2;
    public static final int FULL_DAY_HOURS = 8;
    public static final int PART_TIME_HOURS = 4;

    // List to store CompanyEmpWage objects
    private List<CompanyEmpWage> companyEmpWages;

    // Constructor to initialize list
    public EmpWageBuilder() {
        companyEmpWages = new ArrayList<>();
    }

    // Method to add a new company
    public void addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        companyEmpWages.add(new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours));
    }

    // Method for checking attendance
    public static int checkingAttendance() {
        Random random = new Random();
        return random.nextInt(3); // 0 for absent, 1 for full time, 2 for part time
    }

    // Method for calculating daily wage
    public int calculateDailyWage(int empHours, int wagePerHour) {
        return empHours * wagePerHour;
    }

    // Method for calculating employee wage for all companies
    public void calculateEmployeeWage() {
        for (CompanyEmpWage currentCompany : companyEmpWages) {
            int totalWorkingHours = 0;
            int totalWorkingDays = 0;

            while (totalWorkingDays < currentCompany.getMaxWorkingDays() && totalWorkingHours <= currentCompany.getMaxWorkingHours()) {
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
                int dailyWage = calculateDailyWage(empHours, currentCompany.getWagePerHour());
                currentCompany.addDailyWage(dailyWage); // Store daily wage
                currentCompany.setTotalWage(currentCompany.getTotalWage() + dailyWage);

                System.out.println("Daily Wage for " + currentCompany.getCompanyName() + "= " + dailyWage);
            }

            System.out.println("Total Wage for " + currentCompany.getCompanyName() + "= " + currentCompany.getTotalWage());
            System.out.println("Daily Wages for " + currentCompany.getCompanyName() + "= " + currentCompany.getDailyWages());
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        EmpWageBuilder empWageBuilder = new EmpWageBuilder();

        // Adding companies
        empWageBuilder.addCompany("CompanyA", 20, 20, 100);
        empWageBuilder.addCompany("CompanyB", 25, 25, 120);

        // Calculate and display wages for all companies
        empWageBuilder.calculateEmployeeWage();
    }
}




