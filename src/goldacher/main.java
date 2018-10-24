package goldacher;

import java.math.BigInteger;
import java.util.Timer;


public class main {
	public static void main(String [] args) {
		Timer timer = new Timer();
		ArithIter itrEven =  new ArithIter(BigInteger.valueOf(0), BigInteger.valueOf(2));
		while(itrEven.hasNext()) {
			BigInteger even = itrEven.next();
			System.out.println(even);
			/*PrimeIter itrPrime =  new PrimeIter();
			while(itrPrime.hasNext()) {
				BigInteger prime = itrPrime.next();
				if(even.compareTo(prime) >0) {
					break;
				}
				BigInteger primecheck = even.subtract(prime);
				PrimeIter itrPrime1 =  new PrimeIter();
				while(itrPrime1.hasNext()) {
					BigInteger temp = itrPrime.next();
					if(temp.compareTo(even) >0) {
						break;
					}
					if(temp.equals(primecheck)) {
						System.out.println("checked : "+even+ ","+ "time" +timer);
					}
				}
			}*/
		}
	}
}
