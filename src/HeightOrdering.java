import java.util.Scanner;

public class HeightOrdering {

	int numCases;
	int[] heights = new int[20];
	int stepsBack;
	
	public static void main(String[] args){
		HeightOrdering app = new HeightOrdering();
	}
	public HeightOrdering(){
		Scanner scan = new Scanner(System.in);
		numCases = scan.nextInt();
		for(int n = 1; n <= numCases; n++){
			stepsBack = 0;
			scan.nextInt();
			for(int i = 0; i < heights.length; i++){
				heights[i] = scan.nextInt();
			}
			System.out.println(n + " " + solve());
		}
	}
	public int solve(){
		for(int i = 1; i < heights.length;i++){
			boolean foundTaller = false;
			for(int j = 0; j < heights.length; j++){
				if(heights[i] < heights[j]){
					if(i != j-1){
						stepBack(heights[i],j,i);
						if(i!=heights.length-1){
							i--;
						}
					}
					foundTaller = true;
					//System.out.println(makeString(heights));
					j = heights.length;
				}
			}
			if(!foundTaller){
				if(i!=heights.length-1){
					stepForward(heights[i],i);
					i--;
				}
			}
			//System.out.println(makeString(heights) + " count: "+stepsBack);
		}
		return stepsBack;
	}
	public void stepBack(int h, int stepTo, int hIndex){
		if(stepTo > hIndex){
			for(int i = hIndex; i < stepTo; i++){
				heights[i] = heights[i+1];
			}
			heights[stepTo-1] = h;
			stepsBack+=(stepTo - hIndex - 1);
		}
		else{
			for(int i = hIndex; i > stepTo; i--){
				heights[i] = heights[i-1];
			}
			heights[stepTo] = h;
			stepsBack+=hIndex - stepTo;
		}
	}
	public void stepForward(int h, int hIndex){
		for(int i = hIndex; i < heights.length-1; i++){
			heights[i] = heights[i+1];
		}
		heights[heights.length-1] = h;
		stepsBack+=(heights.length-1-hIndex);
	}
	public String makeString(int[] array){
		String s = "";
		for(int i = 0; i < array.length; i ++){
			s = s + array[i] + " ";
		}
		return s;
	}
}
