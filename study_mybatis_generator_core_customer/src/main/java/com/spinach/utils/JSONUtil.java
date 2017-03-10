package com.spinach.utils;

import com.google.gson.Gson;

public class JSONUtil {
	private static Gson gson = null;
	
	static{
		if(null == gson){
			gson = new Gson();
		}
	}
	public static String jsonToString(Object object) {
		String str = null;
		try {
			str = gson.toJson(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
