import java.util.HashMap;
import java.util.Scanner;

public class NinePacks {

	public NinePacks(){
		getVals();
	}
	
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		HashMap<Integer,Integer> hPacks = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> bPacks = new HashMap<Integer,Integer>();
		for(int i = 0; i<h;i++){
			int temp = scan.nextInt();
			HashMap<Integer,Integer> clone = (HashMap<Integer,Integer>) hPacks.clone();
			for(Integer k : clone.keySet()){
				if(clone.containsKey(k+temp)){
					if(clone.get(k+temp)>(clone.get(k)+1))
						hPacks.put(k+temp,hPacks.get(k)+1);
				}
				else
					hPacks.put(k+temp,clone.get(k)+1);
				
//				System.out.println(k + " " + temp);
//				System.out.println(hPacks.toString());
//				System.out.println(clone.toString());
			}
			
			if(clone.containsKey(temp)){
				if(hPacks.get(temp)>1)
					hPacks.put(temp, 1);
			}
			else
				hPacks.put(temp,1);
		}
		int b = scan.nextInt();
		int min = 1000000;
		for(int i = 0; i < b; i++){
			int temp = scan.nextInt();
			
			HashMap<Integer,Integer> clone = (HashMap<Integer,Integer>) bPacks.clone();
			for(Integer k : clone.keySet()){
				if(bPacks.containsKey(k+temp)){
					if(clone.get(k+temp)>(clone.get(k)+1))
						bPacks.put(k+temp,bPacks.get(k)+1);
				}
				else
					bPacks.put(k+temp,clone.get(k)+1);
				
				
				if(hPacks.containsKey(k+temp)){
					if(hPacks.get(k+temp)+bPacks.get(k+temp)<min)
						min = hPacks.get(k+temp)+bPacks.get(k+temp);
				}
			}
			if(bPacks.containsKey(temp)){
				if(bPacks.get(temp)>1)
					bPacks.put(temp, 1);
			}
			else
				bPacks.put(temp,1);
			if(hPacks.containsKey(temp))
				if(hPacks.get(temp)+bPacks.get(temp)<min)
					min = hPacks.get(temp)+bPacks.get(temp);
		}
//		System.out.println(hPacks.toString());
//		System.out.println(bPacks.toString());
//		if(h == 0 && b == 0){
//			System.out.println("0");
//			return;
//		}
		if(min==1000000)
			System.out.println("impossible");
		else
			System.out.println(min);
	}
	
	public static void main(String[] args){
		NinePacks app = new NinePacks();
	}
}
