package Controller;

import java.util.Scanner;

public class MainController {
	
	void start() {
		MemberController mcr = new MemberController();
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		while(true) {
			System.out.println("수행하실 명령어를 입력하세요. (login : 로그인, sign up : 회원가입, exit : 종료)");
			str = sc.nextLine();
			
			if(str.equals("login")) {
				
			}
			
			if(str.equals("sign up")) {
				mcr.signUp();
			}
			
			if(str.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

}
