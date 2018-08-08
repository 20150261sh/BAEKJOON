import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] visit = new int[100001];
	static int N;
	static int K;
	static int time = 0;
	static Queue<Integer> q = new LinkedList<Integer>();

	static void bfs(int start) {
		visit[start] = 0;
		q.add(start);
		while (true) {
			int tmp = q.remove();
			if (tmp == K) {
				time = visit[tmp];
				break;
			}
			int[] dx = { tmp - 1, tmp + 1, tmp * 2 };
			for (int i = 0; i < 3; i++) {
				if (dx[i] >= 0 && dx[i] <= 100000) {
					if (visit[dx[i]] == -1) {
						q.add(dx[i]);
						visit[dx[i]] = visit[tmp] + 1;
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
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 100001; i++)
			visit[i] = -1;
		bfs(N);
		System.out.println(time);
	}
}