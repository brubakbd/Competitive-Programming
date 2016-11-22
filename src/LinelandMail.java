import java.util.Scanner;

public class LinelandMail {
	int length;
	int[] array; //index is i-th, val is position
	
	public LinelandMail(){
		getVals();
		output();
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		length = scan.nextInt();
		array = new int[length];
		for(int i = 0; i < length; i++){
			array[i] = scan.nextInt();
		}
		scan.close();
	}
	public void output(){
		System.out.println((array[1]-array[0])+" "+(array[length-1]-array[0]));
		for(int i = 1; i < length-1; i++){
			System.out.println(Math.min(Math.abs(array[i]-array[i-1]), Math.abs(array[i+1]-array[i]))+" "+Math.max(Math.abs(array[length-1]-array[i]), Math.abs(array[i]-array[0])));
		}
		System.out.println((array[length-1]-array[length-2])+" "+(array[length-1]-array[0]));
	}
	public static void main(String[] args){
		LinelandMail app = new LinelandMail();
	}
}
