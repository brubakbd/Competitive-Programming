import java.util.Scanner;

public class Robotopia {
	public Robotopia(){
		getVals();
	}
	
	public void getVals(){
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0; i<num; i++){
			int a1 = scan.nextInt();
			int l1 = scan.nextInt();
			int a2 = scan.nextInt();
			int l2 = scan.nextInt();
			int at = scan.nextInt();
			int lt = scan.nextInt();
			boolean found1 = false;
			int[] foundSet = {0,0};
			for(int j = 1; j<=10000;j++){
				if(j*a1>=at){
					if(found1){
						System.out.println(foundSet[0] + " " + foundSet[1]);
						break;
					}
					else{
						System.out.println("?");
						break;
					}
				}
				if((at-j*a1)%a2==0){
					if((j*l1+((at-j*a1)/a2)*l2==lt)){
						if(found1){
							System.out.println("?");
							break;
						}
						else{
							found1 = true;
							foundSet[0] = j;
							foundSet[1] = (at-(j*a1))/a2;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		Robotopia app = new Robotopia();
	}
}

