package net.minixalpha.chap16;

import java.math.BigDecimal;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

class BigDecimalGenerator implements Generator<BigDecimal> {
	static BigDecimal bd = new BigDecimal(0);
	static BigDecimal step = new BigDecimal(1);

	@Override
	public BigDecimal next() {
		bd.add(step);
		return bd;
	}

}

public class Ex17 {
	public static void main(String[] args) {
		BigDecimal[] bds = Generated.array(BigDecimal.class,
				new BigDecimalGenerator(), 3);
	}

}
