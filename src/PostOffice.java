import java.util.Scanner;

public class PostOffice {
	double d,k,a,b,t;

	public PostOffice(){
		this.getVals();
	}
	public void getVals(){
	    Scanner scan = new Scanner(System.in);
	    d = scan.nextDouble();
	    k = scan.nextDouble();
	    a = scan.nextDouble();
	    b = scan.nextDouble();
	    t = scan.nextDouble();
	    scan.close();
	}
	public double run(){
		if(k > d)
			return a*d;
		if(t + k*a < k*b){
	    	if((d % k)*a+t < b*(d % k)){
	    		return (d-(d%k))/k * (t+k*a) + (d%k)*a;
	    	}
	    	return (((d-(d%k))/k)*(t+k*a))-t+b*(d%k);
	    }
		return a*k + b* (d-k);
	}
	public static void main(String[] args){
	    PostOffice app = new PostOffice();
	    System.out.println(app.run());
	}
}
