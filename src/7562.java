import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class night_7562 {
	static int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int N;
	static int I;
	static int x1, y1, x2, y2;
	static int[][] mat;
	static boolean[][] visit = new boolean[301][301];
	static Queue<Integer> q;

	static void bfs() {
		visit[x1][y1] = true;

		while (!q.isEmpty()) {
			int nx = q.poll();
			int ny = q.poll();

			if (nx == x2 && ny == y2)
				break;

			for (int i = 0; i < 8; i++) {
				int xx = nx + dx[i];
				int yy = ny + dy[i];

				if (xx < 0 || xx >= I || yy < 0 || yy >= I)
					continue;

				if (!visit[xx][yy]) {
					visit[xx][yy] = true;

					q.add(xx);
					q.add(yy);

					mat[xx][yy] = mat[nx][ny] + 1;
					x1 = xx;
					y1 = yy;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			I = Integer.parseInt(st.nextToken());
			mat = new int[I][I];
			for (int j = 0; j < 301; j++)
				for (int k = 0; k < 301; k++)
					visit[j][k] = false;

			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			q.add(x1);
			q.add(y1);

			bfs();
			System.out.println(mat[x2][y2]);
		}
	}

}
