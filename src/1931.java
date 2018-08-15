import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] con;
	static int count = 0;
	static int end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		con = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++)
				con[i][j] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(con, new Comparator<int[]>() {

			@Override
			public int compare(int[] up, int[] low) {
				// TODO Auto-generated method stub
				if (up[1] == low[1]) { // 종료 시간이 같을 때 
					return up[0] - low[0]; // 시작 시간으로 정렬 
				} else { // 종료 시간이 다를 때 
					return up[1] - low[1]; // 종료 시간으로 정렬 
				}
			}
		});

		end = con[0][1];
		count++;
		for (int i = 1; i < N; i++) {
			if (con[i][0] >= end) {
				end = con[i][1];
				count++;
			}
		}

		System.out.println(count);
	}
}