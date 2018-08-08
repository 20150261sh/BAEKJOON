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
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int xx, yy;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int count = 0;

	static void bfs(int n1, int n2) {
		visit[n1][n2] = true;
		q.add(n1);
		q.add(n2);
		count++;
		while (!q.isEmpty()) {
			boolean check = false;
			if (n1 == N - 1 && n2 == M - 1)
				break;
			n1 = q.remove();
			n2 = q.remove();
			for (int i = 0; i < 4; i++) {
				xx = n1 + dx[i];
				yy = n2 + dy[i];
				if (xx < 0 || yy < 0 || N <= xx || M <= yy)
					continue;
				else {
					if (!visit[xx][yy] && mat[xx][yy] == 1) {
						visit[xx][yy] = true;
						q.add(xx);
						q.add(yy);
						count++;
						check = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			String[] spt = tmp.split("");
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(spt[j]);
			}
		}
		bfs(0, 0);
		System.out.println(count);
		// for(int i = 0; i < N; i++) {
		// for(int j = 0; j < M; j++)
		// System.out.print(mat[i][j] + " ");
		// System.out.println();
	}
}
