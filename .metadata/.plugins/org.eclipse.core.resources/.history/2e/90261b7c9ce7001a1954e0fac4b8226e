package ViewPage;

import java.util.ArrayList;

import Homepage.HomepageClass;

public class ViewComment {
	// 해당 게시물의 모든 댓글 출력
	public void printCommentList(ArrayList<HomepageClass> list, int n) {		
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < list.get(n).getCommentList().size(); i++) {
			System.out.println(" " + list.get(n).getCommentList().get(i)[0] + ") " + list.get(n).getCommentList().get(i)[1] + " 작성자 : " + list.get(n).getCommentList().get(i)[2] + " 작성 일시 : " + list.get(n).getCommentList().get(i)[3]);		
		}
	}
}
