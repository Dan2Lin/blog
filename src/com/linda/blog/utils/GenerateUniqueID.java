package com.linda.blog.utils;

import java.util.Date;
import java.util.Random;

public class GenerateUniqueID {
	
	public static int getSecondTimestamp(Date date){  
	    if (null == date) {  
	        return 0;  
	    }  
	    String timestamp = String.valueOf(date.getTime());  
	    int length = timestamp.length();  
	    if (length > 3) {  
	        return Integer.valueOf(timestamp.substring(0,length-3));  
	    } else {  
	        return 0;  
	    }  
	}
	
	public static String generateUserId() {
		Random random = new Random();
		return String.valueOf(new Date().getTime()) + random.nextInt(1000);
	}
	public static String generateArticleId() {
		Random random = new Random();
		return String.valueOf(new Date().getTime()) + random.nextInt(2000);
	}
}
