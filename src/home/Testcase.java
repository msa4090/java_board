package home;

import java.util.ArrayList;

public class Testcase {
	private int count = 1;
	
	ArrayList<HomepageClass> Test(int n) {
		ArrayList<HomepageClass> testList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			HomepageClass h = new HomepageClass();		
			
			h.setTitle("제목" + count);
			h.setContents("내용" + count);
			h.setWriter("작성자" + count);
			h.setPw("1111");
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
