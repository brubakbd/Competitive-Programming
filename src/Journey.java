import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Journey {
	class Pair{
		int num;
		int dist;
		public Pair(int n, int d){
			num = n;
			dist = d;
		}
	}
	HashMap<Integer,ArrayList<Pair>> adjList = new HashMap<Integer, ArrayList<Pair>>();
	public Journey(){
		getVals();
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int numShowplace = scan.nextInt();
		int numRoads = scan.nextInt();
		int time = scan.nextInt();
		
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
		}
		LinkedList<Pair> maxList = new LinkedList<Pair>();
		int maxDist=0;
		int maxNodes=0;
		int[] reachable = new int[numShowplace];
		
		LinkedList<Pair> list = new LinkedList<Pair>();
		int curDist = 0;
		Stack<Pair> s = new Stack<Pair>();
		Pair temp = new Pair(1,0);
		s.push(temp);
		int realNums = 1;
		while(!s.isEmpty()){
			Pair popped = s.pop();
			if(realNums==0)
				break;
			else if(popped.num==-1){
				Pair tPair = list.pop();
				curDist-=tPair.dist;
				if(tPair.num==numShowplace){
					reachable[tPair.num-1]=1;
					continue;
				}
				for(Pair p:adjList.get(tPair.num)){
					if(reachable[p.num-1]==1){
						reachable[tPair.num-1]=1;
						break;
					}
				}
			}
			else if(popped.num==numShowplace){
				realNums--;
				list.push(popped);
				curDist+=popped.dist;
				if(curDist<=time && list.size()>maxNodes){
					maxDist = curDist;
					maxNodes = list.size();
					maxList = new LinkedList<Pair>(list);
				}
			}
			else if(reachable[popped.num-1]==-1){
				continue;
			}
			else{
				realNums--;
				if(adjList.get(popped.num) != null){
					list.push(popped);
					curDist+=popped.dist;
					if(curDist>time)
						continue;
					for(Pair pair:adjList.get(popped.num)){
						Pair tempi = new Pair(-1,-1);
						s.push(tempi);
						s.push(pair);
						realNums++;
					}
				}
				else{
					reachable[popped.num-1]=-1;
				}
			}			
		}
		
		System.out.println(maxNodes);
		StringBuilder sb = new StringBuilder();
		for(int i = maxList.size()-1; i>=0; i--){
			sb.append(maxList.get(i).num);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
	public static void main(String[] args){
		Journey app = new Journey();
	}
}
