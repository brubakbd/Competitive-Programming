import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AppleManAndToastMan {
	int length;
	long sum = 0;
	long[] array;
	
	public AppleManAndToastMan(){
		getVals();
		Arrays.sort(array);
		sum(array);
	}
	public void sum(long[] array2){
		for(int i=0; i < length-1; i++)
		{
			sum = sum + array2[i]*(i+2);
		}
		sum = sum + array2[length-1]*(length);
	}
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		length = scan.nextInt();
		array = new long[length];
		for(int i = 0; i<length;i++)
		{
			array[i]=scan.nextInt();
		}
		scan.close();
	}
	
	public static void main(String[] args)
	{
		AppleManAndToastMan app = new AppleManAndToastMan();
		System.out.println(app.sum);
	}
}
