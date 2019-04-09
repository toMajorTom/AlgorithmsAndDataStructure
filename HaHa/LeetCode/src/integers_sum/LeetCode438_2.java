package integers_sum;

import java.util.ArrayList;
import java.util.List;

/*  
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
 */

//�������һ���ַ��� s  p = "abc"   ������s�����е� p�ı�λ�ʵĳ�ʼ����  �� abc acb bac bca cab cba 
public class LeetCode438_2 {
	public List<Integer> findAnagrams(String s, String p) {
		// ʹ�û�������
		List<Integer> res = new ArrayList<>();
		//s�ĳ���һ��Ҫ��p���Ĵ�
        if (s.length() < p.length()) {
            return res;
        }
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
        }
        int l = 0, r = -1;
        while (l <= s.length() - 1) {
			//��¼����ǵ�һ�γ��ֵ��ַ�  �����freq  r �����ƶ�
			if (r + 1 < s.length() && freqS[s.charAt(r + 1) - 'a'] < freqP[s.charAt(r + 1) - 'a']) {
				freqS[s.charAt(++r) - 'a']++;
			}
			else {
				freqS[s.charAt(l++) - 'a']--;
			}
			if (r - l + 1 == p.length()) {
                res.add(l);
            }
		}
        return res;
	}

	public static void main(String[] args) {
		LeetCode438_2 test = new LeetCode438_2();
		String s = "cbaebabacd";
		System.out.println(test.findAnagrams(s, "abc"));
	}
}