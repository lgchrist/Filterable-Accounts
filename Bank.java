/*
* @author (Laurel Christ)
* <p> (Bank)
* <p> (Project 6)
* <p> (A repository for different accounts and retrieving filtered accounts, and the size of the bank, savings and checking)
*/
import java.util.ArrayList;

public class Bank
{
	//ArrayList to hold the accounts
	ArrayList<Account> _accounts; 
	
	//Default Constructor 
	public Bank()
	{
		_accounts = new ArrayList<Account>();
	}
	
	//adds an account to Bank, can't add duplicates
	public boolean addAccount(Account acct)
	{
		//will not add an account if it is already in the bank
		if (_accounts.contains(acct)) return false; 
		
		_accounts.add(acct);
		return true;

	}
	
	//returns the ArrayList of Account objects, that are accepted based on the Account specific requirements
	public ArrayList<Account> getFiltered()
	{
		//ArrayList to keep track of the accepted filtered accounts 
		ArrayList<Account> _filtered = new ArrayList<Account>();
		
		//traverses _accounts to check for accepted accounts
		for(int index = 0; index < _accounts.size(); index++)
		{
			//if the account meets the accepted requirements it will be added
			if(_accounts.get(index).accept())
			{
				_filtered.add(_accounts.get(index));
			}
		}
		

		return _filtered;
	}
	
	//returns the number of accounts stored in the Bank
	public int size()
	{
		return _accounts.size(); 
	}
	
}
