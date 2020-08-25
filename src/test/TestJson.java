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
	ArrayList<String> strList = new ArrayList<String>();
	
	void addList(TestClass member) {
		list.add(member);		
	}	
	
	void test() {
		strList.add("hi");
		System.out.println(strList);
	}
	
	void print() {
		System.out.println(list);
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
		
		try {
			FileWriter file = new FileWriter("C:\\work\\sts-4.4.0.RELEASE-workspace\\home\\testJson.json");
			file.write(arr.toString());			
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void change() {
		System.out.println(arr);
		Gson gson = new Gson();			
		
		TestClass member = new TestClass();
		JsonObject object = (JsonObject)arr.get(0);
//		JSONArray jsonArray = (JSONArray)object;
		String json = gson.toJson(object);	
//		// json <- 객체
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

		String name = jsonObject.get("name").toString();

//		// 이름 변경
		object.addProperty("name", sc.nextLine());		
		
//		// json -> 객체
		json = gson.toJson(object);
		member = gson.fromJson(json, TestClass.class);
	}
	
	public ArrayList<TestClass> getList() {
		return list;
	}
	
	public void setList(ArrayList<TestClass> list) {
		this.list = list;
	}
}
