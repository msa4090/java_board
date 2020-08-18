package home;

import java.util.*;

public class HomepageClass {
	private String title;		// 게시물 제목
	private String contents;	// 게시물 내용
	private int index;			// 게시물 번호
	private String writer;   	// 게시물 작성자
	private String pw;			// 게시물 비밀번호
	private int commnets_index; // 댓글 번호	
	private String date_time;	// 게시물 작성 일시
	private int content_like;	// 해당 게시물 좋아요
	private int content_unlike; // 해당 게시물 싫어요
	private int pageCount;		// 해당 게시물 조회수
	ArrayList<String[]> commentList = new ArrayList<String[]>(); // 댓글 리스트
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getContent_unlike() {
		return content_unlike;
	}
	
	public void setContent_unlike(int content_unlike) {
		this.content_unlike = content_unlike;
	}
	
	public int getContent_like() {
		return content_like;
	}
	
	public void setContent_like(int content_like) {
		this.content_like = content_like;
	}
	
	public String getDate_time() {
		return date_time;
	}
	
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	public int getCommnets_index() {
		return commnets_index;
	}

	public void setCommnets_index(int commnets_index) {
		this.commnets_index = commnets_index;
	}

	public ArrayList<String[]> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<String[]> commentList) {
		this.commentList = commentList;
	}

	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
}
