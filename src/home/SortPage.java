package home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortPage {
	// 페이지 정렬
	ArrayList<Integer[]> sortPage(ArrayList<Integer[]> printList, int SW, int sortStandard) {
		// 내림차순 정렬
		if(SW == 0) {
			Collections.sort(printList, new Comparator<Integer[]>() {
				@Override
				public int compare(final Integer[] a1, final Integer[] a2) {
					return Integer.compare(a2[sortStandard], a1[sortStandard]); 
				}
			});
		}
		// 오름차순 정렬
		else {
			Collections.sort(printList, new Comparator<Integer[]>() {
				@Override
				public int compare(final Integer[] a1, final Integer[] a2) {
					return Integer.compare(a1[sortStandard], a2[sortStandard]); 
				}
			});
		}		
		return printList;		
	}
	// 한 화면에 몇개의 게시판을 출력하는지
	void viewPage() {
		
	}
	

}
