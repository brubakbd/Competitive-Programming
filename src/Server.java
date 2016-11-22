import java.util.Scanner;

public class Server {
	int numTasks;
	int maxTime;
	
	public void getData(){
		Scanner scan = new Scanner(System.in);
		numTasks = scan.nextInt();
		maxTime = scan.nextInt();
		int totalTime = 0;
		int i;
		for(i = 0; i < numTasks; i++){
			int temp = scan.nextInt();
			if(!(totalTime + temp > maxTime))
				totalTime += temp;
			else
				break;
		}
		System.out.println(i+"");
	}
	public Server(){
		getData();
	}
	public static void main(String[] args){
		Server app = new Server();
	}
}
