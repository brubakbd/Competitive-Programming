import java.util.Scanner;

public class TicketPrices {

	int seatsLeft;
	int weeksLeft;

	public void getPrices() {
		Scanner scan = new Scanner(System.in);
		seatsLeft = scan.nextInt();
		weeksLeft = scan.nextInt();
		int firstWeekPrice = 0;
		int maxRev = 0;
		for (int i = weeksLeft; i >= 0; i--) {
			int araSize = scan.nextInt();
			int[] weekPrices = new int[araSize * 2];
			for (int k = 0; k < weekPrices.length; k++) {
				weekPrices[k] = scan.nextInt();
			}
			
			int maxWeekRev = 0;
			int weekPrice=0;
			int weekSold=0;
			for(int j = 0; j<araSize;j++){
				weekPrice = weekPrices[j];
				weekSold = weekPrices[j+araSize];
				
				if(seatsLeft >= weekSold){
					if(weekPrice*weekSold>maxWeekRev){
						maxWeekRev = weekPrice*weekSold;
						if(i==weeksLeft)
							firstWeekPrice = weekPrice;
					}
				}
				else{
					weekSold = seatsLeft;
					if(weekPrice*weekSold>maxWeekRev){
						maxWeekRev = weekPrice*weekSold;
						if(i==weeksLeft)
							firstWeekPrice = weekPrice;
					}
				}
			}
			seatsLeft-=weekSold;
			maxRev+=maxWeekRev;
		}

		System.out.println(maxRev);
		System.out.println(firstWeekPrice);
	}

	public TicketPrices() {
		getPrices();
	}

	public static void main(String[] args) {
		TicketPrices tp = new TicketPrices();

	}

}
