import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int T;
	static int N;
	static int[][] apply;
	static int count = 1;
	static int min = 0;

	static void cruit() {
		Arrays.sort(apply, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] > o2[0])
					return 1;
				else if (o1[0] < o2[0])
					return -1;
				else
					return 0;
			}
		});

		min = apply[0][1];		
		for(int i = 1; i < N; i++) {
			if(min > apply[i][1]) {
				count++;
				min = apply[i][1];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		while (T > 0) {
			T--;
			count = 1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			apply = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 2; j++) {
					apply[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			cruit();
			System.out.println(count);
		}
	}
}