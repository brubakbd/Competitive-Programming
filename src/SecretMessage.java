import java.util.Scanner;

public class SecretMessage {
	public SecretMessage(){
		getVals();
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < num; i++){
			String temp = scan.nextLine();
			int squareNum = (int) Math.ceil(Math.sqrt((double)temp.length()));
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < squareNum; j++){
				for(int k = squareNum-1; k >=0; k-=1){
					if((k*squareNum+j)<temp.length())
						sb.append(temp.charAt(k*squareNum+j));
				}
			}
			System.out.println(sb.toString());
		}
	}
	public static void main(String[] args){
		SecretMessage app = new SecretMessage();
	}
}
