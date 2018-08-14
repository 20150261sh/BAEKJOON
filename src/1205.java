import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int P;
	static int[] rank;
	static int[] pri;
	static int score;
	static int max;

	static int ranking() {
		if (N == P) {
			for (int i = 0; i < N; i++) {
				if (pri[i] != -1 && score >= pri[i])
					return i + 1;
			}
			return -1;
		} else {
//			for (int k = 0; k < N; k++)
//				System.out.println(pri[k]);
			int i;
			for (i = 0; i < N; i++) {
				if (pri[i] != -1 && score >= pri[i])
					return i + 1;
//				System.out.println("i is" + i);
			}
			return i + 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		score = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		rank = new int[P];
		pri = new int[N];
		for(int i = 0; i < P; i++)
			rank[i] = -1;
		for(int i = 0; i < N; i++) 
			pri[i] = -1;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			rank[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < P - 1; i++) {
			if (rank[i] != rank[i + 1])
				pri[i] = rank[i];
			else if (rank[i] == rank[i + 1]) {
				pri[i] = rank[i];
				pri[i + 1] = -1;
				i++;
			}
		}
//		max = rank[0];
		System.out.println(ranking());
	}
}