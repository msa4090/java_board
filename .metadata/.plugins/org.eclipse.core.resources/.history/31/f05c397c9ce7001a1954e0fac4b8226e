package home;

import java.util.ArrayList;
import java.util.Scanner;

public class Testdata {
	private int count = 1;
	Scanner sc = new Scanner(System.in);
	
	ArrayList<HomepageClass> Test() {
		ArrayList<HomepageClass> testList = new ArrayList<>();
		
		int number = 0;
		System.out.println("생성할 테스트데이터 갯수를 입력하세요.");
		number = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < number; i++) {
			HomepageClass h = new HomepageClass();		
			
			h.setTitle("제목" + count);
			h.setContents("내용" + count);
			h.setWriter("작성자" + count);
			h.setIndex(count);
			h.setContent_like(0);
			h.setContent_unlike(0);
			h.setPageCount(0);
			h.setDate_time("2020-08-18 19:20:00");
			count++;
			
			testList.add(h);	
		}
		return testList;
	}
	
}
