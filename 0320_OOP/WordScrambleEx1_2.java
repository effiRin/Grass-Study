import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordScrambleEx1_2 {

	public static void main(String[] args) {
			
			   String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"};

	           String answer = getAnswer(strArr);
	           String question = getScrambledWord(answer);

	           System.out.println("Question:"+question);
	           System.out.println("Answer:"+answer);
	     } // main
	
	
	 public static String getAnswer(String[] strArr) { 
   	 
		 int idx = (int)((Math.random()*strArr.length));
		 return strArr[idx];
    }

	 
    public static String getScrambledWord(String str) {
   	 
   	 List<Character> splitedWords = new ArrayList<Character>();
   	 
   	 for(char c : str.toCharArray()){
   		 splitedWords.add(c);  			// shuffle 사용을 위해 List<Character>로 바꿔주기 위한 for문
   		 }
   	 
   	 Collections.shuffle(splitedWords);   // 섞음

   	 StringBuilder builder = new StringBuilder();
   	 
   	 for(char c : splitedWords) {		// builder에 한 글자씩 더해주기
   		 builder.append(c);
   		 }
   	 
   	 String shuffled = builder.toString();		
   	 return shuffled;

    } 

	}

