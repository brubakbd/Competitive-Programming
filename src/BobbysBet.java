import java.util.Scanner;

public class BobbysBet {
	public BobbysBet(){
		getVals();
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		for(int i = 0; i < num; i++){
			int r, s, x, y ,w;
			r = scan.nextInt(); //value to beat
			s = scan.nextInt(); //sides on da dais(u)
			x = scan.nextInt(); //how many rolls you must pass
			y = scan.nextInt(); //total number of rolls
			w = scan.nextInt(); //bet m-m-multiplier
			
			double probW = (double) (s - r + 1)/s;
			double prob = 0;
			for (int j = x; j <= y; j++) {
				prob += Math.pow(probW, j) * Math.pow((1-probW), y - j) * combination(y,j);
			}
//			
//			double probW = ((double)(s-r+1)/s);
////			System.out.println(prob);
//			double prob = 0;
//			for (int j = x; j <= y; j++){
//				prob+= Math.pow(probW, j)*Math.pow(1-probW, y-j)*multXY(j,y);
//				System.out.println(prob);
//			}
//			System.out.println();
//			prob = (prob * w);
//			double probL = 0;
//			for(int j = 0; j<x;j++){
//				probL+=Math.pow(probW, j)*Math.pow(1-probW, y-j)*multXY(j,y);
//				System.out.println(probL);
//			}
//			
//			
			if(prob * w > 1){
				System.out.println("yes");
			}
			else{
				System.out.println("no");
			}
		}
		scan.close();
	}
	
	public static int multXY(int x, int y) {
        int sum = 1;
		for(int i = x+1; i <= y; i++){
        	sum*=i;
        }
		return sum;
    }
	
	public int combination(int n, int k) {
		return (factorial(n) / (factorial(k) * factorial(n-k)));
	}
	
	public int factorial(int i) {
		if (i == 0) {
			return 1;
		}
		if (i == 1) {
			return 1;
		}
		return i * factorial(i - 1);
	}
	
	public static void main(String[] args){
		BobbysBet app = new BobbysBet();
	}
}
