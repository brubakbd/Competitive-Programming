import java.math.BigInteger;
import java.util.Scanner;

public class InverseFactorial {
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		BigInteger big  = new BigInteger(scan.nextLine());
		BigInteger temp = new BigInteger("1");
		int i = 2;
		while(true){
			if(big.equals(temp)){
				System.out.println(i-1);
				return;
			}
			temp = temp.multiply(new BigInteger(Integer.toString(i)));
			i++;
		}
	}
	public InverseFactorial(){
		getVals();
	}
	public static void main(String[] args){
		InverseFactorial app = new InverseFactorial();
	}
}
