
import java.util.*;

public class EmployeeWageCalculation1 {

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
