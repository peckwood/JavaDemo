package com.example.demo.string.string_trim;

public class TrimmerTest {
	public static void main(String[] args) {
//		String a = null;
//		a.trim();
//		boolean isSpace = Character.isWhitespace('　');
//		System.out.println(isSpace);

		Character space = ' ';// 半角空格
		Character space1 = '　';// 全角空格
		Character space2 = ' ';// 不间断空格 https://blog.csdn.net/lewky_liu/article/details/79353151

		char[] charArray = { space, space1, space2 };
		for (char c : charArray) {
			System.out.println(c - 0);
			System.out.println(Character.isWhitespace(c));
			System.out.println(Character.isWhitespace(c - 0));
			System.out.println();
		}

		String b = "萌妹猫咪球 ";
		 String c = trimIncludingChinese(b);
		 System.out.println("|" + c+ "|");
	}

	private static String trimIncludingChinese(String str) {
		int len = str.length();
		int st = 0;
		char[] val = str.toCharArray(); /* avoid getfield opcode */

		//160 is &nbsp, Character.isWhitespace() includes 12288 char(全角空格)
		while ((st < len) && (val[st] <= ' ' || val[st] == 160 || Character.isWhitespace(val[st] - 0) )) {
			st++;
		}

		while ((st < len) && (val[len - 1] <= ' ' || val[len - 1] == 160 ||  Character.isWhitespace(val[len - 1] - 0))) {
			len--;
		}

		return ((st > 0) || (len < str.length())) ? str.substring(st, len) : str;
	}
}
