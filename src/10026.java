import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static String[][] map;
	static boolean[][] visit1;
	static boolean[][] visit2;
	static int normal = 0;
	static int unnormal = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void changeRtoG() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ("R".equals(map[i][j]))
					map[i][j] = "G";
			}
		}
	}

	static void dfsN(int x, int y, String c) {
		visit1[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || xx >= N || yy < 0 || yy >= N || !c.equals(map[xx][yy]) || visit1[xx][yy])
				continue;
			dfsN(xx, yy, c);
		}
	}
	
	static void dfsU(int x, int y, String c) {
		visit2[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || xx >= N || yy < 0 || yy >= N || !c.equals(map[xx][yy]) || visit2[xx][yy])
				continue;
			dfsU(xx, yy, c);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new String[N][N];
		visit1 = new boolean[N][N];
		visit2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			String[] spt = tmp.split("");

			for (int j = 0; j < N; j++) {
				map[i][j] = spt[j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit1[i][j]) {
					dfsN(i, j, map[i][j]);
					normal++;
				}
			}
		}

		changeRtoG();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit2[i][j]) {
					dfsU(i, j, map[i][j]);
					unnormal++;
				}
			}
		}

		System.out.print(normal + " " + unnormal);
	}
}
