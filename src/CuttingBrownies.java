			import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CuttingBrownies {
	int vMoves;
	int hMoves;
	String fp;
	HashMap<Integer,ArrayList<Integer>> heightHash = new HashMap<Integer,ArrayList<Integer>>();
	HashMap<Integer,ArrayList<Integer>> widthHash = new HashMap<Integer,ArrayList<Integer>>();
	
	
	public CuttingBrownies(){
		getData();
	}
	public void getData(){
		Scanner scan = new Scanner(System.in);
		int numEntries = scan.nextInt();
		for(int i = 0; i < numEntries; i++){
			int w = scan.nextInt();
			int h = scan.nextInt();
			String s = scan.next();
			startGame(w,h,s);
		}
		
	}
	public void startGame(int width, int height, String firstPlayer){
		vMoves = width-1;
		hMoves = height-1;
		fp = firstPlayer;
		heightHash = new HashMap<Integer,ArrayList<Integer>>();
		widthHash = new HashMap<Integer,ArrayList<Integer>>();
		if(heightHash.containsKey(height))
			heightHash.get(height).add(width);
		else{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(width);
			heightHash.put(height,temp);
		}
		if(widthHash.containsKey(width))
			widthHash.get(width).add(height);
		else{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(height);
			widthHash.put(width,temp);
		}
		playTurn(fp);
	}
	public void playTurn(String player){
		if(player.equals("Vicky")){
			if(vMoves == 0){
				if(fp.equals("Vicky"))
					System.out.println("Vicky cannot win");
				else
					System.out.println("Harry can win");
				return;
			}
				
			int maxWidth=0;
			int tempHeight = 501;
			
			if(heightHash.get(1)==null || heightHash.get(1).isEmpty()){
				for(int i:widthHash.keySet()){
					if(i>maxWidth&&widthHash.get(i).size()!=0)
						maxWidth = i;
				}
				
				ArrayList<Integer> temp = widthHash.get(maxWidth);
				for(int i:temp){
					if(i < tempHeight)
						tempHeight = i;
				}
			}
			else{
				tempHeight = 1;
				maxWidth = heightHash.get(1).get(0);
			}
			int[] max = {tempHeight,maxWidth};
			
			if(!cutV(max)){
				//End game by not moving to another turn
			}
			else{
				playTurn("Harry");	
			}
		}
		else{
			if(hMoves==0){
				if(fp.equals("Harry"))
					System.out.println("Harry cannot win");
				else
					System.out.println("Vicky can win");
				return;
			}
			
			int maxHeight=0;
			int tempWidth = 501;
			
			if(widthHash.get(1)==null || widthHash.get(1).isEmpty()){
				for(int i:heightHash.keySet()){
					if(i>maxHeight&&heightHash.get(i).size()!=0)
						maxHeight = i;
				}
				
				ArrayList<Integer> temp = heightHash.get(maxHeight);
				for(int i:temp){
					if(i < tempWidth)
						tempWidth = i;
				}
			}
			else{
				maxHeight = 1;
				tempWidth = widthHash.get(1).get(0);
			}
			Integer[] max = {maxHeight,tempWidth};
			if(!cutH(max)){
				//End the game by not going into another turn
			}
			else{
				playTurn("Vicky");	
			}
		}
	}
	
	public boolean cutV(int[] toCut){
		if(vMoves == 0 || toCut[0] == toCut[1]){
			if(fp.equals("Vicky"))
				System.out.println("Vicky cannot win");
			else
				System.out.println("Harry can win");
			return false;
		}
		else{
			vMoves--;
			heightHash.get(toCut[0]).remove((Integer)toCut[1]);
			widthHash.get(toCut[1]).remove((Integer)toCut[0]);
			int[] left = {toCut[0],toCut[1]/2};
			int[] right = {toCut[0], toCut[1] - toCut[1]/2};
			if(left[1]!=left[0]){
				if(heightHash.containsKey(left[0]))
					heightHash.get(left[0]).add(left[1]);
				else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(left[1]);
					heightHash.put(left[0],temp);
				}
				if(widthHash.containsKey(left[1]))
					widthHash.get(left[1]).add(left[0]);
				else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(left[0]);
					widthHash.put(left[1],temp);
				}
			}
			if(right[1] != right[0]){
				if(heightHash.containsKey(left[0]))
					heightHash.get(right[0]).add(right[1]);
				else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(right[1]);
					heightHash.put(right[0],temp);
				}
				if(widthHash.containsKey(right[1]))
					widthHash.get(right[1]).add(right[0]);
				else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(right[0]);
					widthHash.put(right[1],temp);
				}
			}
			hMoves+=(toCut[0]-1);
			if(left[0] == left[1]){
				vMoves -= left[1]-1;
				hMoves -= left[0]-1;
			}
			if(right[0] == right[1]){
				vMoves -= right[1]-1;
				hMoves -= right[0]-1;
			}
			return true;
		}
	}
	public boolean cutH(Integer[] toCut){
		if(hMoves == 0 || toCut[0] == toCut[1]){
			if(fp.equals("Harry"))
				System.out.println("Harry cannot win");
			else
				System.out.println("Vicky can win");
			return false;
		}
		else{
			hMoves--;
			widthHash.get(toCut[1]).remove((Integer)toCut[0]);
			heightHash.get(toCut[0]).remove((Integer)toCut[1]);
			int[] left = {toCut[0]/2,toCut[1]};
			int[] right = {toCut[0]-toCut[0]/2, toCut[1]};
			if(left[1]!=left[0]){
				if(heightHash.containsKey(left[0]))
					heightHash.get(left[0]).add(left[1]);
				else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(left[1]);
					heightHash.put(left[0],temp);
				}
				if(widthHash.containsKey(left[1]))
					widthHash.get(left[1]).add(left[0]);
				else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(left[0]);
					widthHash.put(left[1],temp);
				}
			}
			if(right[1] != right[0]){
				if(heightHash.containsKey(right[0]))
					heightHash.get(right[0]).add(right[1]);
				else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(right[1]);
					heightHash.put(right[0],temp);
				}
				if(widthHash.containsKey(right[1]))
					widthHash.get(right[1]).add(right[0]);
				else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(right[0]);
					widthHash.put(right[1],temp);
				}
			}
			vMoves+=(toCut[1]-1);
			if(left[0] == left[1]){
				hMoves -= left[0]-1;
				vMoves -= left[1]-1;
			}
			if(right[0] == right[1]){
				hMoves -= right[0]-1;
				vMoves -= right[1]-1;
			}
			return true;
		}
	}
	public static void main(String[] args){
		CuttingBrownies app = new CuttingBrownies();
	}
}


