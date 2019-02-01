package smartbatch;

import java.util.Arrays;

public class Client
{
	public static void main(String[] args)
	{
	ICICIBank bank = new ICICIBank();
	
	System.out.println(bank.createAccount(101, 5000));
	System.out.println(bank.createAccount(102, 5000));
	try
	{
		System.out.println("Balance is " +  bank.withdrawAmount(101, 1000));
	}
	catch(InvalidAccountNumberException ob)
	{
		System.out.println(ob);
	}
	catch(InsufficientBalanceException ob)
	{
		System.out.println(ob);
	}
	try
	{
		System.out.println("Balance: " + bank.depositAmount(102, 1000));
	}
	catch(InvalidAccountNumberException ob)
	{
		System.out.println(ob);
	}
	try
	{
		int ar[] = new int[2];
		System.arraycopy(bank.fundTransfer(102, 101, 4000), 0, ar, 0, 2);
		System.out.println("Balance: " + ar[0] + "\n" + "Balance2: " + ar[1]);
	}
	catch(InvalidAccountNumberException ob)
	{
		System.out.println(ob);
	}
	catch(InsufficientBalanceException ob)
	{
		System.out.println(ob);
	}
	
}
}