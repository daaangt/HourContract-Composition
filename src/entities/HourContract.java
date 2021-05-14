package entities;

import java.util.Date;

public class HourContract 
{
	public Date date;
	public Double valuePerHour;
	public Integer hours;
	
	public HourContract(Date date, Double valuePerHour, Integer hours)
	{
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Double totalValue()
	{
		return valuePerHour * hours;
	}
}
