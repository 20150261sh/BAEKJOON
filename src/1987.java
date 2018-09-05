import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static boolean[] visit = new boolean[91];
	static int count = 1;
	static int max = 1;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void dfs(int x, int y) {
		int idx = map[x][y];
		visit[idx] = true;

		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || xx >= R || yy < 0 || yy >= C)
				continue;

			if (!visit[map[xx][yy]]) {
				count++;
				if (max <= count)
					max = count;
				dfs(xx, yy);
			}
		}

		visit[idx] = false;
		count--;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), "");
			String tmp = st.nextToken();
			for (int j = 0; j < C; j++)
				map[i][j] = tmp.charAt(j);
		}
		
		dfs(0, 0);
		System.out.println(max);
	}
}
