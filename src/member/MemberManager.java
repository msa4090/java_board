package member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {
	Scanner sc = new Scanner(System.in);	
	ArrayList<MemberClass> memList = new ArrayList();
	private int count = 1;
	// 회원가입
	public void signUp() {
		MemberClass mc = new MemberClass();
		String str = "";
		int check = 0;
		
		System.out.println("아이디를 입력하세요.");
		str = sc.nextLine();
		check = checkOverlapId(str);
		if(check == -1) {
			System.out.println("중복된 아이디가 존재합니다. 아이디를 다시 입력하세요.");
			signUp();
		} else {
			mc.setUserId(str);
		}
		
		System.out.println("비밀번호를 입력하세요.");
		mc.setUserPw(sc.nextLine());
		
		System.out.println("이름을 입력하세요.");
		mc.setUserName(sc.nextLine());
		
		mc.setUserIndex(count);
		count++;
		
		memList.add(mc);
	}
	// 회원리스트 출력
	public void printMemeberList() {
		for(int i = 0; i < memList.size(); i++) {
			System.out.println(memList.get(i).getUserIndex() + ". 아이디 : " + memList.get(i).getUserId() + " 이름 : " + memList.get(i).getUserName());
		}
	}
	// 아이디 중복체크
	int checkOverlapId(String str) {
		for(int i = 0; i < memList.size(); i++) {
			if(str.equals(memList.get(i).getUserId())) {
				return -1;
			}
		}
		return 0;
	}

}
