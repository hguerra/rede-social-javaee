package com.model.util;

import java.util.List;

public class ValidInformation {
	public static boolean valid(String parameter) {
		if (parameter != null && !parameter.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean valid(List<String> parameters){
		boolean result = true;
		for(String list: parameters){
			result =   result && (valid(list));
		}
		return result;
	}
	
	public static boolean valid(Object parameter) {
		if (parameter != null) {
			return true;
		}
		return false;
	}
	
}
