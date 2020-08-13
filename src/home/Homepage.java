package home;

import java.util.*;

public class Homepage {
		
	public static void main(String[] args) {
		// todo 네이버 블로그 게시판 기능
		// 공지 작성자 작성일 조회 좋아요(정렬) 페이지 검색(몇개씩 볼지)
	
		// 1. 댓글 따로따로	 - 완료
		// 2. 게시물 삭제하면 댓글도 삭제 - 완료
		// 3. 삭제하면 게시물 번호 어찌할지 - 냅두기
		// 4. 댓글 내용 수정 - 완료
		// 5. 제목 수정, 본문 수정 (삽입) - 완료
		// 6. 게시물 추가 공백 예외처리 - 완료
		// 7. 작성 날짜, 댓글 수, 전체 출력 시 내용 필요 x - 완료
		// 8. 좋아요 - 완료
		// 9. 게시판 정렬 - comment 부분 진행 중 
		
		HomepageManager home = new HomepageManager();		
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		while(true) {
			System.out.println("명령어를 입력하세요. [add, del, list, read, update, exit]");
			str = sc.nextLine();
			// 게시판 추가
			if(str.equals("add")) {
				home.add();	
			}
			// 게시물 삭제
			if(str.equals("del")) {
				home.delete();
			}
			// 모든 게시물 출력
			if(str.equals("list")) {
				home.printPage();
			}
			// 특정 게시물 출력 -> 해당 게시물에 대한 세부 명령 입력가능
			if(str.equals("read")) {
				home.readPage();
			}
			// 제목 수정, 내용 수정
			if(str.equals("update")) {
				home.updatePage();
			}	
			// 종료
			if(str.equals("exit")) {
				System.out.println("종료");
				break;
			}
		}
		
	}
	
}
