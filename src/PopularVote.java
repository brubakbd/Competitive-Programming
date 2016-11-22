import java.util.Scanner;

public class PopularVote {
	public PopularVote(){
		getVals();
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int numTests = scan.nextInt();
		for(int i = 0; i < numTests; i++){
			int numCand = scan.nextInt();
			int[] array = new int[numCand];
			int total = 0;
			int max = 0;
			int ind = 0;
			boolean tie = false;
			for(int j = 0; j<numCand; j++){
				int temp = scan.nextInt();
				array[j]+=temp;
				total+=temp;
				if(temp>max){
					max = temp;
					ind = j+1;
					tie = false;
				}
				else if(temp==max){
					tie = true;
				}
					
			}
			if(tie)
				System.out.println("no winner");
			else if(max>total/2)
				System.out.println("majority winner "+ ind);
			else
				System.out.println("minority winner "+ ind);
				
		}
	}
	public static void main(String[] args){
		PopularVote app = new PopularVote();
	}
}
