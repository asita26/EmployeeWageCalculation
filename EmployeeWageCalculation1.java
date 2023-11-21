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

    static void UC3() // for PART_TIME
    {
    	int empHours=0;
    	int empWage=0;
    	double empCheck = Math.floor(Math.random()*10)%2;
        
        if(empCheck == PART_TIME)
        {
          empHours=PART_TIME_HOURS;
          empWage=empHours*WAGE_PER_HOUR;
          System.out.println("Daily wage for part-time employee - $"+empWage);
        } 
        
        else 
        {
          System.out.println("Employee is absent.");
        } 
 
    }

    static void UC5() // Calculating wages for a month
    {
    	int dailyWagePerDay_FT=WAGE_PER_HOUR*FULL_DAY_HOURS;
    	int dailyWagePerDay_PT=WAGE_PER_HOUR*PART_TIME_HOURS;
    	int monthlyWageFullTime=0;
    	int monthlyWagePartTime=0;

    	for(int i=1; i<=20; i++)
    	{
    		int attendance=checkingAttendance();
    // 		int dailywage=0;
    		switch(attendance)
    		{
    			case FULL_TIME:
                    monthlyWageFullTime = monthlyWageFullTime + dailyWagePerDay_FT ;
                    break;
                case PART_TIME:
                    monthlyWagePartTime = monthlyWagePartTime + dailyWagePerDay_PT ;
                    break;
                default:
                    // Employee is absent
                    break;
            }
            //  System.out.println("Day " + i + ": Attendance - " + attendance +
            //         ", Daily Wage - $" + dailyWage + ", Total Wage - $" + totalWage);
    	}
    	
    	System.out.println("Monthly wages for a full-time employee - $" +monthlyWageFullTime);
    	System.out.println("Monthly wages for a part-time employee - $" +monthlyWagePartTime);
    }


 

    static void UC6()
    {
    	int totalWorkingHours = 0;
        int totalWorkingDays = 0;
        int totalWage = 0;
        
        while (totalWorkingDays < MAX_WORKING_DAYS && totalWorkingHours < MAX_WORKING_HOURS) 
        {
            int attendance = checkingAttendance();
            int dailyWage = 0;

            switch (attendance) 
            {
                case FULL_TIME:
                    dailyWage = FULL_DAY_HOURS*WAGE_PER_HOUR;
                    break;
                case PART_TIME:
                    dailyWage = WAGE_PER_HOUR*PART_TIME_HOURS;
                    break;
                default:
                    // Employee is absent
                    break;
           }

            totalWorkingDays++;
            totalWorkingHours += (attendance == FULL_TIME) ? FULL_DAY_HOURS : PART_TIME_HOURS;
            totalWage += dailyWage;

            System.out.println("Day " + totalWorkingDays + ": Attendance - " + attendance + ", Daily Wage - $" + dailyWage + ", Total Wage - $" + totalWage);
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
