package home;

import java.util.*;

public class DetailPage {
	Scanner sc = new Scanner(System.in);
	
	// 댓글 달기
	String addComments(int commentCount) {
		System.out.println("댓글을 입력하세요.");		
		
		return commentCount + ") "  + sc.nextLine();
	}	
}

