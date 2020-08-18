package home;

import java.text.SimpleDateFormat;
import java.util.*;

public class HomepageManager {
	ArrayList<HomepageClass> list = new ArrayList<>();
	Testcase tc = new Testcase();
	DetailPage dp = new DetailPage();
	Scanner sc = new Scanner(System.in);
	private int count = 1;	// 게시물 번호(index)는 1부터 시작	
	ArrayList<Integer> pageList = new ArrayList();	
	
	void makeTestcase() {
		int number = 0;
		System.out.println("생성할 테스트케이스 갯수를 입력하세요.");
		number = sc.nextInt();
		sc.nextLine();
		list.addAll(tc.testcase(number));
	}
	
	void add() {		
		HomepageClass h = new HomepageClass();
		String check = "";
		
		System.out.println("제목을 입력하세요. : ");
		h.setTitle(sc.nextLine());
		check = h.getTitle().replace(" ", "");
		if(check.equals("")) {
			System.out.println("제목은 공백이 될 수 없습니다! 게시물 추가 화면으로 돌아갑니다.");
			add();
		}
		
		System.out.println("내용을 입력하세요. : ");
		h.setContents(sc.nextLine());
		
		System.out.println("작성자 이름을 입력하세요. ");
		h.setWriter(sc.nextLine());
		check = h.getWriter().replace(" ", "");
		if(check.equals("")) {
			System.out.println("작성자 이름은 공백이 될 수 없습니다! 게시물 추가 화면으로 돌아갑니다");
			add();
		}
		
		System.out.println("게시물 비밀번호 4자리를 입력하세요. (게시물을 삭제할 때 사용됩니다.) : ");
		h.setPw(sc.nextLine());
		if(h.getPw().length() != 4) {
			System.out.println("비밀번호 4자리가 아닙니다! 게시물 추가 화면으로 돌아갑니다.");
			add();
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String date = format.format(time);
		h.setDate_time(date);
		
		h.setIndex(count);
		count++;
		
		h.setContent_like(0);
		h.setContent_unlike(0);
		h.setPageCount(0);
		
		list.add(h);
	}
	
	void delete() {
		System.out.println("삭제하고 싶은 게시물 번호를 입력하세요.");
		int n = sc.nextInt();

		if(list.get(n - 1) == null) {
			System.out.println("존재하지 않는 게시물 번호입니다. 다시 입력하세요.");
		}
		
		sc.nextLine();
		
		System.out.println("해당 게시물의 작성자 이름을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("해당 게시물의 비밀번호를 입력하세요.");
		String pw = sc.nextLine();
		
		if(!list.get(n - 1).getWriter().equals(name)) {
			System.out.println("작성자 이름이 다릅니다!");
		} else if(!list.get(n - 1).getPw().equals(pw)) {
			System.out.println("비밀번호가 다릅니다!");
		} else {
			System.out.println("해당 게시물이 삭제되었습니다.");
			list.remove(n - 1);			
		}
	}
	
	void sortPage() {
		ArrayList<Integer[]> printList = new ArrayList<>();	
		SortPage sp = new SortPage();
		String str = "";		
		int commentSW = 0, countSW = 0, likeSW = 0, unlikeSW = 0, sortStandard = 0, viewPageNumber = 10, nowPageNumber = 1, start = 0;		
		
		// 0 : 인덱스, 1 : 댓글 갯수, 2 : 조회수, 3 : 좋아요 갯수, 4 : 싫어요 갯수 
		for(int i = 0; i < list.size(); i++) {
			printList.add(new Integer[] {i, list.get(i).getCommentList().size(), list.get(i).getPageCount(), list.get(i).getContent_like(), list.get(i).getContent_unlike()});
		}
		
		int page = printList.size();
		for(int i = 0; page > 0; i++) {
			page -= viewPageNumber;
			pageList.add(i + 1);			
		}
		
		while(true) {			
			printAllPage(printList, pageList, viewPageNumber, start, nowPageNumber);
			if(nowPageNumber == 1) {
				System.out.println("수행하실 명령을 입력하세요. [comment, count, like, unlike, paging, next, exit]");
			} else if(nowPageNumber == list.size()) {
				System.out.println("수행하실 명령을 입력하세요. [comment, count, like, unlike, paging, previous, exit]");
			} else {
				System.out.println("수행하실 명령을 입력하세요. [comment, count, like, unlike, paging, previous, next, exit]");
			}
			str = sc.nextLine();		
		// 댓글 많은 순서, 적은 순서
			if(str.equals("comment")) {
				// 2차원 Arraylist printList 는 게시판 번호와 list의 댓글 갯수를 가지고 있다.
				sortStandard = 1;
				// printList = 현재 페이지 -> 정렬된 페이지, SW = 오름차순/내림차순 구분, sortStandard = 정렬기준 
				printList = sp.sortPage(printList, commentSW, sortStandard);				
				if(commentSW == 0) commentSW++;
				else commentSW--;				
			}			
			// 조회수 높은 순서, 낮은 순서
			if(str.equals("count")) {
				sortStandard = 2;
				printList = sp.sortPage(printList, commentSW, sortStandard);				
				if(countSW == 0) countSW++;
				else countSW--;			
			}
			// 좋아요 많은 순서, 낮은 순서
			if(str.equals("like")) {
				sortStandard = 3;
				printList = sp.sortPage(printList, commentSW, sortStandard);				
				if(likeSW == 0) likeSW++;
				else likeSW--;					
			}
			// 싫어요 많은 순서
			if(str.equals("unlike")) {
				sortStandard = 4;
				printList = sp.sortPage(printList, commentSW, sortStandard);				
				if(unlikeSW == 0) unlikeSW++;
				else unlikeSW--;	
			}
			// 한 화면에 몇개의 페이지를 출력하는지(기본 : 10)
			if(str.equals("paging")) {
				System.out.println("한 화면에 몇개의 페이지를 출력할 지 선택하세요. [5, 10, 15, 20]");
				viewPageNumber = sc.nextInt();
				sc.nextLine();				
			}
			if(str.equals("next")) {
				if(list.size() < nowPageNumber + viewPageNumber) {
					System.out.println("다음 페이지가 없습니다.");
				} else {
					nowPageNumber++;
					start += viewPageNumber;
					viewPageNumber += viewPageNumber;
				}
			}
			if(str.equals("pevious")) {
				
			}
			// 초기화면으로 이동
			if(str.equals("exit")) {
				break;
			}			
		}
		
	}
	// 한 페이지 출력
	void printAllPage(ArrayList<Integer[]> printList, ArrayList<Integer> pageList, int viewPageNumber, int start, int nowPageNumber) {		
		int	now = 0;
		
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(int i = start; i < (viewPageNumber >= list.size() ? list.size() : viewPageNumber); i++) {
			if(list.get(printList.get(i)[0]).getCommentList().size() == 0) {
				System.out.println(list.get(printList.get(i)[0]).getIndex() + ". " + list.get(printList.get(i)[0]).getTitle() + "       작성자 : " + list.get(printList.get(i)[0]).getWriter() + " 조회수 : " + list.get(printList.get(i)[0]).getPageCount() + "  좋아요 : " + list.get(printList.get(i)[0]).getContent_like() + " 싫어요 : " + list.get(printList.get(i)[0]).getContent_unlike() + " 작성 일시 : " + list.get(printList.get(i)[0]).getDate_time());
			} else {
				System.out.println(list.get(printList.get(i)[0]).getIndex() + ". " + list.get(printList.get(i)[0]).getTitle() + " [" + list.get(printList.get(i)[0]).getCommentList().size() + "]   작성자 : " + list.get(printList.get(i)[0]).getWriter() + " 조회수 : " + list.get(printList.get(i)[0]).getPageCount() + "  좋아요 : " + list.get(printList.get(i)[0]).getContent_like() + " 싫어요 : " + list.get(printList.get(i)[0]).getContent_unlike() + " 작성 일시 : " + list.get(printList.get(i)[0]).getDate_time());
			}			
		}
		System.out.println();
		System.out.print("< ");
		
		// 페이지 리스트 표시
		for(int i = 0; i < pageList.size(); i++) {
			if(pageList.get(i) == nowPageNumber) {				
				System.out.print(pageList.get(i) + " ");	
				now = i + 1;
			} else {
				System.out.print(pageList.get(i) + " ");
			}
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
	// 하나의 게시물만 출력
	void printPage(int n) {		
		if(list.get(n).getCommentList().size() == 0) {
			System.out.println(list.get(n).getIndex() + ". " + list.get(n).getTitle() + "       작성자 : " + list.get(n).getWriter() + " 조회수 : " + list.get(n).getPageCount() + "  좋아요 : " + list.get(n).getContent_like() + " 싫어요 : " + list.get(n).getContent_unlike() + " 작성 일시 : " + list.get(n).getDate_time());
		} else {
			System.out.println(list.get(n).getIndex() + ". " + list.get(n).getTitle() + " [" + list.get(n).getCommentList().size() + "]   작성자 : " + list.get(n).getWriter() + " 조회수 : " + list.get(n).getPageCount() + "  좋아요 : " + list.get(n).getContent_like() + " 싫어요 : " + list.get(n).getContent_unlike() + " 작성 일시 : " + list.get(n).getDate_time());
		}		
	}
	
	void readPage() {
		if(list.isEmpty()) {
			System.out.println("게시물이 없습니다.");
		} else {
			System.out.println("검색하실 게시물 번호를 입력하세요.");
			int n = sc.nextInt();
			sc.nextLine(); // 입력 창에 남아있는 찌꺼기 값 제거
			
			try {
				// 해당 게시물 출력
				System.out.println(list.get(n - 1).getIndex() + ". " + list.get(n - 1).getTitle() + "   작성자 : " + list.get(n - 1).getWriter() + " 조회수 : " + list.get(n - 1).getPageCount() + "  좋아요 : " + list.get(n - 1).getContent_like() + " 싫어요 : " + list.get(n - 1).getContent_unlike() + " 작성 일시 : " + list.get(n - 1).getDate_time());
				System.out.println("   " + list.get(n - 1).getContents());
				// 댓글 출력
				printCommentList(n - 1);
				// 조회수 + 1
				list.get(n - 1).setPageCount(list.get(n - 1).getPageCount() + 1);
				
				String str = "";				
				
				while(true) {
					System.out.println("수행하실 명령을 입력하세요. [comment, revise comment, like, exit] ");
					str = sc.nextLine();
					// 댓글 달기
					if(str.equals("comment")) {
						list.get(n - 1).setCommnets_index(1 + list.get(n - 1).getCommnets_index());
						// 0 : 댓글 번호, 1 : 댓글 내용, 2 : 댓글 이름, 3 : 댓글 작성시간
						list.get(n - 1).commentList.add(new String[] {Integer.toString(list.get(n - 1).getCommnets_index()), dp.addComments(), dp.addComments_name(), dp.addComments_date()});
//						break;
					}
					if(str.equals("revise comment")) {
						
						int index = 0;
						System.out.println("수정할 댓글 번호를 입력하세요 : ");
						index = sc.nextInt();
						sc.nextLine();
						
						String name = "";
						System.out.println("댓글 작성자 이름을 입력하세요 : ");
						name = sc.nextLine();	
						
						if(list.get(n - 1).getCommentList().get(index - 1)[0] == null) {
							System.out.println("존재하지 않는 댓글입니다!");
						} else if(!list.get(n - 1).getCommentList().get(index - 1)[2].equals(name)) {
							System.out.println("댓글 작성자 이름이 다릅니다!");
						} else {
							System.out.println("현재 댓글 내용 : " + list.get(n - 1).getCommentList().get(index - 1)[2]);
							System.out.println("수정할 댓글 내용 : ");							
							
							list.get(n - 1).getCommentList().get(index - 1)[1] = sc.nextLine();

							System.out.println("댓글이 수정되었습니다.");
						}
					}
					// 좋아요 누르기
					// 회원기능 구현되면 중복방지 추가
					if(str.equals("like")) {
						list.get(n - 1).setContent_like(1 + list.get(n - 1).getContent_like());
						System.out.println("해당 게시물에 좋아요를 눌렀습니다.");
					}
					// 싫어요 누르기
					if(str.equals("unlike")) {
						
					}
					// 초기화면으로 돌아가기
					if(str.equals("exit")) {
						System.out.println("초기화면으로 돌아갑니다.");
						break;
					}
				}
			// 예외 발생 시 아래의 문구를 출력하고 초기화면으로 되돌아감. 
			} catch(Exception e) {
				System.out.println("존재하지 않는 게시물입니다.");
			}			
		}		
	}
	
	// 해당 게시물의 모든 댓글 출력
	void printCommentList(int n) {		
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < list.get(n).getCommentList().size(); i++) {
			System.out.println(" " + list.get(n).getCommentList().get(i)[0] + ") " + list.get(n).getCommentList().get(i)[1] + " 작성자 : " + list.get(n).getCommentList().get(i)[2] + " 작성 일시 : " + list.get(n).getCommentList().get(i)[3]);		
		}
	}
	
	void updatePage() {
		if(list.isEmpty()) {
			System.out.println("게시물이 없습니다.");
		} else {
			System.out.println("수정하실 게시물 번호를 입력하세요.");
			int n = sc.nextInt();
			sc.nextLine(); // 입력 창에 남아있는 찌꺼기 값 제거
			try {
				String str = "";
				
				while(true) {
					System.out.println("수행하실 명령을 입력하세요. [title revise, content revise, exit]");
					str = sc.nextLine();
					
					if(str.equals("title revise")) {
						System.out.println("현재 제목 : " + list.get(n - 1).getTitle());
						System.out.println("변경할 제목 : ");
						list.get(n - 1).setTitle(sc.nextLine());
						System.out.println("제목이 수정되었습니다.");
						break;
					}
					
					if(str.equals("content revise")) {
						System.out.println("현재 내용 : " + list.get(n - 1).getContents());
						System.out.println("변경할 내용 : ");
						list.get(n - 1).setContents(sc.nextLine());
						System.out.println("내용이 수정되었습니다.");
						break;
					}
					
					if(str.equals("exit")) {
						System.out.println("초기화면으로 돌아갑니다.");
						break;
					}
				}
				
			} catch (Exception e) {
				System.out.println("존재하지 않는 게시물입니다.");
			}
		}
	}
	
	void searchPage() {
		String str = "";
		
		if(list.isEmpty()) {
			System.out.println("게시물이 없습니다.");
		} else {
			try {
				System.out.println("키워드를 입력하세요.");
				str = sc.nextLine();
				System.out.println("------------------------------------------------------------------------------------------------------------");
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getTitle().contains(str)) {
						printPage(i);
					}
				}
				System.out.println("------------------------------------------------------------------------------------------------------------");
			} catch (Exception e) {
				System.out.println("존재하지 않는 게시물입니다.");
			}
		}
	}
	
	public ArrayList<HomepageClass> getList() {
		return list;
	}
	
	public void setList(ArrayList<HomepageClass> list) {
		this.list = list;
	}
}
