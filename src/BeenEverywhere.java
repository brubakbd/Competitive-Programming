import java.util.HashSet;
import java.util.Scanner;

public class BeenEverywhere {
	public BeenEverywhere(){
		getVals();
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int numTests = scan.nextInt();
		for(int i = 0; i < numTests; i++){
			int numCities = scan.nextInt();
			HashSet<String> cities = new HashSet<String>();
			for(int j = 0; j < numCities; j++){
				cities.add(scan.next());
			}
			System.out.println(cities.size());
		}
	}
	public static void main(String[] args){
		BeenEverywhere app = new BeenEverywhere();
	}
}
