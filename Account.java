/*
 * @author (Laurel Christ)
 * <p> (Account)
 * <p> (Project 6)
 * <p> (Represents a basic account with basic functions like withdraw, deposit, link... etc)
 */

//superclass to savings and checking
public abstract class Account implements Filterable
{
	protected double _balance;
	public double getBalance() { return _balance; }

	protected String _name; 
	public String getName() { return _name; }

	protected Account _link; //type of account you are wanting to link, Savings or Checking  
	public Account getLink() { return _link; }

	//Default Constructor
	public Account()
	{
		_balance = 0;
		_name = "";
		_link = null;
	}

	//Overloaded Constructor
	public Account(String name)
	{
		_balance = 0;
		_name = name; 
		_link = null;
	}

	//Overloaded Constructor
	public Account(double bal, String name)
	{
		_balance = bal;
		_name = name; 
		_link = null;
	}

	//Overloaded Constructor 
	public Account(double bal, String name, Account link)
	{
		_balance = bal;
		_name = name; 
		_link = link;
	}
	
	//
	//given an account linkAcct, link this account with linkAcct
	//
	public boolean link(Account linkAcct)
	{
		//if the type of Account is null will not link
		if(linkAcct == null) return false;

		//if linking the same kind of account will not link
		if(linkAcct == this) return false;

		//unlinks the account
		this.unlink();

		//the accounts are linked both ways
		_link = linkAcct;
		_link._link = this;


		//when this._balance falls below minimum _link._balance will be used
		if (this._balance < this.getMinimum())
		{
			this._balance = linkAcct._balance;
		}

		//when _link._balance is over drafted this._balance will be used
		if (linkAcct._balance < linkAcct.getMinimum())
		{
			linkAcct._balance = this._balance;
		}

		return true;
	}

	//
	// Unlink the accounts in BOTH directions
	//
	public void unlink()
	{
		//will unlink if the link is not null
		if (_link != null)
		{
			_link._link = null;//unlink the linked account
			this._link = null; //unlink this account
		}

	}

	//
	//Not implemented in Account class 
	//
	public abstract boolean accept();

	//
	//withdraw a given amount of money from the account 
	//if over drafted from this account & it is linked, will take from the linked account
	//
	public void withdraw(double amt) throws InsufficientFundsException
	{	
		//if you can withdraw from only this account
		if (this._balance - amt >= this.getMinimum())
		{
			this._balance -= amt;
		}
		
		//checks to see if it is linked, or if both accounts have insufficient funds
		else if (this._link == null || _balance + _link._balance < amt || (((_balance + _link._balance) - (this.getMinimum() + _link.getMinimum())) < amt))
		{
			throw new InsufficientFundsException();
		}
		
		//need to withdraw from both accounts 
		else
		{
			//variable to keep track of balance below the minimum 
			double amt1 = 0;
			//max amount possible to withdraw
			amt1 += (_balance - this.getMinimum());
			
			//updates amt to be withdrawn from the link account 
			amt = amt - amt1;
			//updates the linked balance
			_link._balance -= amt;
			//amt moved from link account to this._balance
			_balance += amt; 
			//withdraws original requested amount
			_balance -= (amt + amt1);  
			
		}

	}

	//
	//deposits a given amount of money into the account
	//
	public void deposit(double amt) throws LinkAccountException
	{
		//adds the deposit amt to the balance
		_balance += amt;
	}

	//
	//finds the minimum required for the account
	//
	public abstract double getMinimum();

	//
	//given
	//
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) return false;

		if (!(obj instanceof Account)) return false;

		Account that = (Account)obj;

		if (Math.abs(_balance - that._balance) > 0.001) return false; 

		if (!_name.equals(that._name)) return false;

		if (_link != that._link) return false;

		return this == obj;
	}

	//given
	@Override
	public String toString()
	{
		String retS = "";

		retS += "account: " + _name + "\n";
		retS += "\tBalance: " + _balance + "\n";
		retS += "\tLink account name: " + _link._name;

		return retS;
	}
}