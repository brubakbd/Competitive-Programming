import java.util.Scanner;

public class RestaurantRatings {

	public void getData(){
		Scanner scan = new Scanner(System.in);
		int numCritics = scan.nextInt();
		while(numCritics!=0){
			int[] critics = new int[numCritics];
			
			for(int i = 0; i < numCritics;i++){
				
			}
		}
	}
	//-1 = 1 < 2
	// 0 = 1 = 2
	// 1 = 1 > 2
	public int compareTo(int[] criticArray1, int[] criticArray2){
		if(criticArray1.equals(criticArray2))
			return 0;
		int sum1=0;
		int sum2 = 0;
		for(int i = 0; i < criticArray1.length; i++){
			sum1+=criticArray1[i];
			sum2+=criticArray2[i];
		}
		if(sum1>sum2)
			return 1;
		else if(sum1<sum2)
			return -1;
		else{
			return 0;
		}
	}
	public int findNum(int sum, int num){
		if(num == 1)
			return sum+1;
		
		
		return 0;
	}
}
