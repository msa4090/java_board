package Homepage;

import java.text.SimpleDateFormat;
import java.util.*;

public class CommentManager {
	Scanner sc = new Scanner(System.in);
	
	// 댓글 내용
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
	// 댓글 수정
	String reviseComment(HomepageClass list, int n, int index) {
		
		String name = "";
		String str = "";
		System.out.println("댓글 작성자 이름을 입력하세요 : ");
		name = sc.nextLine();	
		
		if(list.getCommentList().get(index)[0] == null) {
			System.out.println("존재하지 않는 댓글입니다!");
		} else if(!list.getCommentList().get(index)[2].equals(name)) {
			System.out.println("댓글 작성자 이름이 다릅니다!");
		} else {
			System.out.println("현재 댓글 내용 : " + list.getCommentList().get(index)[2]);
			System.out.println("수정할 댓글 내용 : ");							
			
			str = sc.nextLine();

			System.out.println("댓글이 수정되었습니다.");
		}
		
		return str;
	}

}

