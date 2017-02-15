/*
* @author (Laurel Christ)
* <p> (InsufficientFundsException)
* <p> (Project 6)
* <p> (If a withdrawal operation is unsuccessful an InsufficientFundsException will be thrown)
*/
public class InsufficientFundsException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InsufficientFundsException() {}

	public InsufficientFundsException(String arg0)
    {
		super(arg0);
	}

	public InsufficientFundsException(Throwable arg0)
    {
		super(arg0);
	}

	public InsufficientFundsException(String arg0, Throwable arg1)
    {
		super(arg0, arg1);
    }

	public InsufficientFundsException(String arg0, Throwable arg1, boolean arg2, boolean arg3)
    {
		super(arg0, arg1, arg2, arg3);
	}

}
