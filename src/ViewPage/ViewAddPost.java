package ViewPage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import home.HomepageClass;

public class ViewAddPost {
	Scanner sc = new Scanner(System.in);
	
	void add(ArrayList<HomepageClass> list, int count) {		
		HomepageClass h = new HomepageClass();
		String check = "";
		
		System.out.println("제목을 입력하세요.");
		h.setTitle(sc.nextLine());
		check = h.getTitle().replace(" ", "");
		if(check.equals("")) {
			System.out.println("제목은 공백이 될 수 없습니다!");
		}
		
		System.out.println("내용을 입력하세요.");
		h.setContents(sc.nextLine());
		
		System.out.println("작성자 이름을 입력하세요. ");
		h.setWriter(sc.nextLine());
		check = h.getWriter().replace(" ", "");
		if(check.equals("")) {
			System.out.println("작성자 이름은 공백이 될 수 없습니다!");
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String date = format.format(time);
		h.setDate_time(date);
		
		h.setIndex(count);			
		
		h.setContent_like(0);
		h.setContent_unlike(0);
		h.setPageCount(0);
		
		list.add(h);
	}

}
