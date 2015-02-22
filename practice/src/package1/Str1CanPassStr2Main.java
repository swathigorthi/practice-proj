package package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import package2.Subclass1;

public class Str1CanPassStr2Main {
	public static List<String> dictionarySet = Arrays.asList("head", "lead", "heal", "heat", "heel", "hell", "hall", "tell", "tall", "tail", "hail");
	public static String testString1 = "head",testString3 = "tail", testString2 = "heel";
	
	public static void canPassTest(){
		if(canPass(testString1, testString2)){
			System.out.println("Test 1 Passed");
		}
		else{
			System.out.println("Test 1 failed");
		}
		if(canPass(testString1, testString3)){
			System.out.println("Test 2 Passed");
		}
		else{
			System.out.println("Test 2 failed");
		}
		if(canPass("head", "heal")){
			System.out.println("Test 3 Passed");
		}
		else{
			System.out.println("Test 3 failed");
		}
	}
	public static boolean canPass(String str1, String str2){
		return canPass(str1, str2, new HashSet<String>());
	}
	 public static boolean canPass(String str1, String str2, Set<String> visitedStrings){
		 StringBuilder str = new StringBuilder(str1);
		 
		 if(str1.equals(str2)){
			 return true;
		 }
		 visitedStrings.add(str1);
		 Set<String> childrenStringsNotVisited = getChildrenStringsNotVisited(str1, str2, visitedStrings);
		if(childrenStringsNotVisited.contains(str2)){
			return true;
		}
		else{
			for(String childStr : childrenStringsNotVisited){
				if(canPass(childStr, str2, visitedStrings)){
					return true;
				}
			}
		}
	
		return false;
	 }
	 
	 public static Set<String> getChildrenStringsNotVisited(String str1, String str2, Set<String>visitedStrings){
		 Set<String> childrenStringsNotVisited = new HashSet<>();
		 StringBuilder str = new StringBuilder(str1);
		 for(int i = 0; i<str1.length() ; i++){
			 for(int j= 0 ;j<str2.length();j++){
				 char ch = str2.charAt(j);
				 if(ch!= str.charAt(i)){
					 str.setCharAt(i, ch);
					 if(!visitedStrings.contains(str.toString()) && dictionarySet.contains(str.toString())){
						 visitedStrings.add(str.toString());
						 childrenStringsNotVisited.add(str.toString());
					 }
					 else{
						 visitedStrings.add(str.toString());
					 }
				 }
				 
			 }
			 str.setCharAt(i, str1.charAt(i));
		 }
		 return childrenStringsNotVisited;
	 }


	public static void main(String[] args) {
	      canPassTest();
	}

}
