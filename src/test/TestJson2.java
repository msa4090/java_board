package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestJson2 {
	
	ArrayList<TestClass> read() {				
		TestJson writeJson = new TestJson();
		ArrayList<TestClass> readArr = new ArrayList<>(); 
		
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:\\eclipse\\workspace\\test\\testJson.json"));			
			JSONArray jsonArray = (JSONArray)obj;
			
			for(int i = 0; i < jsonArray.size(); i++) {
				TestClass member = new TestClass();
				JSONObject jsonObject = (JSONObject)jsonArray.get(i);
				member.setId(jsonObject.get("id").toString());
				member.setName(jsonObject.get("name").toString());
				member.setPw(jsonObject.get("pw").toString());
				readArr.add(member);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return readArr;
		
	}

}
