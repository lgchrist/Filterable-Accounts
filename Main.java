/*
* @author (Laurel Christ)
* <p> (Main)
* <p> (Project 6)
* <p> (The main to test Account and Bank)
*/
public class Main
{
	public static void main(String[] args)
    {
        AccountTester acctTester = new AccountTester();
        BankTester bankTester = new BankTester();

		System.out.println("\nAccount Tests:\n");
        acctTester.runAll();
        
		System.out.println("\nBank Tests:\n");
        bankTester.runAll();
	}
}
