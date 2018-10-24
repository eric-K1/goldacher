package goldacher;

import java.math.BigInteger;
import java.util.Iterator;

public class PrimeIter implements Iterator<BigInteger> {
	
	BigInteger cur = BigInteger.TWO;
	
	private static boolean isPrime(BigInteger p) {
		BigInteger sqr = p.sqrt().add(BigInteger.ONE);
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
