package home;

import java.util.*;
import member.MemberManager;

public class Homepage {
		
	public static void main(String[] args) {		
		HomepageManager home = new HomepageManager();	
		MemberManager mm = new MemberManager();
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		while(true) {			
			System.out.println("명령어를 입력하세요. [test, sign up, member list, add, del, list, read, update, search, help, exit]");
			str = sc.nextLine();
			// 테스트케이스 추가
			if(str.equals("test")) {
				home.makeTestdata();
			}			
			// 회원가입
			if(str.equals("sign up")) {
				mm.signUp();
			}
			// 회원목록 출력
			if(str.equals("member list")) {
				mm.printMemeberList();
			}
			// 게시물 추가
			if(str.equals("add")) {
				home.add();	
			}
			// 게시물 삭제
			if(str.equals("del")) {
				home.delete();
			}
			// 모든 게시물 출력
			if(str.equals("list")) {
				home.sortPage();
			}
			// 특정 게시물 출력 -> 해당 게시물에 대한 세부 명령 입력가능
			if(str.equals("read")) {
				home.readPage();
			}
			// 제목 수정, 내용 수정
			if(str.equals("update")) {
				home.updatePost();
			}	
			// 특정 단어가 포함된 제목 찾기
			if(str.equals("search")) {
				home.searchTitle();
			}
			// 도움말 출력
			if(str.equals("help")) {
				
			}
			// 종료
			if(str.equals("exit")) {
				System.out.println("종료");
				break;
			}
		}
		
	}
	
}
