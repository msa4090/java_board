package home;

import java.util.*;

public class Homepage {
		
	public static void main(String[] args) {		
		HomepageManager home = new HomepageManager();		
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		while(true) {
			System.out.println("명령어를 입력하세요. [test, add, del, list, read, update, search, exit]");
			str = sc.nextLine();
			// 테스트케이스 추가
			if(str.equals("test")) {
				home.makeTestcase();
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
				home.updatePage();
			}	
			// 특정 단어가 포함된 제목 찾기
			if(str.equals("search")) {
				home.searchTitle();
			}			
			// 종료
			if(str.equals("exit")) {
				System.out.println("종료");
				break;
			}
		}
		
	}
	
}
