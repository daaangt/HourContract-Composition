import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main 
{
	public static void main(String[] args) throws ParseException 
	{	
		Locale.setDefault(Locale.US);
		Scanner inputdata = new Scanner(System.in);
		Worker worker = new Worker();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");	
		
		System.out.println("Enter the name of the department:");
		worker.setDepartment(inputdata.nextLine());
		
		System.out.println("Enter worker data:");
		
		System.out.println("Name:");
		worker.setName(inputdata.nextLine());
		
		System.out.println("Level:");
		worker.setLevel(WorkerLevel.valueOf(inputdata.nextLine()));
		
		System.out.println("Base salary:");
		worker.setBaseSalary(inputdata.nextDouble());
		
		System.out.println("How many contracts to this worker?");
		int numberOfContracts = inputdata.nextInt();
		
		for(int i = 0; i < numberOfContracts; i++)
		{
			inputdata.nextLine();
			System.out.println("Enter contract #" + (i+1) + " data:");
			
			System.out.println("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(inputdata.nextLine());
			
			System.out.println("Value per hour: ");
			Double valuePerHour = inputdata.nextDouble();
			
			System.out.println("Duration (hours): ");
			int hours = inputdata.nextInt();
			
			worker.addContract(new HourContract(date, valuePerHour, hours));
		}
		
		inputdata.nextLine();
		
		System.out.println("Enter mounth and year to calculate income (MM/YYYY): ");
		Date date = sdf1.parse(inputdata.nextLine());
	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);		
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment());
		System.out.println("Department: " + worker.income(calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));	
		
		inputdata.close();
	}	
}
