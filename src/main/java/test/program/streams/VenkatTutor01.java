package test.program.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class VenkatTutor01 {

	public static void main(String[] args) {
		final List<BigDecimal> prices = Arrays.asList(new BigDecimal("10"),new BigDecimal("30"),
				new BigDecimal("17"),new BigDecimal("20"),new BigDecimal("15"),new BigDecimal("18"),
				new BigDecimal("45"), new BigDecimal("12"));
		
		oldJamanaWay(prices);
		
		
		streamsWay(prices);
	}

	private static void oldJamanaWay(final List<BigDecimal> prices) {
		BigDecimal totalDiscountedPrice = BigDecimal.ZERO;
		for(BigDecimal price: prices) {
			if(price.compareTo(BigDecimal.valueOf(20)) > 0) {
				totalDiscountedPrice = totalDiscountedPrice.add(price.multiply(BigDecimal.valueOf(0.9)));
			}
		}
		System.out.println(" Old way: "+totalDiscountedPrice);
	}

	private static void streamsWay(final List<BigDecimal> prices) {
		BigDecimal totalDiscountedPrice = prices.stream()
				.filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
		        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
		        .reduce(BigDecimal.ZERO, BigDecimal::add);
		
		System.out.println(" Streams way: "+totalDiscountedPrice);
	}

}
