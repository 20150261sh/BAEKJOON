import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] mat = new int[1000][1000];
	static boolean[] visit = new boolean[1000];
	static int N, M, V;
	static int u, v;
	static Queue<Integer> q = new LinkedList<Integer>();

	static void dfs(int start) {
		visit[start] = true;
		System.out.print(start + 1 + " ");
		for (int i = 0; i < N; i++) {
			if (!visit[i] && mat[start][i] == 1) {
				visit[i] = true;
				dfs(i);
			}
		}
	}

	static void bfs(int start) {
		visit[start] = true;
		q.add(start);
		while (!q.isEmpty()) {
			int tmp = q.peek();
			for (int i = 0; i < N; i++) {
				if (!visit[i] && mat[tmp][i] == 1) {
					visit[i] = true;
					q.add(i);
				}
			}
			System.out.print(q.poll() + 1 + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			mat[u - 1][v - 1] = 1;
			mat[v - 1][u - 1] = 1;
		}

		dfs(V - 1);
		System.out.println();
		for (int i = 0; i < N; i++)
			visit[i] = false;
		bfs(V - 1);
		System.out.println();
	}
}