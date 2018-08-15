import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int P;
	static int[] rank;
	static int score;
	static int min = 2000000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		score = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		rank = new int[P];
		for (int i = 0; i < P; i++) {
			rank[i] = -1;
		}

		if (N > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				rank[i] = Integer.parseInt(st.nextToken());
				if (rank[i] < min)
					min = rank[i];
			}
		} else
			min = -1;

		boolean small = false;
		for (int i = 0; i < N; i++) {
			if (rank[i] >= score)
				small = true;
			else 
				small = false;
		}

		if (N == P && small)
			System.out.println("-1");
		else {
			for (int i = 0; i < P; i++) {
				if (score >= rank[i]) {
					System.out.println(i + 1);
					return;
				}
			}
		}

	}
}