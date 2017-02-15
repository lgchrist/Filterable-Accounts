/*
* @author (Laurel Christ)
* <p> (Checking)
* <p> (Project 6)
* <p> (Represents a checking account that has no minimum balance)
*/

public class Checking extends Account implements Filterable
{
	
	//Default Constructor
	public Checking()
	{
		super();
	}
	
	//Overloaded Constructor 
	public Checking(String name)
	{
		super(name);
	}
	
	//Overloaded Constructor
	public Checking(double bal, String name)
	{
		super(bal, name);
	}

	//
	//returns the minimum of the account 
	//
	public double getMinimum()
	{
		return 0;
	}
	
	//
	//returns true if linked to an account that is acceptable to link
	//
	public boolean accept()
	{
		//if it is an acceptable account to link
		if(this.link(_link))
		{
			return true;
		}
		return false;
	}

	
	//given
	@Override
    public boolean link(Account linkAcct)
    {
    	if (linkAcct == null) return false;
    	
		if (linkAcct instanceof Checking) return false;
		
		return super.link(linkAcct);
    }
	
	//given
    @Override
    public boolean equals(Object obj)
    {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof Checking)) return false;

    	return super.equals(obj);
    }
	
    //given
    @Override
    public String toString()
    {
    	return "Checking " + super.toString();
    }
}
