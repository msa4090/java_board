package ViewPage;

import java.util.ArrayList;
import java.util.Scanner;

import home.HomepageClass;

public class ViewSortPage {
	Scanner sc = new Scanner(System.in);
	
	// 메인에서 입력어 "list"의 명령어 목록 출력
	public void commandOfSort(int nowPageNumber, ArrayList<Integer> pageList){
		if(nowPageNumber == 1) {
			System.out.println("수행하실 명령을 입력하세요. [comment, count, like, unlike, paging, next, exit]");
		} else if(nowPageNumber == pageList.size()) {
			System.out.println("수행하실 명령을 입력하세요. [comment, count, like, unlike, paging, previous, exit]");
		} else {
			System.out.println("수행하실 명령을 입력하세요. [comment, count, like, unlike, paging, previous, next, exit]");
		}
	}
	
	// 한 페이지 출력
	public void printNowPage(ArrayList<HomepageClass> list, ArrayList<Integer[]> printList, ArrayList<Integer> pageList, int viewPageNumber, int start, int nowPageNumber) {		
		int	now = 0;
		
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(int i = start; i < (viewPageNumber * nowPageNumber >= list.size() ? list.size() : viewPageNumber * nowPageNumber); i++) {
			if(list.get(printList.get(i)[0]).getCommentList().size() == 0) {
				System.out.println(list.get(printList.get(i)[0]).getIndex() + ". " + list.get(printList.get(i)[0]).getTitle() + "       작성자 : " + list.get(printList.get(i)[0]).getWriter() + " 조회수 : " + list.get(printList.get(i)[0]).getPageCount() + "  좋아요 : " + list.get(printList.get(i)[0]).getContent_like() + " 싫어요 : " + list.get(printList.get(i)[0]).getContent_unlike() + " 작성 일시 : " + list.get(printList.get(i)[0]).getDate_time());
			} else {
				System.out.println(list.get(printList.get(i)[0]).getIndex() + ". " + list.get(printList.get(i)[0]).getTitle() + " [" + list.get(printList.get(i)[0]).getCommentList().size() + "]   작성자 : " + list.get(printList.get(i)[0]).getWriter() + " 조회수 : " + list.get(printList.get(i)[0]).getPageCount() + "  좋아요 : " + list.get(printList.get(i)[0]).getContent_like() + " 싫어요 : " + list.get(printList.get(i)[0]).getContent_unlike() + " 작성 일시 : " + list.get(printList.get(i)[0]).getDate_time());
			}						}
		System.out.println();
		System.out.print("< ");		
		// 페이지 리스트 표시
		for(int i = 0; i < pageList.size(); i++) {
			if(pageList.get(i) == nowPageNumber) {				
				now = i + 1;
			} 
			System.out.print(pageList.get(i) + " ");	
		}
		System.out.println(">");
		// 현재 페이지 표시
		String str = "";
		for(int i = 0; i < now; i++) {
			str += "  ";
		}
		System.out.println(str + "^");		
		System.out.println("------------------------------------------------------------------------------------------------------------");
	}
	
	int paging() {
		System.out.println("한 화면에 몇개의 페이지를 출력할 지 선택하세요. [5, 10, 15, 20]");
		return sc.nextInt();
	}
}
