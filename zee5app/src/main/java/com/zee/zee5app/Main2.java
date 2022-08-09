package com.zee.zee5app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2 {
	
	public static void main(String[] args) {
		List<Integer> list  = Arrays.asList(1,2,3,4,5,6,1,7,8,8,7,1);
		list.forEach(e->System.out.println(e));
		//list.forEach(System.out::println);     ==> only after method reference not use earlier
		System.out.println("Sorted list");
		Collections.sort(list);
		list.forEach(System.out::println);
	}
		
}
