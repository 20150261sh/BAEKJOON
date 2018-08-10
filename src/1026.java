import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static Integer[] A;
	static Integer[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		A = new Integer[N];
		B = new Integer[N];
		int idx = 2;

		while (idx > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			if (idx == 2) {
				for (int i = 0; i < N; i++) {
					A[i] = Integer.parseInt(st.nextToken());
				}
			} else {
				for (int i = 0; i < N; i++) {
					B[i] = Integer.parseInt(st.nextToken());
				}
			}
			idx--;
		}
		
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += A[i] * B[i];
		}
		
		System.out.println(ans);
	}
}