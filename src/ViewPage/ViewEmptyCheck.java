package ViewPage;

import java.util.ArrayList;

import home.HomepageClass;

public class ViewEmptyCheck {
	
	boolean emptyCheck(ArrayList<HomepageClass> list) {
		if(list.isEmpty()) {			
			return true;
		}
		return false;
	}
	
	void isNullPrint() {
		System.out.println("게시물이 없습니다!");
	}

}
