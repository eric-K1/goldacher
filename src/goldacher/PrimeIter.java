package goldacher;

import java.math.BigInteger;
import java.util.Iterator;

public class PrimeIter implements Iterator<BigInteger> {

	private static final BigInteger TWO = BigInteger.valueOf(2);
	private static final BigInteger THREE = BigInteger.valueOf(3);
	private static final BigInteger FIVE = BigInteger.valueOf(5);
	private static final BigInteger SIX = BigInteger.valueOf(6);
	
	BigInteger cur = BigInteger.ONE;
	boolean didAMinus = false;
	boolean checkedFirsts = false;
	
	private static BigInteger sqrt(BigInteger x) {
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    // Loop until we hit the same value twice in a row, or wind
	    // up alternating.
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}
	
	private static boolean isPrime(BigInteger p) {
		BigInteger sqr = sqrt(p).add(BigInteger.ONE);
		for(BigInteger q = BigInteger.valueOf(2); q.compareTo(sqr) < 0; q=q.add(BigInteger.ONE))
		{
			if(p.mod(q).equals(BigInteger.ZERO))
				return false;
		}
		
		return true;
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public BigInteger next() {
		// TODO Currently stupid
		BigInteger nxt = cur.add(BigInteger.ONE);
		
		if(!checkedFirsts)
		{
			if(cur.compareTo(TWO) < 0)
			{
				cur = TWO;
				return TWO;
			}
			if(cur.compareTo(THREE) < 0)
			{
				checkedFirsts=true;
				//cur = THREE;

				
				cur = SIX;
				return THREE;
			}
			/*if(cur.compareTo(FIVE) < 0)
			{
				
				checkedFirsts=true;
				cur = FIVE;
				return FIVE;
			}*/
		}
		
		boolean found = false;
		nxt=cur;
		
		while(!found)
		{
			if(!didAMinus && isPrime(nxt.subtract(BigInteger.ONE)))
			{
				cur = nxt;
				didAMinus = true;
				return nxt.subtract(BigInteger.ONE);
			}
			if(isPrime(nxt.add(BigInteger.ONE)))
			{
				cur = nxt.add(SIX);
				didAMinus = false;
				return nxt.add(BigInteger.ONE);
			}
			nxt = nxt.add(SIX);
		}
		
		BigInteger old = cur;
		cur = nxt;
		
		return old;
	}
}
