import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[] P;
	static int[] res;
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		P = new int[N];
		res = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) 
			P[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(P);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i+1; j++) 
				res[i] += P[j];
		}
		
		for(int i = 0; i < N; i++)
			time += res[i];
		
		System.out.println(time);
	}
}