package smartbatch;

import java.util.LinkedList;

public class ICICIBank {
	
	
	LinkedList<Account> accounts=new LinkedList<>();
	
	
	public String createAccount(int accountNumber,int amount)
	{
		Account account = new Account(accountNumber,amount);
		
		accounts.add(account);
		
		return "account created successfully";
	}
	
	private Account searchAccount(int accountNumber) throws InvalidAccountNumberException
	{
		
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
		
	}
	
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account account=searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
	}
	public int depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException
	{
		Account account=searchAccount(accountNumber);
		
		if((account.getAccountNumber()==accountNumber))
		{
			account.setAmount(account.getAmount()+amount);
			return account.getAmount();
		}
		
		throw new InvalidAccountNumberException();
	}
	public int[] fundTransfer(int accountNumber1, int accountNumber2, int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		int ar[] = new int[2];
		Account account1 = searchAccount(accountNumber1);
		Account account2 = searchAccount(accountNumber2);
		if((account1.getAccountNumber()==accountNumber1) && (account2.getAccountNumber()==accountNumber2))
				{
					if(account1.getAmount()-amount>=0)
					{
						account1.setAmount(account1.getAmount()-amount);
						account2.setAmount(account2.getAmount()+amount);
						ar[0] = account1.getAmount();
						ar[1] = account2.getAmount();
						return ar;
					}
				}
			throw new InsufficientBalanceException();
	}

}