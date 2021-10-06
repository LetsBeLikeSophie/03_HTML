package a.b.c.com.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class OracleJsonTest{
	
	@SuppressWarnings("unchecked")
	public static String getJson(String tableName) {
			
		Connection con = null;	
		Statement stmt = null;
		ResultSet rsRs = null;
		ResultSetMetaData resultMeta = null;
		int colCount = 0;
		String jArrStr = "";	
		
		try{
			con = CommonJSON.getConnection();
			stmt = con.createStatement();
			rsRs = stmt.executeQuery("SELECT * FROM " + tableName);	
			
			resultMeta = rsRs.getMetaData();
			colCount = resultMeta.getColumnCount();
								
			JSONArray jArr = new JSONArray();
			JSONObject jObj = null;
			
			while (rsRs.next()){
				
				jObj = new JSONObject();
				
				for (int i=0; i < colCount; i++){
					String columnName = resultMeta.getColumnName(i+1);
					String dataName = rsRs.getString(i+1);
				
					jObj.put(columnName, dataName);
				}
				
				if (jObj !=null){
					jArr.add(jObj);
					jArrStr = jArr.toString();
				}
			}
			// System.out.println("jArr >>> : " + jArr);
		
		}catch(SQLException e) {
			System.out.println("getJson() : " + e);
		}finally {}			
		
		return jArrStr;
	}
	
	public static boolean jsonParse(String fileName, String jsonVal){
		
		boolean bool = false;
		
		try {
			
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(CommonJSON.JSON_FILE_PATH +"/"+fileName.toLowerCase() + ".json"));
			bw.write(jsonVal);
			bw.flush();
			bw.close(); //������ �ݾ�����Ѵ�.
			
			bool = true;
		}catch(IOException e){
			System.err.println(e);
		}
		
		return bool;
	}

	
	public static void main(String args[]){

		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("json ������ ������ ���̺� �̸��� �Է��Ͻÿ� !!");
			String tableName = sc.next();
			
			if (tableName !=null && tableName.length() > 0 ) {
				String s = OracleJsonTest.getJson(tableName);
				System.out.println("s >>> : \n" + s);
				
				if (s.length() > 0) {
					boolean bool = OracleJsonTest.jsonParse(tableName, s);
					
					if (bool){
						File f = new File(CommonJSON.JSON_FILE_PATH +"/"+tableName.toLowerCase() + ".json");
						System.out.println("\n" + f.getName() + " ������ �� �����Ǿ����ϴ�. ");
					}else{
						System.out.println(" ������ ���� ���� �ʾҽ��ϴ�. ");
					}	
				}else {
					
				}
			}else {
				
			}
		}catch(Exception e){
			System.out.println("������ >>> : " + e.getMessage());
		}		
	}
}
