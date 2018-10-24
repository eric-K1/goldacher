package goldacher;

import java.math.BigInteger;
import java.util.*;

public class ArithIter implements Iterator<BigInteger>{

	private BigInteger curr;
	private BigInteger step;
	
	public ArithIter(BigInteger base, BigInteger step){
		this.curr = base;
		this.step = step;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public BigInteger next() {
		// TODO Auto-generated method stub
		return curr.add(step);
	}
	
}
