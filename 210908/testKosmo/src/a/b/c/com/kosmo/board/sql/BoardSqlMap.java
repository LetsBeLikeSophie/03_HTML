package a.b.c.com.kosmo.board.sql;

public abstract class BoardSqlMap {
	
	public static String getBoardSelectAllQuery(){ 
		return null;
	}
	
	public static String getBoardSelectQuery(){ 
		return null;
	}
	
	public static String getBoardInsertQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		MVC_BOARD 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("     			 BNUM 				\n"); // COLUMN 1
		sb.append("				  	,BSUBJECT 			\n"); // COLUMN 2
		sb.append("					,BWRITER 			\n"); // COLUMN 3
	    sb.append("					,BPW   				\n"); // COLUMN 4	
		sb.append("					,BMEMO				\n"); // COLUMN 5
		sb.append("					,BPHOTO				\n"); // COLUMN 6
	    sb.append("					,DELETEYN			\n"); // COLUMN 7
	    sb.append("					,INSERTDATE			\n"); // COLUMN 8
	    sb.append("					,UPDATEDATE			\n"); // COLUMN 9
		sb.append("			      )						\n");
		sb.append("	       VALUES (  					\n");			
		sb.append("						 ? 				\n");// placeholder 1
	    sb.append("						,?   			\n");// placeholder 2
	    sb.append("						,?   			\n");// placeholder 3
	    sb.append("						,?   			\n");// placeholder 4
	    sb.append("						,? 				\n");// placeholder 5
	    sb.append("						,? 				\n");// placeholder 6
	    sb.append("						,'Y'			\n");// placeholder 7
	    sb.append("						,SYSDATE 		\n");// placeholder 8
	    sb.append("						,SYSDATE 		\n");// placeholder 9	
		sb.append("	              )						\n");		
		
		return sb.toString();
	}
	
	public static String getBoardUpdateQuery(){ 
		return null;
	}
	
	public static String getBoardDeleteQuery(){ 
		return null;
	}

}
