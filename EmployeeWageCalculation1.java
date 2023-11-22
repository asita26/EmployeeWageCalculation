
import java.util.*;

public class EmployeeWageCalculation1 {
	private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;
    private static final int WORKING_DAYS_IN_MONTH = 20;
    private static final int MAX_WORKING_HOURS = 100;
    private static final int MAX_WORKING_DAYS = 20;
	static int checkingAttendance()
    {
    	  Random random = new Random();
          return random.nextInt(3); // 0 for absent, 1 for full time, 2 for part time
    }

	static void UC1() 
	{
        int empCheck=checkingAttendance();
        if(empCheck == FULL_TIME) System.out.println("Employee is Present");
        else System.out.println("Employee is Absent");

    }
    static void UC2() // for FULL_TIME
    {
    	int empHours=0;
    	int empWage=0;
    	int empCheck=checkingAttendance();
        
        if(empCheck == FULL_TIME)
        {
          empHours=FULL_DAY_HOURS;
          empWage=empHours*WAGE_PER_HOUR;
          System.out.println("Daily wage for full-time employee - $"+empWage);
        } 
        
        else 
        {
          System.out.println("Employee is absent.");
        } 
 
    }

	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in);
        
     
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.println("Please let us know what details you want to know from the following options:");
		System.out.println("If you want to check employee attendance, enter 1");
		System.out.println("If you want to check daily employee wage for a full time employee, enter 2");
		System.out.println("If you want to check daily employee wage for a part time employee, enter 3");
		System.out.println("If you want to calculate wages for a month, enter 4");
		System.out.println("If you want to calculate wages for maximum working hours and maximum working days, enter 5");
	   int option = sc.nextInt();
		switch(option)
		{
		    case 1: UC1();
		    break;
            case 2: UC2();
	        break;
		    case 3: UC3();
	        break;
		    case 4: UC5();
	        break;
		    case 5: UC6();
            break;
		default: System.out.println("You have entered an invalid option");
		break;
		}
	}
}
