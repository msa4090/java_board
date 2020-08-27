package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class TestJson {
	Scanner sc = new Scanner(System.in);
	JSONArray arr = new JSONArray();
	ArrayList<TestClass> list = new ArrayList<>();
	TestJson2 readJson = new TestJson2();
	
	boolean checkList() {
		if(list.size() == readJson.read().size()) {			
			return false; 
		}		
		return true;
	}
	
	void addList() {		
		if(!checkList()) {
			System.out.println("이미 파일을 불러왔습니다.");
		} else {			
			list.addAll(readJson.read());
			for(int i = 0; i < list.size(); i++) {
				JsonObject object = new JsonObject();
				object.addProperty("name", list.get(i).getName());
				object.addProperty("id", list.get(i).getId());
				object.addProperty("pw", list.get(i).getPw());				
				arr.add(object);
			}
		}
	}	
	
	void print() {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId() + " " + list.get(i).getName());
		}
		System.out.println(arr.toString());
	}

	void write() {		
		TestClass member = new TestClass();
		System.out.print("name : ");
		member.setName(sc.nextLine());
		System.out.print("id : ");
		member.setId(sc.nextLine());
		System.out.print("pw : ");
		member.setPw(sc.nextLine());
		
		Gson gson = new Gson();			
		JsonObject object = new JsonObject();
		
		// 입력
		object.addProperty("name", member.getName());
		object.addProperty("id", member.getId());
		object.addProperty("pw", member.getPw());
		
		String json = gson.toJson(object);		
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();		
		arr.add(jsonObject);
//		C:\\work\\sts-4.4.0.RELEASE-workspace\\home\\testJson.json
//		C:\\eclipse\\\\workspace\\test\\testJson.json
		
		FileWrite();		
	}
	
	void change() {
		Gson gson = new Gson();
		TestClass member = new TestClass();
		JsonObject object = (JsonObject)arr.get(0);
		String json = gson.toJson(object);	
//		json <- 객체
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		String name = jsonObject.get("name").toString();

//		이름 변경
		object.addProperty("name", sc.nextLine());	
		
		FileWrite();
		
//		json -> 객체
//		json = gson.toJson(object);
//		member = gson.fromJson(json, TestClass.class);
	}
		
	void FileWrite() {
		try {
			FileWriter file = new FileWriter("C:\\eclipse\\workspace\\test\\testJson.json");
			file.write(arr.toString());			
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
