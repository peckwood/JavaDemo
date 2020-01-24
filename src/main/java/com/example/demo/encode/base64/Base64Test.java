package com.example.demo.encode.base64;

import org.apache.commons.codec.binary.Base64;

public class Base64Test {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		String originalInput = "test input";
		Base64 base64 = new Base64();
		String encodedString = new String(base64.encode(originalInput.getBytes()));
		System.out.println("encodedString "+ encodedString);
		
		String decodedString = new String(base64.decode(encodedString.getBytes()));
		System.out.println("decodedString "+ decodedString);
		
		String originalInput1 = "test input1";
		String encodedString1 = new String(Base64.encodeBase64(originalInput1.getBytes()));
		String decodedString1 = new String(Base64.decodeBase64(encodedString1.getBytes()));
		System.out.println("encodedString1 "+ encodedString1);
		System.out.println("decodedString1 "+ decodedString1);
		
		
		System.out.println("base64.isBase64(originalInput); "+ Base64.isBase64(originalInput));
		
		System.out.println("base64.isBase64(encodedString); "+ Base64.isBase64(encodedString));
		;
		System.out.println("base64.isBase64(decodedString) "+ Base64.isBase64(decodedString));

	}
	
}
