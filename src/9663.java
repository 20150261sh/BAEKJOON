import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int cnt = 0;
	static int[] col;
	static int[] dx = { -1, -1 };
	static int[] dy = { -1, 1 };

	static boolean promising(int r) {
		for (int i = 0; i < r; i++) {
			if (col[i] == col[r])
				return false;
			if (Math.abs(col[i] - col[r]) == Math.abs(i - r))
				return false;

		}
		return true;
	}

	static void back(int r) {
		if (r == N) {
			cnt++;
		} else {
			for (int i = 0; i < N; i++) {
				col[r] = i;
				if (promising(r))
					back(r + 1);
				else
					col[r] = -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N];
		for (int i = 0; i < N; i++)
			col[i] = -1;
		
	}
}
