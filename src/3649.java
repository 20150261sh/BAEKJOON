import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static boolean check = false;
	static int X;
	static int N;
	static int mid;
	static int[] L;
	static int idx;

	static void robot(int l, int r, int find) {
		if (l > r)
			return;
		mid = (l + r) / 2;
		if (idx != mid) {
			if (find > L[mid])
				robot(mid + 1, r, find);
			else if (find < L[mid])
				robot(l, mid - 1, find);
			else {
				check = true;
				return;
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			check = false;

			st = new StringTokenizer(br.readLine());
			if (!st.hasMoreTokens())
				break;

			X = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			L = new int[N];
			X *= 10000000;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				L[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(L);

			if (N > 1) {
				for (idx = 0; idx < N; idx++) {
					robot(0, N - 1, X - L[idx]);
					if (check)
						break;
				}
				if (check)
					System.out.println("yes " + L[idx] + " " + L[mid]);
				else
					System.out.println("danger");
			} else
				System.out.println("danger");
		}
	}
}