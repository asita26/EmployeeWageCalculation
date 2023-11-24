import java.util.Random;

public class EmployeeWageCalculation1 {

    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;
    private static final int WORKING_DAYS_IN_MONTH = 20;
    private static final int MAX_WORKING_HOURS = 100;
    private static final int MAX_WORKING_DAYS = 20;
    
    //Method for UC1 : Checking Attendance
    public static int checkingAttendance() {
        Random random = new Random();
        return random.nextInt(3); // 0 for absent, 1 for full time, 2 for part time
    }
    
    //Method for UC2 & UC3 : Calculating Wage for Employees
    public static int calculateDailyWage(int empHours) {
        return empHours * WAGE_PER_HOUR;
    }

    //Method for UC5 & UC5 : Calculating Wage for Employees for a month and for total working hours
    public static void calculateEmployeeWage() {
        int totalWorkingHours = 0;
        int totalWorkingDays = 0;
        int totalWage = 0;

        while (totalWorkingDays < MAX_WORKING_DAYS && totalWorkingHours <= MAX_WORKING_HOURS) {
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

            System.out.println("Daily Wage= " + dailyWage);
        }

        System.out.println("Total Wage= " + totalWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        calculateEmployeeWage();
    }
}


