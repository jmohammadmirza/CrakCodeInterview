/**
Given a string print the statement with a, b , c and corresponding word present in the statement

key A Value A
key b Value brown
key d Value dog
key f Value fox
key j Value jumps
key l Value lazy
key o Value over
key q Value quick
key t Value the

*/
package com.something.anything;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class IBM {

	public static void main(String[] args) {
	
		String statement="A quick brown fox jumps over the lazy dog";
		
		arrange(statement);

	}

	private static void arrange(String statement) {
		
		//int arrayLength=statement.length();
				
			String[] stmtArray	=statement.split(" ");
			
			   Map<String,String> resultMap=new TreeMap<String,String>();
			
			Arrays.stream(stmtArray).forEach(e->{
				
				
				resultMap.put(String.valueOf(e.charAt(0)), e);
				
			});
			for(Map.Entry<String, String> m:resultMap.entrySet()){
				System.out.println("key "+m.getKey()+" Value "+m.getValue());
			}
		
		
		
	}

}
