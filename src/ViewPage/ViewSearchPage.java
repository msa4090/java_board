package ViewPage;

import java.util.ArrayList;
import java.util.Scanner;

import home.HomepageClass;

public class ViewSearchPage {
	Scanner sc = new Scanner(System.in);

	//하나의 게시물만 출력
	public void printPage(ArrayList<HomepageClass> list, int n) {		
		if(list.get(n).getCommentList().size() == 0) {
			System.out.println(list.get(n).getIndex() + ". " + list.get(n).getTitle() + "       작성자 : " + list.get(n).getWriter() + " 조회수 : " + list.get(n).getPageCount() + "  좋아요 : " + list.get(n).getContent_like() + " 싫어요 : " + list.get(n).getContent_unlike() + " 작성 일시 : " + list.get(n).getDate_time());
		} else {
			System.out.println(list.get(n).getIndex() + ". " + list.get(n).getTitle() + " [" + list.get(n).getCommentList().size() + "]   작성자 : " + list.get(n).getWriter() + " 조회수 : " + list.get(n).getPageCount() + "  좋아요 : " + list.get(n).getContent_like() + " 싫어요 : " + list.get(n).getContent_unlike() + " 작성 일시 : " + list.get(n).getDate_time());
		}		
	}
	
	// 특정 단어가 포함된 제목의 게시물들 출력 
	// 페이징 범위 넘어가면 쪽수 표시 추가할 것
	public void searchPage(ArrayList<HomepageClass> list) {
		String str = "";
		int checkPage = 0;
		
		if(list.isEmpty()) {
			System.out.println("게시물이 없습니다.");
		} else {
			try {
				System.out.println("키워드를 입력하세요.");
				str = sc.nextLine();
				System.out.println("------------------------------------------------------------------------------------------------------------");
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getTitle().contains(str)) {
						printPage(list, i);
						checkPage++;
					}
				}					
				
				if(checkPage == 0) System.out.println("키워드가 들어가는 제목이 없습니다.");
				
				System.out.println("------------------------------------------------------------------------------------------------------------");
			} catch (Exception e) {
				System.out.println("존재하지 않는 게시물입니다.");
			}
		}
	}
}
