
package com.concurrencyLearning.concurrenthashmap;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
public static void main(String[] args) {
	Map<String,Integer> chm = new ConcurrentHashMap<>();
	Map<String, Integer> hashMap = new HashMap<>();
	Map<String, Integer> syncMap = Collections.synchronizedMap(hashMap);
	MapHelper1 mapHelper1 = new MapHelper1(chm);
	MapHelper2 mapHelper2 = new MapHelper2(chm);
	MapHelper3 mapHelper3 = new MapHelper3(chm);
	MapHelper4 mapHelper4 = new MapHelper4(chm);
	Thread clsq1;

	for (Map.Entry<String, Integer> e : syncMap.entrySet()) {
		System.out.println(e.getKey() + "=" + e.getValue());
	}

}
}
