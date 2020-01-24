package com.example.demo.string.censor_username;

public class CensorUsername {

	public static void main(String[] args) {
		//01 2 3 4 56
		//censorUserNickname("🐧花企鹅🐧");
		//0 12 3 4 5
		censorUserNickname("丽🐧加狗子");
	}

	public static String censorUserNickname(String userNickname) {
		for(int i=0;i<userNickname.length();i++) {
			System.out.println("userNickname.codePointCount(0, "+i+"); " + userNickname.codePointCount(0, i));
			System.out.println("userNickname.codePointBefore("+(i+1)+") " + userNickname.codePointBefore(i+1));
			System.out.println( userNickname.offsetByCodePoints(i, 1));
			System.out.println( userNickname.offsetByCodePoints(userNickname.length()-i, -1));
			System.out.println();
		}
		
		
		
		if (userNickname == null || userNickname.trim().isEmpty()) {
			return "";
		}
		userNickname = userNickname.trim();
		// 大于等于3位的, 昵称保留首尾字符，隐去中间字段，（如：asg显示a**g）
		if (getNumberOfUnicodeCharacter(userNickname) > 2) {
			for(int i=0;i<userNickname.length();i++) {
				System.out.println("codePoint: " + userNickname.codePointAt(i));
			}
			System.out.println("userNickname.codePointCount(0, 0); " + userNickname.codePointCount(0, 0));
			System.out.println("userNickname.codePointCount(0, 1); " + userNickname.codePointCount(0, 1));
			System.out.println("userNickname.codePointCount(0, 2); " + userNickname.codePointCount(0, 2));
			System.out.println("userNickname.codePointCount(0, 3); " + userNickname.codePointCount(0, 3));
			System.out.println("userNickname.codePointCount(0, 4); " + userNickname.codePointCount(0, 4));
			System.out.println("userNickname.codePointCount(0, 5); " + userNickname.codePointCount(0, 5));
			System.out.println("userNickname.codePointBefore(1) " + userNickname.codePointBefore(1));
			System.out.println("userNickname.codePointBefore(2) " + userNickname.codePointBefore(2));
			System.out.println("userNickname.codePointBefore(3) " + userNickname.codePointBefore(3));
			System.out.println("userNickname.codePointBefore(4) " + userNickname.codePointBefore(4));
			System.out.println("userNickname.codePointBefore(5) " + userNickname.codePointBefore(5));
			//String s1 = userNickname.substring(0, 1);
			int offset = userNickname.offsetByCodePoints(0, 1);
			String s1 = userNickname.substring(0, offset);
			String s2 = "**";
			int length = userNickname.length();
			int lastCharIndex = length - 1;
			int secondLastUnicodeIndex = userNickname.offsetByCodePoints(lastCharIndex, -1);
			int startIndex = secondLastUnicodeIndex+1;
			String s3 = userNickname.substring(startIndex, userNickname.length());
			
			int lastUnicodeStartIndex = userNickname.offsetByCodePoints(userNickname.length(), -1);
			String s4 = userNickname.substring(lastUnicodeStartIndex, userNickname.length());
			System.out.println("from length: " + userNickname.offsetByCodePoints(userNickname.length(), -1));
			
			String result = s1 + s2 + s4;
			System.out.println("result: " + result);
			return result;
			// 小于3位的, 不打码
		} else {
			return userNickname;
		}
	}
	private static int getNumberOfUnicodeCharacter(String s) {
		if(s==null) {
			return 0;
		}else {
			return s.codePointCount(0, s.length());
		}
	}
}
