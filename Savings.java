/*
 * @author (Laurel Christ)
 * <p> (Savings)
 * <p> (Project 6)
 * <p> (Represents a checking account that must maintain a minimum balance)
 */
public class Savings extends Account implements Filterable 
{
	
	public static double MIN_AMOUNT = 100;


	//Default Constructor
	public Savings()
	{
		super();
	}

	//Overloaded Constructor
	public Savings(String name)
	{
		super(name);
	}
	
	//Overloaded Constructor
	public Savings(double bal, String name)
	{
		super(bal, name);
	}

	//
	//Returns true if it maintains at least the minimum account
	//
	public boolean accept()
	{
		if(_balance >= MIN_AMOUNT)
		{
			return true;
		}
		return false;
	}

	
	//
	//Returns the minimum amount the account must maintain
	//
	@Override 
	public double getMinimum()
	{
		return 100;
	}
	
	//given
	@Override
	public boolean link(Account linkAcct)
	{
		if (linkAcct == null) return false;

		if (linkAcct instanceof Savings) return false;

		return super.link(linkAcct);
	}
	
	//given
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) return false;

		if (!(obj instanceof Savings)) return false;

		return super.equals(obj);
	}

	//given
	@Override
	public String toString()
	{
		return "Savings " + super.toString();
	}
}
