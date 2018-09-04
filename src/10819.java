import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int max = 0;
	static int count = 0;

	static int fac(int n) {
		if (n <= 1)
			return 1;
		else
			return n * fac(n - 1);
	}

	static void swap(int[] arr, int n1, int n2) {
		int tmp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = tmp;
	}

	static int permutation(int[] arr, int N) {
		int n1 = 0, n2 = 0;
		boolean check = false;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				n1 = i - 1;
				n2 = N - 1;
				check = true;
				break;
			}
		}
		if (!check)
			return -1;

		for (int i = n2; i > n1; i--) {
			if (arr[n1] < arr[i]) {
				swap(arr, n1, i);
				n2 = i;
				break;
			}
		}

		if (n2 == N - 1 && n1 + 1 == n2) {
			;
		} else {
			Arrays.sort(arr, n1 + 1, arr.length);
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		for (int j = 0; j < N - 1; j++)
			count += Math.abs(arr[j] - arr[j + 1]);

		for (int i = 0; i < fac(N); i++) {
			if (max < count)
				max = count;
			count = 0;
			
			permutation(arr, N);
			
			for (int j = 0; j < N - 1; j++)
				count += Math.abs(arr[j] - arr[j + 1]);
		}

		System.out.println(max);
	}
}
