import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SafePassage {
	private int numPeople;
	public ArrayList<Integer> times;
	private int time;
	private int sum2 =0;
	
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		numPeople = scan.nextInt();
		times = new ArrayList<Integer>();
		for(int i = 0; i < numPeople; i++){
			int temp = scan.nextInt();
			times.add(temp);
			sum2+=temp;
		}
		Collections.sort(times);
		sum2+=(times.size()-3)*times.get(0);
		
	}
	public void getTime(){
		int counter = 0;
		time+= times.get(0) + times.get(1) + times.get(times.size()-1);
		boolean flag = true;
		for (int i = times.size()-2; i > 1; i--){
			if(flag){
				time+=Math.min(2*times.get(1), times.get(0)+times.get(i));
				flag = !flag;
			}
			else{
				time+=times.get(0)+times.get(i);
				flag = !flag;
			}
		}
		
		
	}
	public SafePassage(){
		getVals();
		getTime();
		if (time<sum2)
			System.out.println(time+"");
		else
			System.out.println(sum2+"");
	}
	public static void main(String[] args){
		SafePassage app = new SafePassage();
	}
}
