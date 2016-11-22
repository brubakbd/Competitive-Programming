import java.io.FileReader;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Scanner;

public class QuickBrownFox {
	private int numTests;
	private String currentString;
	
	public QuickBrownFox(){
		getVals();
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			numTests = Integer.parseInt(scan.nextLine());
			for(int i = 0; i < numTests; i++){
				currentString = scan.nextLine();
				System.out.println(isPangram(currentString));
			}
		}
		scan.close();
	}
	public String isPangram(String s){
		String temp = "";
		s = s.toLowerCase();
		for(int i = 'a'; i <= 'z'; i++){
			if(s.indexOf(i)==-1){
				temp = temp + (char)i;
			}
		}
		if(temp.isEmpty()){
			return "pangram";
		}
		else{
			return ("missing "+temp);
		}
	}

	public static void main(String[] args){
		QuickBrownFox app = new QuickBrownFox();
	}
}
