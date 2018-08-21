import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int T;
	static int M, N, K;
	static int x1, y1, x2, y2;
	static int[][] map;
	static boolean[][] visit;
	static int k = 0;
	static int area = 0;
	static int sum = 1;
	static int[] arr = new int[1000];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void dfs(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || xx >= M || yy < 0 || yy >= N || visit[xx][yy] || map[xx][yy] == 0)
				continue;
			sum++;
			dfs(xx, yy);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		String[] spl = tmp.split(" ");

		M = Integer.parseInt(spl[0]);
		N = Integer.parseInt(spl[1]);
		K = Integer.parseInt(spl[2]);
		map = new int[M][N];
		visit = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 1;
			}
		}

		int T = K;
		while (T > 0) {
			T--;
			tmp = br.readLine();
			spl = tmp.split(" ");
			y1 = Integer.parseInt(spl[0]);
			x1 = Integer.parseInt(spl[1]);
			y2 = Integer.parseInt(spl[2]);
			x2 = Integer.parseInt(spl[3]);
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++)
					map[M - i - 1][j] = 0;
			}

		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					dfs(i, j);
					area++;
					arr[k++] = sum;
					sum = 1;
				}
			}
		}

		System.out.println(area);
		Arrays.sort(arr);
		for (int i = 1000 - area; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
