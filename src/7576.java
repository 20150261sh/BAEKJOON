import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] mat;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int xx, yy;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int day = 0;

	static void bfs() {
		while (!q.isEmpty()) {
			boolean change = false;
			int size = q.size();
			for (int idx = 0; idx < size / 2; idx++) {
				int x = q.remove();
				int y = q.remove();
				for (int i = 0; i < 4; i++) {
					xx = x + dx[i];
					yy = y + dy[i];
					if (xx < 0 || yy < 0 || N <= xx || M <= yy)
						continue;
					else {
						if (!visit[xx][yy] && mat[xx][yy] == 0) {
							visit[xx][yy] = true;
							mat[xx][yy] = 1;
							q.add(xx);
							q.add(yy);
							change = true;
						}
					}
				}
			}
			if (change)
				day++;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat[i][j] == 0) {
					day = -1;
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean check = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat[i][j] == 0) {
					check = true;
					break;
				}
			}
		}
		if (check) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visit[i][j] && mat[i][j] == 1) {
						visit[i][j] = true;
						q.add(i);
						q.add(j);
					}
				}
			}
			bfs();
		} else
			day = 0;
		System.out.println(day);
	}
}