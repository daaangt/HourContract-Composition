package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entities.enums.WorkerLevel;
import entities.HourContract;

public class Worker 
{
	private String Department;	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private List<HourContract> workerContracts = new ArrayList<>();
	
	public Worker(String name, WorkerLevel level, Double baseSalary)
	{
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
	}
	
	public Worker(String name, WorkerLevel level)
	{
		this.name = name;
		this.level = level;
	}	
	
	public Worker(String name)
	{
		this.name = name;
	}		
	
	public Worker() { }

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public WorkerLevel getLevel() 
	{
		return level;
	}

	public void setLevel(WorkerLevel level) 
	{
		this.level = level;
	}

	public Double getBaseSalary() 
	{
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) 
	{
		this.baseSalary = baseSalary;
	}

	public List<HourContract> getWorkerContracts() 
	{
		return workerContracts;
	}

	public String getDepartment() 
	{
		return Department;
	}

	public void setDepartment(String department)
	{
		Department = department;
	}	
	
	public void addContract(HourContract contract)
	{
		workerContracts.add(contract);
	}
	
	public void removeContract(HourContract contract)
	{
		workerContracts.remove(contract);
	}
	
	public Double income(Integer month, Integer year)
	{
		double value = baseSalary;
		
		for(HourContract wc : workerContracts)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(wc.date);
			
			if(month == calendar.get(Calendar.MONTH) && year == calendar.get(Calendar.YEAR))
			{
				value += wc.totalValue();
			}
		}
		return value;
	}
}
