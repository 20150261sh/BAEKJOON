import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int max = 0;
	static int score = 0;
	static int[] num = new int[5];
	static String[] col = new String[5];
	static int[] check = new int[4];
	static int four, triple, pair, twopair;
	static int[] twopairof = new int[2];

	static int isSameColor() {
		for (int i = 0; i < 4; i++)
			check[i] = 0;

		for (int i = 0; i < 5; i++) {
			if (col[i].equals("R"))
				check[0]++;
			else if (col[i].equals("B"))
				check[1]++;
			else if (col[i].equals("Y"))
				check[2]++;
			else if (col[i].equals("G"))
				check[3]++;
		}

		for (int i = 0; i < 4; i++) {
			if (check[i] >= 5)
				return 1;
		}
		return 0;
	}

	static int isStraight() {
		Arrays.sort(num);
		for (int i = 4; i > 0; i--) {
			if (num[i] - num[i - 1] != 1)
				return 0;
		}
		return 1;
	}

	static int isFourCard() {
		int[] number = new int[9];
		for (int i = 0; i < 5; i++) {
			number[num[i] - 1]++;
		}
		for (int i = 0; i < 9; i++) {
			if (number[i] == 4) {
				four = i + 1;
				return 1;
			}
		}
		return 0;
	}

	static int isTripleCard() {
		int[] number = new int[9];
		for (int i = 0; i < 5; i++) {
			number[num[i] - 1]++;
		}
		for (int i = 0; i < 9; i++) {
			if (number[i] == 3) {
				triple = i + 1;
				return 1;
			}
		}
		return 0;
	}

	static int isPairCard() {
		int[] number = new int[9];
		for (int i = 0; i < 5; i++) {
			number[num[i] - 1]++;
		}
		for (int i = 0; i < 9; i++) {
			if (number[i] == 2) {
				pair = i + 1;
				return 1;
			}
		}
		return 0;
	}

	static int isTwoPairCard() {
		int check = 0;
		int k = 0;
		int[] number = new int[9];
		for (int i = 0; i < 5; i++) {
			number[num[i] - 1]++;
		}
		for (int i = 0; i < 9; i++) {
			if (number[i] == 2) {
				twopairof[k++] = i + 1;
				check++;
			}
		}
		if (check == 2) {
			Arrays.sort(twopairof);
			return 1;
		} else
			return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			col[i] = st.nextToken();
			num[i] = Integer.parseInt(st.nextToken());
			if (num[i] >= max)
				max = num[i];
		}

		if (isSameColor() == 1) {
			if (isStraight() == 1)
				score = max + 900;
			else
				score = max + 600;
		} else if (isFourCard() == 1) {
			score = four + 800;
		} else if (isPairCard() == 1 && isTripleCard() == 1) {
			score = triple * 10 + pair + 700;
		} else if (isStraight() == 1) {
			score = max + 500;
		} else if (isTripleCard() == 1) {
			score = triple + 400;
		} else if (isTwoPairCard() == 1) {
			score = twopairof[1] * 10 + twopairof[0] + 300;
		} else if (isPairCard() == 1) {
			score = pair + 200;
		} else
			score = max + 100;

		System.out.println(score);

	}
}
