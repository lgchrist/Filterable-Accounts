/*
 * @author (Laurel Christ)
 * <p> (CappedChecking)
 * <p> (Project 6)
 * <p> (Represents a checking account that disallows a balance above a particular maximum value)
 */
public class CappedChecking extends Checking 
{
	public static double MAX_AMOUNT = 10000;

	//Default Constructor
	public CappedChecking()
	{
		super();

	}

	//Overloaded Constructor
	public CappedChecking(String name)
	{
		super(name);

	}

	//
	//Will deposit the desired amount up until the MAX_AMOUNT allowed and then will deposit the rest in the linked account
	//
	@Override 
	public void deposit(double dpst) throws LinkAccountException
	{

		//checks to see if the deposit amount will exceed the MAX_AMOUNT
		if (this._balance + dpst <= MAX_AMOUNT)
		{
			if (dpst == 0)
			{
				throw new LinkAccountException();
				
			}
			
			//will deposit the amount into the account if less than the MAX_AMOUNT
			else
				this._balance += dpst;
			
		}
		
		//if there is no link will throw an exception 
		else if( this._link == null)
		{
			throw new LinkAccountException();
			
		}
		
		//will end up depositing into both accounts
		else
		{
			//finding amt over MAX_AMOUNT
			dpst -= (MAX_AMOUNT - _balance);
			
			//subtract amt so equal to MAX_AMOUNT
			this._balance += (MAX_AMOUNT - this._balance);
			
			//adds the overflow into the linked account
			_link._balance += dpst;
		}

	} 

	//given
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) return false;

		if (!(obj instanceof CappedChecking)) return false;

		return super.equals(obj);
	}

	//given
	@Override
	public String toString()
	{
		return "Capped-Checking " + super.toString();
	}
}
