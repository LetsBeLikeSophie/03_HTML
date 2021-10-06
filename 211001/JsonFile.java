package a.b.c.com.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonFile {
	
	public static final String JSON_FILE_NAME = "JsonTest2";
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONObject personInfo = new JSONObject();
		personInfo.put("name", "LeeDaHee");
		personInfo.put("age", "24");
		personInfo.put("jobInfo", "programmer");
		
		JSONArray hobbyList = new JSONArray();
		hobbyList.add("programming");
		hobbyList.add("working");
		hobbyList.add("book");
		
		personInfo.put("message", hobbyList);
		
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(CommonJSON.JSON_FILE_PATH +"/"+ JSON_FILE_NAME + ".json"));
			bw.write(personInfo.toJSONString());
			bw.flush();
			bw.close(); //¹«Á¶°Ç ´Ý¾ÆÁà¾ßÇÑ´Ù.
		}catch(IOException e){
			
		}
		
		System.out.println("personInfo >>> : " + personInfo);
	}
}
