package Homepage;

import java.util.*;
import ViewPage.ViewPageManager;
import JSON.WriteJSON;
import JSON.ReadJSON;

public class HomepageManager {
	ArrayList<HomepageClass> list = new ArrayList<>();
	Testdata tc = new Testdata();
	CommentManager co = new CommentManager();
	Scanner sc = new Scanner(System.in);
	private int count = 1;	// 게시물 번호(index)는 1부터 시작		

	ArrayList<Integer> pageList = new ArrayList<Integer>();	
	ViewPageManager vpm = new ViewPageManager();
	WriteJSON writeJson = new WriteJSON();
	ReadJSON readJson = new ReadJSON();	
	
	// 테스트데이터 추가
	public void makeTestdata() {		
		list.addAll(tc.Test());
	}
	// 게시물 추가
	public void add() {		
		vpm.add(list, count);
		writeJson.PageWrite(list, count - 1);
		count++;
	}
	// 게시물 삭제
	public void delete() {
		vpm.delete(list);
	}
	// 게시물 출력 & 정렬
	public void sortPage() {
		ArrayList<Integer[]> printList = new ArrayList<>();	
		SortPage sp = new SortPage();
		String str = "";		
		int commentSW = 0, countSW = 0, likeSW = 0, unlikeSW = 0, sortStandard = 0, viewPageNumber = 10, nowPageNumber = 1, start = 0;		
		
		// 0 : 인덱스, 1 : 댓글 갯수, 2 : 조회수, 3 : 좋아요 갯수, 4 : 싫어요 갯수 
		for(int i = 0; i < list.size(); i++) {
			printList.add(new Integer[] {i, list.get(i).getCommentList().size(), list.get(i).getPageCount(), list.get(i).getContent_like(), list.get(i).getContent_unlike()});
		}
		// 현재 페이지 리스트
		pageList.clear();
		pageList.addAll(sp.setPageList(printList.size(), viewPageNumber));
		
		while(true) {			
			// 현재 페이지 출력
			vpm.printNowPage(list, printList, pageList, viewPageNumber, start, nowPageNumber);
			// 수행할 수 있는 명령어 목록 출력
			vpm.commandOfSort(nowPageNumber, pageList);
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
			// 좋아요 많은 순서, 적은 순서
			if(str.equals("like")) {
				sortStandard = 3;
				printList = sp.sortPage(printList, commentSW, sortStandard);				
				if(likeSW == 0) likeSW++;
				else likeSW--;					
			}
			// 싫어요 많은 순서, 적은 순서
			if(str.equals("unlike")) {
				sortStandard = 4;
				printList = sp.sortPage(printList, commentSW, sortStandard);				
				if(unlikeSW == 0) unlikeSW++;
				else unlikeSW--;	
			}
			// 한 화면에 몇개의 게시물을 출력하는지(기본 : 10개)
			if(str.equals("paging")) {
				viewPageNumber = vpm.paging();				
				sc.nextLine();		
				// 페이지 리스트 초기화 후 재설정
				pageList.clear();
				pageList.addAll(sp.setPageList(printList.size(), viewPageNumber));
				nowPageNumber = 1;
				start = 0;
			}
			if(str.equals("next") && nowPageNumber != pageList.size()) {				
				nowPageNumber++;
				start += viewPageNumber;				
			}
			if(str.equals("previous") && nowPageNumber != 1) {
				nowPageNumber--;
				start -= viewPageNumber;
			}
			// 초기화면으로 이동
			if(str.equals("exit")) {
				break;
			}			
		}
		
	}

	// 게시판 상세조회
	public void readPage() {
		if(list.isEmpty()) {
			System.out.println("게시물이 없습니다.");
		} else {
			System.out.println("검색하실 게시물 번호를 입력하세요.");
			int n = sc.nextInt();
			sc.nextLine(); // 입력 창에 남아있는 찌꺼기 값 제거
			
			try {
				// 해당 게시물 출력
				vpm.printPost(list, n - 1);
				// 댓글 출력
				vpm.printCommentList(list, n - 1);
				// 조회수 1 증가
				list.get(n - 1).setPageCount(list.get(n - 1).getPageCount() + 1);
				
				String str = "";				
				
				while(true) {
					System.out.println("수행하실 명령을 입력하세요. [comment, revise comment, like, exit] ");
					str = sc.nextLine();
					// 댓글 달기
					if(str.equals("comment")) {
						list.get(n - 1).setCommnets_index(1 + list.get(n - 1).getCommnets_index());
						// 0 : 댓글 번호, 1 : 댓글 내용, 2 : 댓글 이름, 3 : 댓글 작성시간
						list.get(n - 1).commentList.add(new String[] {Integer.toString(list.get(n - 1).getCommnets_index()), co.addComments(), co.addComments_name(), co.addComments_date()});
						writeJson.CommentWrite(list, n - 1);
					}
					if(str.equals("revise comment")) {
						int index = 0;
						System.out.println("수정할 댓글 번호를 입력하세요 : ");
						index = sc.nextInt();
						sc.nextLine();						
						list.get(n - 1).getCommentList().get(index - 1)[1] = co.reviseComment(list.get(n - 1), n - 1, index - 1);
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
	
	// 게시물의 제목, 내용 수정
	public void updatePost() {
		if(vpm.emptyCheck(list)) {
			vpm.isNullPrint();
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
				vpm.isNullPrint();
			}
		}
	}
	// 특정 단어가 포함된 제목 검색
	public void searchTitle() {
		vpm.searchPage(list);
	}
	
	public ArrayList<HomepageClass> getList() {
		return list;
	}
	
	public void setList(ArrayList<HomepageClass> list) {
		this.list = list;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
