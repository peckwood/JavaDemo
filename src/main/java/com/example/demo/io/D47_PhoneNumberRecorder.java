package com.example.demo.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class D47_PhoneNumberRecorder{
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		File outputFile = new File("phoneNumberList.txt");
		FileWriter writer = new FileWriter(outputFile);
		System.out.println("请输入姓名和电话号码");
		while(input.hasNextLine()){
			String inputText = input.nextLine();
			if("Done".equals(inputText)){
				break;
			}
			//用户输入了一个用逗号分隔的列表
			if(inputText.indexOf(",")>-1){
				
				String[] phoneNumbers = inputText.split(",");
				for(String phoneNumberRow:phoneNumbers){
					writeStringToFile(writer, phoneNumberRow.trim()+System.lineSeparator());
				}
				writer.close();
				System.out.println("列表已经存入文件中, 内容为:");
				showFileContents(outputFile);
				break;
			}else{
				writeStringToFile(writer, inputText.trim()+System.lineSeparator());
				System.out.println("信息已经存入文件中");
				System.out.println("请输入姓名和电话号码, 输入'Done'结束");
			}
		}
		if(writer!=null){
			writer.close();
		}
		input.close();
	}
	
	private static void writeStringToFile(FileWriter writer, String phoneNumberRow) throws IOException{
		writer.write(phoneNumberRow);
	}
	private static void showFileContents(File file) throws IOException{
		FileReader reader = new FileReader(file);
		char[] cbuf = new char[128];
		int charsRead = -1;
		while ((charsRead = reader.read(cbuf))!=-1) {
			System.out.println(new String(cbuf, 0, charsRead));
		}
		reader.close();
	}
}
