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
	void read() {				
		TestJson writeJson = new TestJson();
		TestClass member = new TestClass();
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:\\work\\sts-4.4.0.RELEASE-workspace\\home\\testJson.json"));			
			JSONArray jsonArray = (JSONArray)obj;
			
			for(int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject)jsonArray.get(i);
				System.out.println("name : " + jsonObject.get("name"));
				System.out.println("id   : " + jsonObject.get("id"));
				System.out.println("pw   : " + jsonObject.get("pw"));
				member.setId(jsonObject.get("id").toString());
				member.setName(jsonObject.get("name").toString());
				member.setPw(jsonObject.get("pw").toString());
				writeJson.addList(member);
			}				

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
