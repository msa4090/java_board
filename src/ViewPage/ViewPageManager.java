package ViewPage;

import java.util.ArrayList;

import home.HomepageClass;

public class ViewPageManager {
	ViewSortPage vSortp = new ViewSortPage();
	ViewComment vc = new ViewComment();
	ViewPost vp = new ViewPost();
	ViewSearchPage vSearchp = new ViewSearchPage();
	ViewHelp vh = new ViewHelp();
	ViewAddPost vap = new ViewAddPost();
	ViewDeletePage vdp = new ViewDeletePage();
	ViewEmptyCheck vec = new ViewEmptyCheck();
	
	public void commandOfSort(int nowPageNumber, ArrayList<Integer> pageList){
		vSortp.commandOfSort(nowPageNumber, pageList);
	}
	
	public void printNowPage(ArrayList<HomepageClass> list, ArrayList<Integer[]> printList, ArrayList<Integer> pageList, int viewPageNumber, int start, int nowPageNumber) {
		vSortp.printNowPage(list, printList, pageList, viewPageNumber, start, nowPageNumber);
	}
	
	public void printCommentList(ArrayList<HomepageClass> list, int n) {
		vc.printCommentList(list, n);
	}
	
	public void printPost(ArrayList<HomepageClass> list, int n) {
		vp.printPost(list, n);
	}
	
	public void printPage(ArrayList<HomepageClass> list, int n) {
		vSearchp.printPage(list, n);
	}
	
	public void searchPage(ArrayList<HomepageClass> list) {
		vSearchp.searchPage(list);
	}
	
	public void help() {
		vh.help();
	}
	
	public void add(ArrayList<HomepageClass> list, int count) {
		vap.add(list, count);
	}
	
	public void delete(ArrayList<HomepageClass> list) {
		vdp.delete(list);
	}
	
	public int paging() {
		return vSortp.paging();
	}
	
	public boolean emptyCheck(ArrayList<HomepageClass> list) {
		return vec.emptyCheck(list);
	}
	
	public void isNullPrint() {
		vec.isNullPrint();
	}

}
