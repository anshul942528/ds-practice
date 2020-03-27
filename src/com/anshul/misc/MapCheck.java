package com.anshul.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapCheck {
	
	public static void main(String[] args) {
		Map<Integer, Integer> valueMap = new HashMap<>();
		printHashMap(valueMap);
		valueMap.put(1, 1);
		valueMap.put(2, 2);
		valueMap.put(3, 3);
		valueMap.put(4, 4);
		printHashMap(valueMap);
		valueMap.remove(1, 1);
		printHashMap(valueMap);
	}

	private static void printHashMap(Map<Integer, Integer> valueMap) {
		System.out.println("Size = " + valueMap.size());
		for(Entry<Integer, Integer> entry : valueMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
