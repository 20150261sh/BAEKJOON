import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static String N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = st.nextToken();
		String[] spt = N.split("");

		int[] arr = new int[spt.length];
		for (int i = 0; i < spt.length; i++)
			arr[i] = Integer.parseInt(spt[i]);
		
		Arrays.sort(arr);
		for(int i = arr.length - 1; i > -1; i--)
			System.out.print(arr[i]);
	}
}