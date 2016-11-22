import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Bakery {
	public Bakery(){
		getVals();
	}
	class Pair{
		int num;
		int dist;
		public Pair(int n, int d){
			num = n;
			dist = d;
		}
	}
	HashMap<Integer,ArrayList<Pair>> adjList = new HashMap<Integer, ArrayList<Pair>>();
	ArrayList<Integer> storages = new ArrayList<Integer>();
	int minDist = -1;
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int numCities = scan.nextInt();
		int numRoads = scan.nextInt();
		int numStorages = scan.nextInt();
		
		for(int i = 0; i < numRoads; i++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			int d = scan.nextInt();
			Pair temp = new Pair(y,d);
			if(adjList.containsKey(x)){
				ArrayList<Pair> tempList = adjList.get(x);
				tempList.add(temp);
			}
			else{
				ArrayList<Pair> tempList = new ArrayList<Pair>();
				tempList.add(temp);
				adjList.put(x, tempList);
			}
			temp = new Pair(x,d);
			if(adjList.containsKey(y)){
				ArrayList<Pair> tempList = adjList.get(y);
				tempList.add(temp);
			}
			else{
				ArrayList<Pair> tempList = new ArrayList<Pair>();
				tempList.add(temp);
				adjList.put(y, tempList);
			}
		}
		for(int i = 0; i < numStorages; i++){
			storages.add(scan.nextInt());
		}
		
		for(int i = 0; i <numStorages; i++){
			if(adjList.get(storages.get(i))==null)
				continue;
			for(Pair p: adjList.get(storages.get(i))){
				if(storages.contains(p.num))
					continue;
				else{
					if(p.dist<minDist||minDist==-1){
						minDist=p.dist;
					}
				}
			}
		}
		System.out.println(minDist);
	}
	
	public static void main(String[] args){
		Bakery app = new Bakery();
	}
}
