package goldacher;

import java.math.BigInteger;
import java.util.Timer;


public class main {
	public static void main(String [] args) {
		ArithIter itrEven =  new ArithIter(BigInteger.valueOf(2), BigInteger.valueOf(2));
		while(itrEven.hasNext()) {
			BigInteger even = itrEven.next();
			PrimeIter itrPrime =  new PrimeIter();
			long startTime = System.nanoTime();
			while(itrPrime.hasNext()) {
				BigInteger prime = itrPrime.next();
				if(even.compareTo(prime) <=0) {
					break;
				}
				BigInteger primecheck = even.subtract(prime);
				PrimeIter itrPrime1 =  new PrimeIter();
				while(itrPrime1.hasNext()) {
					BigInteger temp = itrPrime1.next();
					if(temp.compareTo(primecheck) > 0) {
						break;
					}
					if(temp.equals(primecheck)) {
						long endTime = System.nanoTime();
						System.out.println("checked : "+even+ "=" + prime +"+" +primecheck+ ", time: " + ((endTime - startTime)/1000000000.0) +" seconds.");
					}
				}
			}
		}
	}
}
