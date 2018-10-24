package goldacher;

import java.math.BigInteger;
import java.util.Iterator;

public class PrimeIter implements Iterator<BigInteger> {
	
	BigInteger cur = BigInteger.valueOf(2);
	
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
		BigInteger sqr = sqrt(q).add(BigInteger.ONE);
		for(BigInteger q = BigInteger.valueOf(2); q.compareTo(sqr) < 0; q.add(BigInteger.ONE))
		{
			if(p.mod(q) == BigInteger.ZERO)
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
		while(!isPrime(nxt))
			nxt = nxt.add(BigInteger.ONE);
		
		BigInteger old = cur;
		cur = nxt;
		
		return old;
	}
}
