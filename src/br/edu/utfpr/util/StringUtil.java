package br.edu.utfpr.util;

import java.util.Arrays;

public class StringUtil {
	
	public static String formalizeName(String name){
		String[] parts = name.split(" ");
		String[] pronoun = new String[] {"da","dos","do","de"};
				
		for (int i = 0; i < parts.length; i++) {
			parts[i] = parts[i].toLowerCase();
			if(Arrays.asList(pronoun).contains(parts[i]))
				continue;
			else
				parts[i] = parts[i].substring(0,1).toUpperCase() + parts[i].substring(1);
		}		
		return implodeArray(parts, " ");
	}
	
	public static String implodeArray(String[] inputArray, String glueString) {

		/** Output variable */
		String output = "";

		if (inputArray.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(inputArray[0]);

			for (int i=1; i<inputArray.length; i++) {
				sb.append(glueString);
				sb.append(inputArray[i]);
			}

			output = sb.toString();
		}

		return output;
	}

}
