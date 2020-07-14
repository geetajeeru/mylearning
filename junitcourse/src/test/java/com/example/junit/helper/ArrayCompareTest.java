package com.example.junit.helper;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class ArrayCompareTest {

	@Test
	public void testArraySort() {
		int[] numbers = {12,3,4,1};
		int[] expected = {1,3,4,12};
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}
	
	@Test(expected = NullPointerException.class)
	public void testArraySort_Null() {
		int[] numbers = null;
		Arrays.sort(numbers);
	}
	
	@Test(timeout = 100)
	public void testSort_Performance() {
		int[] a = {12,2,0,3};
		for(int i=1; i<1000000;i++ ) {
			a[0] = i;
			Arrays.sort(a);
		}
	}

}
