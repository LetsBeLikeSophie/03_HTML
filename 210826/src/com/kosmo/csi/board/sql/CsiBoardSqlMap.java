package com.kosmo.csi.board.sql;

public abstract class CsiBoardSqlMap {
	
	
	public static String getCboardChabunQueryMap() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  											\n");
		sb.append("         NVL(MAX(SUBSTR(A.BNUM, -4)), 0) + 1 COMMNO	\n");
		sb.append(" FROM    CSI_BOARD A 								\n");	   	  

	    return sb.toString();
	};
	
	
	public static String getCboardSelectAllQueryMap() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.BNUM 		BNUM 			\n");
		sb.append("		,A.BSUBJECT  	BSUBJECT 		\n");
		sb.append("		,A.BWRITER  	BWRITER 		\n");
		sb.append("		,A.BCONTENTS  	BCONTENTS		\n");	 
	    sb.append("		,A.BPW  		BPW   			\n");	    	    
	    sb.append("		,A.DELETEYN 	BDELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	      
	    sb.append("	FROM 								\n");
	    sb.append("		 CSI_BOARD A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC						\n");

	    return sb.toString();
	};
	
	
	public static String getCboardSelectQueryMap() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.BNUM 		BNUM 			\n");
		sb.append("		,A.BSUBJECT  	BSUBJECT 		\n");
		sb.append("		,A.BWRITER  	BWRITER 		\n");
		sb.append("		,A.BCONTENTS  	BCONTENTS		\n");	 
	    sb.append("		,A.BPW  		BPW   			\n");	    	    
	    sb.append("		,A.DELETEYN 	BDELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	      
	    sb.append("	FROM 								\n");
	    sb.append("		 CSI_BOARD A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.BNUM   = ?					\n");

	    return sb.toString();
	};
	
	
	public static String getCboardInsertQueryMap() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		CSI_BOARD 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("     			 BNUM 				\n"); 
		sb.append("				  	,BSUBJECT 			\n"); 
		sb.append("					,BWRITER 			\n"); 
		sb.append("					,BCONTENTS			\n"); 
	    sb.append("					,BPW   				\n"); 
	    sb.append("					,DELETEYN			\n"); 
	    sb.append("					,INSERTDATE			\n"); 
	    sb.append("					,UPDATEDATE			\n"); 
		sb.append("			      )						\n");
		sb.append("	       VALUES (  					\n");			
		sb.append("						 ? 				\n");
	    sb.append("						,?   			\n");
	    sb.append("						,?   			\n");
	    sb.append("						,?   			\n");
	    sb.append("						,? 				\n");
	    sb.append("						,'Y'			\n");
	    sb.append("						,SYSDATE 		\n");
	    sb.append("						,SYSDATE 		\n");
		sb.append("	              )						\n");		
		
		return sb.toString();
	};
	
	
	public static String getCboardUpdateQueryMap() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   CSI_BOARD 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   BSUBJECT	  		= ?			\n");	    
	    sb.append("		  ,BCONTENTS		= ?			\n");	    	    
	    sb.append("		  ,UPDATEDATE 		= SYSDATE	\n");
		sb.append("	WHERE  BNUM 			= ?			\n");	    
		sb.append("	AND    DELETEYN 		= 'Y'  		\n");		
					
		return sb.toString();		
	};
	
	
	public static String getCboardDeleteQueryMap() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   CSI_BOARD 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,UPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  BNUM	 		= ?				\n");	    
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");		
					
		return sb.toString();	
	};

}
