import java.util.ArrayList;
import java.util.Scanner;

public class CircuitCounting {
	private int n;
	private int numCircuits = 0;
	private int numPairs = 0;
	private int numTriples = 0;
	private ArrayList<Vector> vectors = new ArrayList<Vector>();
	private ArrayList<ArrayList<Vector>> triples = new ArrayList<ArrayList<Vector>>();
	private ArrayList<ArrayList<Vector>> doubles = new ArrayList<ArrayList<Vector>>();

	public CircuitCounting(){
		getVals();
		getPairs();
		getTriples();
		numCircuits = numPairs + numTriples + ((2^numPairs)-1)*(numTriples);
		System.out.println(numCircuits);
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		n = Integer.parseInt(scan.nextLine());
		for(int i = 0; i < n; i++){
			String temp = scan.nextLine();
			String[] array = temp.split(" ");
			vectors.add(new Vector(Integer.parseInt(array[0]),Integer.parseInt(array[1])));
		}
	}
	
	public void getPairs(){
		for(int i = 0; i < vectors.size(); i++){
			for(int j = i+1; j < vectors.size(); j++){
				Vector added = addVectors(vectors.get(i), vectors.get(j));
				if(added.x == 0 && added.y == 0){
					ArrayList<Vector> temp = new ArrayList<Vector>();
					temp.add(vectors.get(i));
					temp.add(vectors.get(j));
					doubles.add(temp);
				}
			}
		}
	}
	public void getTriples(){
		for(int i =0; i < vectors.size(); i++){
			for(int j = i+1; j< vectors.size(); j++){
				for(int k = j+1; k < vectors.size(); k++){
					Vector added = addVectors(vectors.get(i), vectors.get(j), vectors.get(k));
					if(added.x == 0 && added.y == 0){
						ArrayList<Vector> temp = new ArrayList<Vector>();
						temp.add(vectors.get(i));
						temp.add(vectors.get(j));
						temp.add(vectors.get(k));
						doubles.add(temp);
					}
				}
			}
		}
	}
	public void getValidTriples(ArrayList<ArrayList<Vector>> pair){
		
		for(ArrayList<Vector> trip: triples)
		{
			trip.contains(pair.get(0));
		}
		
	}
	public boolean checkSame(ArrayList<Vector> array1, ArrayList<Vector> array2){
		for(Vector v: array1){
			if(array2.contains(v))
				return true;
		}
		return false;
	}
	
	
	public int permutate(int c, int r){
		int temp;
		temp = (factorial(c)/(factorial(c-r)*factorial(r)));
		return temp;
	}
	
	
	public int factorial(int x){
		int temp = 1;
		
		for(int i = 1; i <=x;i++){
			temp*=i;
		}
		
		return temp;
	}
	public Vector addVectors(Vector v1, Vector v2){
		return new Vector(v1.x+v2.x,v1.y+v2.y);
	}
	public Vector addVectors(Vector v1, Vector v2, Vector v3){
		return new Vector(v1.x+v2.x+v3.x,v1.y+v2.y+v3.y);
	}
	class Vector{
		int x;
		int y;
		
		public Vector(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args){
		CircuitCounting app = new CircuitCounting();
	}
}
