package JSON;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import home.HomepageClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// GSON 사용

public class WriteJSON {
	JSONArray arr = new JSONArray();
	
	public void PageWrite (ArrayList<HomepageClass> list, int n) {
		JSONObject obj = new JSONObject();
		
		obj.put("제목", list.get(n).getTitle());
		obj.put("내용", list.get(n).getContents());
		obj.put("게시물 번호", list.get(n).getIndex());
		obj.put("작성시간", list.get(n).getDate_time());
		obj.put("좋아요 갯수", list.get(n).getContent_like());
		obj.put("싫어요 갯수", list.get(n).getContent_unlike());
		obj.put("댓글", 0);
		arr.add(obj);

		try {
			FileWriter file = new FileWriter("C:\\work\\sts-4.4.0.RELEASE-workspace\\home\\test.json");
			file.write(arr.toString());			
			file.flush();
//			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void CommentWrite(ArrayList<HomepageClass> list, int n) {	
		JSONObject obj = new JSONObject();
		
		addProperty("댓글", list.get(n).getCommentList().get(n)[1]);
		
		try {
			FileWriter file = new FileWriter("C:\\work\\sts-4.4.0.RELEASE-workspace\\home\\test.json");
			file.write(arr.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addProperty(String property, String value) {
		
	}

}
