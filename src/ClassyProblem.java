import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClassyProblem {
	class pairComp implements Comparator<Pair>{

		@Override
		public int compare(Pair o1, Pair o2) {
			for(int i = 0; i < 10;i++){
				if(o1.classes[i]<o2.classes[i])
					return -1;
				else if(o1.classes[i]>o2.classes[i])
					return 1;
			}
			return o1.name.compareTo(o2.name);
		}
		
	}
	class Pair{
		String name;
		int[] classes;
		public Pair(String n, int[] c){
			name = n;
			classes = c;
		}
	}
	public ClassyProblem(){
		getVals();
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int numTests = scan.nextInt();
		for(int i = 0; i < numTests; i++){
			int numPeople = scan.nextInt();
			List<Pair> people = new ArrayList<Pair>();
			for(int j = 0; j < numPeople; j++){
				String temp = scan.next();
				String name = temp.substring(0, temp.length()-1);
				String[] c = scan.next().split("-");
				scan.next();
				int len = c.length-1;
				int[] cls = new int[10];
				for(int k = 0; k < 10;k++){
					if(k<=len){
						if(c[k].equals("upper"))
							cls[9-k]=1;
						else if(c[k].equals("middle"))
							cls[9-k]=2;
						else
							cls[9-k]=3;
					}
					else{
						cls[9-k]=2;
					}
					
				}
				people.add(new Pair(name, cls));
			}
			Collections.sort(people,new pairComp()); 
			for(Pair p:people){
				System.out.println(p.name);
			}
			System.out.println("==============================");
		}
	}
	public static void main(String[] args) throws Exception{
		ClassyProblem app = new ClassyProblem();
	}
}
