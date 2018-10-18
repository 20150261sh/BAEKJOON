import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cleanrobot_14503 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[][] mat = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean check = true;
		int clean = 0;

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };

		while (true) {
			
			if (mat[r][c] == 0) {
				mat[r][c] = 3;
				clean++;
			}
			
			check = false;
			int cleanCount = 0;
			int wallCount = 0;
			int cnt = 0;

			for (int i = 0; i < 4; i++) {
				int xx = r + dx[i];
				int yy = c + dy[i];
				if (xx < 0 || xx >= N || yy < 0 || yy >= M)
					continue;
				cnt++;
				if (mat[xx][yy] == 1) // 벽인 경우
					wallCount++;
				else if (mat[xx][yy] == 3) // 이미 청소한 경우
					cleanCount++;
			}

			if (cleanCount + wallCount == cnt) {
				if (d == 0) {
					if (0 <= r + 1 && r + 1 < N) {
						if (mat[r + 1][c] == 1)
							break;
						else
							r++;
					}
				} else if (d == 1) {
					if (0 <= c - 1 && c - 1 < M) {
						if (mat[r][c - 1] == 1)
							break;
						else
							c--;
					}
				} else if (d == 2) {
					if (0 <= r - 1 && r - 1 < N) {
						if (mat[r - 1][c] == 1)
							break;
						else
							r--;
					}
				} else {
					if (0 <= c + 1 && c + 1 < M) {
						if (mat[r][c + 1] == 1)
							break;
						else
							c++;
					}
				}
				continue;
			}

			// 왼쪽부터 탐색
			if (d == 0) {
				if (0 <= c - 1 && c - 1 < M) {
					d = 3;
					if (mat[r][c - 1] == 0) { // 왼쪽에 청소할 공간이 존재할 때
						c--; // 전진
						check = true;
					}
				}
			} else if (d == 1) {
				if (0 <= r - 1 && r - 1 < N) {
					d = 0;
					if (mat[r - 1][c] == 0) {
						r--;
						check = true;
					}
				}
			} else if (d == 2) {
				if (0 <= c + 1 && c + 1 < M) {
					d = 1;
					if (mat[r][c + 1] == 0) {
						c++;
						check = true;
					}
				}
			} else {
				if (0 <= r + 1 && r + 1 < N) {
					d = 2;
					if (mat[r + 1][c] == 0) {
						r++;
						check = true;
					}
				}
			}
		}

		System.out.println(clean);
	}

}
