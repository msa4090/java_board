package home;

import java.util.*;

public class HomepageManager {
	ArrayList<HomepageClass> list = new ArrayList<>();	
	DetailPage dp = new DetailPage();
	Scanner sc = new Scanner(System.in);
	private int count = 1;	// 게시물 번호(index)는 1부터 시작
	
	void add() {		
		HomepageClass h = new HomepageClass();
		
		System.out.println("제목을 입력하세요. : ");
		h.setTitle(sc.nextLine());
		
		System.out.println("내용을 입력하세요. : ");
		h.setContents(sc.nextLine());
		
		System.out.println("작성자 이름을 입력하세요. : ");
		h.setWriter(sc.nextLine());
		
		System.out.println("게시물 비밀번호 4자리를 입력하세요. (게시물을 삭제할 때 사용됩니다.) : ");
		h.setPw(sc.nextLine());
		
		h.setIndex(count);
		count++;
		
		list.add(h);
	}
	
	void delete() {
		System.out.println("삭제하고 싶은 게시물 번호를 입력하세요. : ");
		int n = sc.nextInt();
		while(true) {
			if(list.get(n - 1) == null) {
				System.out.println("존재하지 않는 게시물 번호입니다. 다시 입력하세요.");
			} else {
				break;
			}
		}
		sc.nextLine();
		
		System.out.println("해당 게시물의 작성자 이름을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("해당 게시물의 비밀번호를 입력하세요.");
		String pw = sc.nextLine();
		
		if(!list.get(n - 1).getWriter().equals(name)) {
			System.out.println("작성자 이름이 다릅니다!");
			delete();
		} else if(!list.get(n - 1).getPw().equals(pw)) {
			System.out.println("비밀번호가 다릅니다!");
			delete();
		} else {
			System.out.println("해당 게시물이 삭제되었습니다.");
			list.remove(n - 1);			
		}
	}
	
	void printPage() {
		System.out.println("-------------------------------------");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getIndex() + ". " + list.get(i).getTitle() + "     작성자 : " + list.get(i).getWriter());
			System.out.println("   " + list.get(i).getContents());
		}
		System.out.println("-------------------------------------");
	}
	
	void findPage() {
		if(list.isEmpty()) {
			System.out.println("게시물이 없습니다.");
		} else {
			System.out.println("검색할 게시물 번호를 입력하세요. : ");
			int n = sc.nextInt();
			sc.nextLine(); // 입력 창에 남아있는 찌꺼기 값 제거
			
//			try {
				// 해당 게시물 출력
				System.out.println(list.get(n - 1).getIndex() + ". " + list.get(n - 1).getTitle() + "   작성자 : " + list.get(n - 1).getWriter());
				System.out.println("   " + list.get(n - 1).getContents());
				// 댓글 출력
//				dp.printComments();
				printCommentList(n - 1);
				
				String str = "";				
				HomepageClass hc = new HomepageClass();
				hc = list.get(n - 1);
				
				while(true) {
					System.out.println("수행하실 명령을 선택하세요. [comment, exit] ");
					str = sc.nextLine();
					// 댓글 달기
					if(str.equals("comment")) {
						hc.setCommnets_index(1 + hc.getCommnets_index());
						hc.commentList.add(dp.addComments(hc.getCommnets_index()));				
					}		
					// 초기화면으로 돌아가기
					if(str.equals("exit")) {
						System.out.println("초기화면으로 돌아갑니다.");
						break;
					}
				}
//			// 예외 발생 시 아래의 문구를 출력하고 초기화면으로 되돌아감. 
//			} catch(Exception e) {
//				System.out.println("존재하지 않는 게시물입니다.");
//			}			
		}		
	}
	
	void printCommentList(int n) {		
		System.out.println("-------------------------------------");
		for(int i = 0; i < list.get(n).getCommentList().size(); i++) {
			System.out.println(" " + list.get(n).getCommentList().get(i));		
		}
	}
	
	public ArrayList<HomepageClass> getList() {
		return list;
	}
	
	public void setList(ArrayList<HomepageClass> list) {
		this.list = list;
	}
}
