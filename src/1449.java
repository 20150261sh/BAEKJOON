import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int L;
	static int[] sink;
	static int count = 0;
	static int taping = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		sink = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			sink[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sink);

		for (int i = 0; i < N; i++) {
			if (sink[i] > taping) {
				taping = sink[i] + L;
				count++;
			}
		}

		System.out.println(count);
	}
}