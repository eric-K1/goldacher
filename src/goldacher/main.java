package goldacher;

import java.math.BigInteger;

public class main {
	public static void main(String[] args)
	{PrimeIter it = new PrimeIter(); 
		BigInteger p = it.next();
		for(; ;p = it.next())
		{
			System.out.println(p.toString());
		}
	}
}
