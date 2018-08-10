import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int score = 0;
	static int[] num = new int[5];
	static String[] col = new String[5];
	static int remember4, remember3, remember2;
	static int[] remember_2 = new int[2];

	static boolean isAllColor() {
		int check = 0;
		for (int i = 0; i < 4; i++) {
			if (col[i] == col[i + 1])
				check++;
		}
		if (check >= 4)
			return true;
		else
			return false;
	}

	static boolean isStraight() {
		Arrays.sort(num);
		int check = 0;
		for (int i = 4; i > 0; i--) {
			if (num[i] - num[i - 1] == 1)
				check++;
		}
		if (check >= 4)
			return true;
		else
			return false;
	}

	static boolean isFourNumber() {
		int[] count = new int[9];
		for (int i = 0; i < 9; i++)
			count[i] = 0;
		for (int i = 0; i < 5; i++) {
			int tmp = num[i];
			count[tmp - 1]++;
		}
		for (int i = 0; i < 9; i++) {
			if (count[i] >= 4) {
				remember4 = i + 1;
				return true;
			}
		}
		return false;
	}

	static boolean isTwoNumber() {
		int[] count = new int[9];
		for (int i = 0; i < 9; i++)
			count[i] = 0;
		for (int i = 0; i < 5; i++) {
			int tmp = num[i];
			count[tmp - 1]++;
		}
		for (int i = 0; i < 9; i++) {
			if (count[i] == 2) {
				remember2 = i + 1;
				return true;
			}
		}
		return false;
	}

	static int isTwo2Number() {
		int[] count = new int[9];
		for (int i = 0; i < 9; i++)
			count[i] = 0;
		for (int i = 0; i < 5; i++) {
			int tmp = num[i];
			count[tmp - 1]++;
		}
		int k = 0;
		int check = 0;
		for (int i = 0; i < 9; i++) {
			if (count[i] == 2) {
				remember_2[k] = i + 1;
				k++;
				check++;
			}
		}
		return check;
	}

	static boolean isThreeNumber() {
		int[] count = new int[9];
		for (int i = 0; i < 9; i++)
			count[i] = 0;
		for (int i = 0; i < 5; i++) {
			int tmp = num[i];
			count[tmp - 1]++;
		}
		for (int i = 0; i < 9; i++) {
			if (count[i] == 3) {
				remember3 = i + 1;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String total = "";
		for (int i = 0; i < 5; i++) {
			total = br.readLine();
			String[] tmp = total.split(" ");
			col[i] = tmp[0];
			num[i] = Integer.parseInt(tmp[1]);
		}

		if (isAllColor() && isStraight()) {
			score += num[4] + 900;
		} else if (isFourNumber()) {
			score += remember4 + 800;
		} else if (isThreeNumber() && isTwoNumber()) {
			score += remember3 * 10 + remember2 + 700;
		} else if (isAllColor()) {
			Arrays.sort(num);
			score += num[4] + 600;
		} else if (isStraight()) {
			Arrays.sort(num);
			score += num[4] + 500;
		} else if (isThreeNumber()) {
			score += remember3 + 400;
		} else if (isTwo2Number() == 2) {
			Arrays.sort(remember_2);
			score += remember_2[1] * 10 + remember_2[0] + 300;
		} else if (isTwoNumber()) {
			score += remember2 + 200;
		} else {
			Arrays.sort(num);
			score += num[4] + 100;
		}
		System.out.println(score);
	}
}
