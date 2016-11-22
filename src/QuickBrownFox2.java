import java.util.HashSet;
import java.util.Scanner;

public class QuickBrownFox2 {
	
	public QuickBrownFox2(){
		getVals();
	}
	public HashSet<Character> init(HashSet<Character> set){
		for(int i = 97; i < 123; i++){
			set.add((char)i);
		}
		return set;
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < num; i++){
			HashSet<Character> set = new HashSet<Character>();
			set = init(set);
			char[] temp = scan.nextLine().toLowerCase().toCharArray();
			for (int j = 0; j < temp.length; j++){
				if(set.contains(temp[j])){
					set.remove(temp[j]);
				}
			}
			if(set.size()==0)
				System.out.println("pangram");
			else{
				StringBuilder sb= new StringBuilder();
				for(char ch : set){
					sb.append(ch);
				}
				System.out.println("missing " + sb.toString());
			}
		}
		
	}
	public static void main(String[] args){
		QuickBrownFox2 app = new QuickBrownFox2();
	}
}
