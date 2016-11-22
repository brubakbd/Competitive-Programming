import java.io.File;
import java.util.Scanner;

public class Bases {
	private int n;
	private String currentExp;
	private int minBase;
	private int maxBase = 36;
	private String[] nums = new String[3];
	private char op;
	private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private final String SALPHABET = "123456789abcdefghijklmnopqrstuvwxyz0";

	public Bases() {
		getVals();
	}

	public void getVals() {
		Scanner scan = new Scanner(System.in);
		n = Integer.parseInt(scan.nextLine());

		for (int j = 0; j < n; j++) {
			currentExp = scan.nextLine().toLowerCase();
			String[] array = currentExp.split(" ");
			nums[0] = array[0];
			nums[1] = array[2];
			nums[2] = array[4];
			op = array[1].charAt(0);
			String answer = "";
			getMinBase();
			for (int i = minBase; i <= maxBase; i++) {
				double temp = 0;
				switch (op) {
				case '+':
					temp = changeBase(i, nums[0]) + changeBase(i, nums[1]);
					break;
				case '-':
					temp = changeBase(i, nums[0]) - changeBase(i, nums[1]);
					break;
				case '/':
					temp = changeBase(i, nums[0]) / changeBase(i, nums[1]);
					break;
				case '*':
					temp = changeBase(i, nums[0]) * changeBase(i, nums[1]);
					break;

				}
				if (temp == changeBase(i, nums[2])) {
					answer += SALPHABET.charAt(i - 1);
				}
			}
			if (answer.isEmpty()) {
				answer = "invalid";
			}
			System.out.println(answer);
		}

		scan.close();

	}

	public void getMinBase() {
		char[] characters = currentExp.toCharArray();
		int highestVal = 0;
		for (char c : characters) {
			if (Character.isAlphabetic(c)) {
				if ((int) c - 'a' + 10 > highestVal)
					highestVal = (int) c - 'a' + 10;
			} else if (Character.isDigit(c)) {
				if (c - 48 > highestVal) {
					highestVal = c - 48;
				}
			}
		}
		minBase = highestVal;
		if (highestVal != 1) {
			minBase = minBase + 1;
		}
	}

	public double changeBase(int baseFrom, String num) {
		double baseTen = 0;
		for (int i = 0; i < num.length(); i++) {
			double val = 0;
			if (Character.isAlphabetic(num.charAt(i))) {
				val = ALPHABET.indexOf(num.charAt(i)) + 10;
			} else {
				val = Integer.parseInt(num.charAt(i) + "");
			}
			baseTen += val * Math.pow(baseFrom, num.length() - (i + 1));
		}
		return baseTen;
	}

	public static void main(String[] args) {
		Bases app = new Bases();
	}
}
