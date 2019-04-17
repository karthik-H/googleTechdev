 
 import java.util.Map;
 import java.util.HashMap;
 import java.util.List;
 import java.util.ArrayList;
 public class Search {
	 
	 public static void main(String[] s) {
			//Map<String,List<Integer>> inputIndex = ;
			List<String> dictinary = new ArrayList<String>();
			dictinary.add("able");
			dictinary.add("balee");
			dictinary.add("apple");
			dictinary.add("kangaroo");
			dictinary.add("ale");
			createSizeMatch(dictinary,createMapIndex("abppplee"));
	 }
	 /**
	 *createMapIndex fuction create map of string,integerlist where integer list contain the position of occurence
	 *of character in the given string
	 **/
	 public static Map<String,List<Integer>> createMapIndex(String str) {
		 
		 Map<String,List<Integer>> indexList = new HashMap<String,List<Integer>>();
		 //iterate over given string
		 for(int i = 0;i < str.length();i++) {
			 //check if the value already existes or not if not add new value and add index to list else append the 
			 //to list
			 if(!indexList.containsKey(Character.toString(str.charAt(i)))) {
				 List<Integer> intvalues = new ArrayList<Integer>();
				 intvalues.add(i);
				 indexList.put(Character.toString(str.charAt(i)),intvalues);
			 }
			 else {
				 List<Integer> intvalues = indexList.get(Character.toString(str.charAt(i)));
				 intvalues.add(i);
				 indexList.put(Character.toString(str.charAt(i)),intvalues);
				 
			 }
		 }
		 //print the map
		 for(String s : indexList.keySet()) {
			 System.out.println(s + " "+ indexList.get(s));
		 }
		 return indexList;
	 }
	 /**
	 * fuction will create the size of the word match for each dictinary word with respect to input
	 **/
	 public static void createSizeMatch(List<String> dictinary, Map<String,List<Integer>> input) {
		 String bestMatch ="",dictinaryString = "";
		 int previousMatch = -1,dicCount = 0,matchCount=0;
		 //iterate over dictinary
		 while(dicCount < dictinary.size()) {
			 dictinaryString = dictinary.get(dicCount);
			 //iterate over input for each dictinary word
			 for(int i = 0;i < dictinaryString.length();i++) {
				 String dictinaryChar = Character.toString(dictinaryString.charAt(i));
				 //check dictinary word availablity with input
			 if(input.get(dictinaryChar) != null){
				 List<Integer> mapValue = input.get(dictinaryChar);
				 for(int listitr = 0;listitr < mapValue.size();listitr++) {
					 if(mapValue.get(listitr) > previousMatch){
						 previousMatch = mapValue.get(listitr);
						 matchCount++;
						 break;
					 }
				 }
			 }
			 
		 }
			System.out.println(dictinaryString+""+matchCount);
			 previousMatch = -1;
			 matchCount =0;
		 dicCount++;
		 }
		 
	 }
	 
 }