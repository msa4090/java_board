package test;

import java.util.Scanner;

public class TestMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = "";
		TestJson writeJson = new TestJson();
		
		while(true) {
			System.out.println("write, read, change, print, exit");
			str = sc.nextLine();	
			
			if(str.equals("write")) {
				writeJson.write();
			}
			
			if(str.equals("read")) {
				writeJson.addList();
			}
			
			if(str.equals("change")) {
				writeJson.change();
			}
			
			if(str.equals("print")) {
				writeJson.print();
			}
			
			if(str.equals("exit")) {
				break;
			}
		}
		
	}

}
