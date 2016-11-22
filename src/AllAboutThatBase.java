import java.util.Scanner;

public class AllAboutThatBase {
	String alphabet = "123456789abcdefghijklmnopqrstuvwxyz0";
	String alphabet2 = "0123456789abcdefghijklmnopqrstuvwxyz";
	public String getVals(){
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < n ; i++){
			String temp = scan.nextLine();
			char max = temp.charAt(0);
			for(int j = 0; j<temp.length();j++){
				if ((temp.charAt(j)>max) && (temp.charAt(j)!='='))
					max = temp.charAt(j);
			}
			String[] arr = temp.split(" ");
			int minBase = Integer.parseInt(""+max,36)+1;
			if(minBase==2 && temp.indexOf('0')==-1)
				minBase=1;
			for (int j = minBase; j <= 36; j++){
				if(doMath(arr[0],arr[1],arr[2],arr[4],j)){
					output.append(alphabet.charAt(j-1));
				}
			}
			if(output.length() == 0 || output.charAt(output.length()-1)=='\n')
				output.append("invalid");
			output.append('\n');
		}
		scan.close();
		
		return output.toString();
	}
	public boolean doMath(String arg1, String op, String arg2, String arg3,int base){
		if(base==1){
			switch(op){
			case "+":
				return arg1.length() + arg2.length() == arg3.length();
			case "-":
				return arg1.length() - arg2.length() == arg3.length();
			case "*":
				return arg1.length() * arg2.length() == arg3.length();
			case "/":
				return arg1.length() / arg2.length() == arg3.length();
		};
		System.out.println(base);
		}
		switch(op){ 
			case "+":
				return (conversion(arg1,base)+conversion(arg2,base)==conversion(arg3,base));
			case "-":
				return (conversion(arg1,base)-conversion(arg2,base)==conversion(arg3,base));
			case "*":
				return (conversion(arg1,base)*conversion(arg2,base)==conversion(arg3,base));
			case "/":
				return ((double)conversion(arg1,base)/(double)conversion(arg2,base)==(double)conversion(arg3,base));
		};
		return false;
	}
	
	public Long conversion(String num, int base){
		int len = num.length();
		long result = 0;
		for(int i = len-1; i>=0;i--){
			result += alphabet2.indexOf(num.charAt(i))*Math.pow(base, len-i-1);
		}
		return result;
	}
	public static void main(String[] args){
		AllAboutThatBase app = new AllAboutThatBase();
		System.out.println(app.getVals());
//		System.out.println(Integer.parseInt("a",9));
	}
}
