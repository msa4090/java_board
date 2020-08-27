package ViewPage;

import java.util.ArrayList;
import java.util.Scanner;

import home.HomepageClass;

public class ViewDeletePage {
	Scanner sc = new Scanner(System.in);
	
	void delete(ArrayList<HomepageClass> list) {
		System.out.println("삭제하고 싶은 게시물 번호를 입력하세요.");
		int n = sc.nextInt();

		if(list.get(n - 1) == null) {
			System.out.println("존재하지 않는 게시물 번호입니다. 다시 입력하세요.");
		}
		
		sc.nextLine();
		
		System.out.println("해당 게시물의 작성자 이름을 입력하세요.");
		String name = sc.nextLine();
		
		if(!list.get(n - 1).getWriter().equals(name)) {
			System.out.println("작성자 이름이 다릅니다!");
		} else {
			System.out.println("해당 게시물이 삭제되었습니다.");
			list.remove(n - 1);
//			"나중에 삭제된 게시물입니다." 리스트 추가 
		}
	}

}
