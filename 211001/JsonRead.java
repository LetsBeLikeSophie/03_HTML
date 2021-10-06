package a.b.c.com.common;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		
		try {
			String jsonFilePath = CommonJSON.JSON_FILE_PATH;
			File jsonFile = new File( jsonFilePath + "/JsonRead.json");
			
			Object obj = parser.parse(new FileReader(jsonFile));
			JSONObject jsonObject = (JSONObject)obj;
			
			String name = (String)jsonObject.get("name");
			System.out.println("name >>> : " + name);
			
			long id = (Long)jsonObject.get("id");
			System.out.println("id >>> : " + id);
			
			JSONArray phoneNum = (JSONArray)jsonObject.get("phoneNumbers");
			Iterator iter = phoneNum.iterator();
			while (iter.hasNext()){
				System.out.println("phoneNum >>> : " + iter.next());
			}
			
			JSONArray array = (JSONArray)jsonObject.get("address");			
			for(int i=0; i < array.size(); i++){
				JSONObject result = (JSONObject)array.get(i);
				//System.out.println("street >>> : " + result.get("street"));
				//System.out.println("city >>> : " + result.get("city"));
				System.out.println("address >>> : " + result.get("zipcode"));
			}
			
			//String role = (String)jsonObject.get("role");
			//System.out.println("role >>> : " + role);
		}catch(Exception e){
			
		}
	}
}
/*
https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
*/