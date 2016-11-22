import java.util.Scanner;

public class SimonSays {

	public SimonSays(){
		getVals();
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < num; i++){
			String temp = scan.nextLine();
				if(temp.length()>=11){
				String sub = temp.substring(0,10);
				if (sub.equals("Simon says")){
					System.out.println(temp.substring(11));
				}
			}
		}
	}
	public static void main(String[] args){
		SimonSays app = new SimonSays();
	}
}
