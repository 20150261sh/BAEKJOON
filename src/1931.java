import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] con;
	static int count = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int end;
	static int[] tmpArr;

	public static void main(String[] args) throws IOException {
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
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				return arg0[1] - arg1[1];
			}
		});

		int j;
		for (int i = 0; i < N - 1; i++) {
			if (con[i][1] == con[i + 1][1]) {
				int tmp = con[i][1];
				for (j = i + 1; j < N; j++) {
					if (con[j][1] != tmp)
						break;
				}
				tmpArr = new int[j - i];
				int idx = 0;
				for (int k = i; k < j; k++) {
					tmpArr[idx++] = con[k][0];
				}
				Arrays.sort(tmpArr);
				idx = 0;
				for (int k = i; k < j; k++) {
					con[k][0] = tmpArr[idx++];
				}
			}
		}

		end = con[0][1];
		count++;
		for (int i = 0; i < N; i++) {
			if (con[i][0] >= end) {
				count++;
				end = con[i][1];
			}
		}

		System.out.println(count);
	}
}