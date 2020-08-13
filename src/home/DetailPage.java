package home;

import java.text.SimpleDateFormat;
import java.util.*;

public class DetailPage {
	Scanner sc = new Scanner(System.in);
	
	// 댓글 달기
	String addComments() {
		System.out.println("댓글을 입력하세요.");		
		
		return sc.nextLine();
	}	
	// 댓글 작성자 이름
	String addComments_name() {
		System.out.println("작성자 이름을 입력하세요.");
		
		return sc.nextLine();
	}
	// 댓글 작성 일시
	String addComments_date() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String date = format.format(time);
		
		return date;
	}	
}

