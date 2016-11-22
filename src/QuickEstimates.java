import java.util.Scanner;

public class QuickEstimates {
	int numLines = 0;
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		numLines = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < numLines; i++){
			String temp = scan.nextLine();
			System.out.println(temp.length());
		}
	}
	public QuickEstimates(){
		getVals();
	}
	public static void main(String[] args){
		QuickEstimates app = new QuickEstimates();
	}
	
}
