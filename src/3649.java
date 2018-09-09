import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static double X;
	static int N;
	static double ans = 0;
	static double ans1, ans2;
	static double[] L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		boolean check = false;

		while (true) {
			st = new StringTokenizer(br.readLine());
			if (!st.hasMoreTokens())
				break;
			X = Double.parseDouble(st.nextToken());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if (N <= 1) {
				System.out.println("danger");
			} else {
				ans = 0;
				L = new double[N];
				X *= 10000000;

				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					L[i] = Double.parseDouble(st.nextToken());
				}

				double xx;
				for (int i = 0; i < N; i++) {
					xx = X;
					xx -= L[i];
					for (int j = 0; j < N; j++) {
						if (i != j) {
							xx -= L[j];
							if (xx == 0) {
								check = true;
								double tmp = Math.abs(L[i] - L[j]);
								if (tmp >= ans) {
									ans = tmp;
									if (L[i] < L[j]) {
										ans1 = L[i];
										ans2 = L[j];
									} else {
										ans1 = L[j];
										ans2 = L[i];
									}
								}
							}
							xx += L[j];
						}
					}
				}

				if (check) {
					System.out.print("yes " + (int) ans1 + " ");
					System.out.println((int) ans2);
				} else {
					System.out.println("danger");
				}
			}
		}
	}
}