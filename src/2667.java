import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int sum = 1;
	static int area = 0;
	static int idx = 0;
	static int[] res = new int[500];

	static void dfs(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || xx >= N || yy < 0 || yy >= N || visit[xx][yy] || map[xx][yy] == 0)
				continue;
			dfs(xx, yy);
			sum++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			String[] spt = tmp.split("");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(spt[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					dfs(i, j);
					area++;
					res[idx++] = sum;
					sum = 1;
				}
			}
		}

		System.out.println(area);
		Arrays.sort(res);
		for (int i = 500 - area; i < res.length; i++)
			System.out.println(res[i]);
	}
}
