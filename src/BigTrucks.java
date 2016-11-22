import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BigTrucks {
    int minDistance = 10000;
    int maxItems = 0;
    int numPoints = 0;
    ArrayList<Integer> itemList = new ArrayList<Integer>();
    HashMap<Integer, HashSet<intPair>> connections = new HashMap<Integer, HashSet<intPair>>();
    
    
    public class intPair{
        int first;
        int second;
        public intPair(int f, int s){
            first= f;
            second = s;
        }
        public int getFirst(){
            return first;
        }
        public int getSecond(){
            return second;
        }
    }
    
    public void getVals(){
        
        Scanner scan = new Scanner(System.in);
        numPoints = scan.nextInt();
        for(int i = 0; i < numPoints; i++){
            itemList.add(scan.nextInt());
        }
        int numRoads = scan.nextInt();
        for(int i = 0; i < numRoads; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int d = scan.nextInt();
            if(connections.containsKey(a))
                connections.get(a).add(new intPair(b,d));
            else{
                HashSet<intPair> temp = new HashSet<intPair>();
                temp.add(new intPair(b,d));
                connections.put(a, temp);
            }
            if(connections.containsKey(b))
                connections.get(b).add(new intPair(a,d));
            else{
                HashSet<intPair> temp = new HashSet<intPair>();
                temp.add(new intPair(a,d));
                connections.put(b, temp);
            }
        }
        
        if(!connections.containsKey(1) || !connections.containsKey(numPoints)){
            System.out.println("impossible");
            return;
        }
        HashSet<Integer> templist = new HashSet<Integer>();
        templist.add(1);
        for(intPair pair:connections.get(1)){
            recursion(0, itemList.get(0), pair,1,templist);
        }
        scan.close();
        if(minDistance==10000 && maxItems == 0){
            System.out.println("impossible");
            return;
        }
        System.out.println(minDistance + " " + maxItems);
        
    }
    
    public void recursion(int curLen, int curItems, intPair curPair, int prev, HashSet<Integer> visited){
        HashSet<Integer> visitedArray = new HashSet<Integer>(visited);
        curLen+=curPair.getSecond();
        curItems += itemList.get(curPair.getFirst()-1);
        if(curLen>minDistance || visitedArray.contains(curPair.getFirst()))
            return;
        visitedArray.add(curPair.getFirst());
        if(curPair.getFirst() == numPoints){
            if(curLen<minDistance){
                minDistance = curLen;
                maxItems = curItems;
            }
            if(curLen==minDistance && curItems>maxItems){
                maxItems=curItems;
            }
            return;
        }
        else{
            if(!connections.containsKey(curPair.getFirst()))
                    return;
            for(intPair pair:connections.get(curPair.getFirst())){
                if(pair.getFirst()!=prev)
                    recursion(curLen, curItems, pair,curPair.getFirst(),visitedArray);
            }
        }
    }
    
    public BigTrucks(){
        getVals();
    }
    public static void main(String[] args){
//        BigTrucks app = new BigTrucks();
    	int x = 1;
    	int y = x;
    	y++;
    	System.out.println(x +" "+y);
    }
}
