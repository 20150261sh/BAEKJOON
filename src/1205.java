import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int P;
	static int[][] rank;
	static int score;
	static int min = 2000000001;

	static int ranking() {
		if (N == P) {
			if (score <= min)
				return -1;
		}
		int i;
		for (i = 0; i < N; i++) {
			if (rank[i][0] <= score)
				return rank[i][1];
		}
		return rank[i - 1][1] + 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		score = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		//		if (10 > P || P > 50)
//			return;
//		if (0 > N || N > P)
//			return;
//		if (score > 2000000000)
//			return;

		rank = new int[P][2];
		for (int i = 0; i < P; i++) {
			for (int j = 0; j < 2; j++)
				rank[i][j] = -1;
		}

		if(N > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				rank[i][0] = Integer.parseInt(st.nextToken());
				if (rank[i][0] < min)
					min = rank[i][0];
			}

			rank[0][1] = 1;
			for (int i = 1; i < N; i++) {
				if (rank[i - 1][0] == rank[i][0])
					rank[i][1] = rank[i - 1][1];
				else
					rank[i][1] = i + 1;
			}

			System.out.println(ranking());
		}
		else 
			System.out.println(1);
	}
}