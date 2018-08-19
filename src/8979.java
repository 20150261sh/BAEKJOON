import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int rank = 0;
	static int[][] info;
	static String star = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		info = new int[N][4];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(info, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			if (i + 1 != K) {
				for (int j = 1; j < 4; j++) {
					if (info[K - 1][j] > info[i][j])
						break;
					else if (info[K - 1][j] == info[i][j])
						continue;
					else {
						rank++;
						break;
					}
				}
			}
		}
		
		System.out.println(rank + 1);
	}
}