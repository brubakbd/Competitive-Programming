import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Escape {
	private HashMap<Integer, ArrayList<Integer>> waysOut = new HashMap<Integer, ArrayList<Integer>>();
	private int numRooms;
	private int[] healthChange;
	private int testCases;
	private int exit;
	
	public void getValues(){
		Scanner scan = new Scanner(System.in);
		testCases = scan.nextInt();
		
		for(int j = 0; j < testCases; j++){
			numRooms = scan.nextInt();
			healthChange = new int[numRooms];
			exit = scan.nextInt();
			for(int i = 0; i < numRooms; i++){
				healthChange[i] = scan.nextInt();
			}
			for(int i = 0; i < numRooms-1; i++){
				int temp = scan.nextInt();
				int tempKey = scan.nextInt();
				if(waysOut.containsKey(tempKey)){
					waysOut.get(tempKey).add(temp);
				}
				else{
					ArrayList<Integer> tempArray = new ArrayList<Integer>(temp);
					waysOut.put(scan.nextInt(), tempArray);
				}
			}
		}
		
	}
	
	public boolean escape(ArrayList<ArrayList<Integer>> waysToEscape){
		
		
		return false;
	}
}
