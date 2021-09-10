package edu.awieclawski.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.AbstractMap.SimpleEntry;

public class CollectionUtils {

	/**
	 * returns true if any duplicate
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T> Boolean checkDuplicatesInList(List<T> list) {
		Boolean result = false;
		Set<T> set = new HashSet<>(list);
		if (set.size() < list.size()) {
			result = true;
		}
		return result;
	}

	/**
	 * Lists must be equal, or map gets lone size
	 * 
	 * @param lone Lis<?>
	 * @param ltwo Lis<?>
	 * @return
	 */
	public static Map<Object, Object> passEqualListsToMap(List<?> lone, List<?> ltwo) {

		Map<Object, Object> map = new HashMap<>();

		int size = Math.min(lone.size(), ltwo.size());

		IntStream.range(0, size).mapToObj(e -> new SimpleEntry<>(lone.get(e), ltwo.get(e)))
				.forEach(e -> map.put(e.getKey(), e.getValue()));

		return map;
	}

}
