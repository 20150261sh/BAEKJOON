import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static boolean check = false;
	static double X;
	static int N;
	static int mid;
	static double[] L;

	static void robot(int l, int r, double find) {
		if (l > r)
			return;
		mid = (l + r) / 2;
		if (find > L[mid])
			robot(mid + 1, r, find);
		else if (find < L[mid])
			robot(l, mid - 1, find);
		else {
			check = true;
			return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			check = false;

			st = new StringTokenizer(br.readLine());
			if (!st.hasMoreTokens())
				break;

			X = Double.parseDouble(st.nextToken());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			L = new double[N];
			X *= 10000000;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				L[i] = Double.parseDouble(st.nextToken());
			}
			Arrays.sort(L);
			
			if (N > 1) {
				int i;
				for (i = 0; i < N; i++) {
					robot(0, N - 1, X - L[i]);
					if (check)
						break;
				}
				if (check)
					System.out.println("yes " + (int)L[i] + " " + (int)L[mid]);
				else
					System.out.println("danger");
			} else
				System.out.println("danger");
		}
	}
}