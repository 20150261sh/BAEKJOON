import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] res;
	static boolean[][] visit;
	static int start, end;

	static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < N; i++) {
			if (map[y][i] == 1) {
				res[start][i] = 1;
				if (!visit[y][i])
					dfs(y, i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		res = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				res[i][j] = map[i][j];
			}
		}
		int i, j;
		for (i = 0; i < N; i++) {
			start = i;
			for (j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == 1)
					dfs(i, j);
			}
		}

		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}
}
