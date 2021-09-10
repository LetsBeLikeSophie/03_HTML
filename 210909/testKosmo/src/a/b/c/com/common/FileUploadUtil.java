package a.b.c.com.common;

import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class FileUploadUtil {

	public static final String ECODE_TYPE = "EUC-KR";
	public static final  int SIZE_LIMIT = 5240880;	
	private MultipartRequest m;
	
	public FileUploadUtil(){
		
	}
	
	public boolean fileUpldad(HttpServletRequest hReq, String filePaths){
			
		boolean fb = false;
		try{
			m = new MultipartRequest( hReq
                                     ,filePaths
                                     ,FileUploadUtil.SIZE_LIMIT
                                     ,FileUploadUtil.ECODE_TYPE
                                     ,new FileReName());			
			return fb = true;			
		}catch(Exception e){
			System.out.println("BabyFileUploadUtil.fileUpldad() >>> : " + e);
		}
		
		return fb;		
	}
	
	public String getParameter(String s){
		return m.getParameter(s);
	}
	
	@SuppressWarnings("unchecked")
	public Enumeration<String> getFileNames(){
		Enumeration<String> en = m.getFileNames();
		Vector<String> v = new Vector<String>();
		
		while (en.hasMoreElements()){
			String f = en.nextElement().toString();
			v.add(m.getFilesystemName(f));
		}		
		return v.elements();
	}
	
	public String getFileName(String f){
		return m.getFilesystemName(f);
	}	
}
