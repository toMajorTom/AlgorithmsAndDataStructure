package jianzhiOffer;

import java.util.HashMap;

/*
 * 	在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 
 * 	如果没有则返回 -1（需要区分大小写）.
 */
public class offer21 {
	public int FirstNotRepeatingChar(String str) {
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);
		}
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(map.get(c) == 1)
				return i;
		}
		return -1;
    }
}