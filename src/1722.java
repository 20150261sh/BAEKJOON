
import java.util.Scanner;
import java.util.Arrays;

public class Main {

	static void swap(int[] arr, int n1, int n2) {
		int tmp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = tmp;
	}

	static void reverseSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					swap(arr, i, j);
				} else {
					break;
				}
			}
		}
	}

	static void prevPermu(int[] arr, int N) {
		int n1 = 0, n2 = 0;
		boolean check = false;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				n1 = i - 1;
				n2 = N - 1;
				check = true;
				break;
			}
		}
		if (!check)
			System.out.println("-1");
		else {
			for (int i = n2; i > 0; i--) {
				if (arr[n1] > arr[i]) {
					swap(arr, n1, i);
					n2 = i;
					break;
				}
			}

			if (n1 + 1 == N - 1) {
			} else {
				int[] tmp = new int[N - n1 - 1];
				int idx = n1 + 1;
				for (int i = 0; i < tmp.length; i++) {
					tmp[i] = arr[idx++];
				}
				reverseSort(tmp);
				idx = 0;
				for (int i = n1 + 1; i < N; i++)
					arr[i] = tmp[idx++];
			}
		}
	}

	static void nextPermu(int[] arr, int N) {
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
			System.out.println("-1");
		else {
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
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int pNum = scan.nextInt();
		int[] arr = new int[N];
		if (pNum == 1) {
			for (int i = 0; i < arr.length; i++)
				arr[i] = i + 1;
			int k = scan.nextInt();
			int end = 1;
			for (int i = N; i > 0; i--)
				end *= i;
			int mid = end / 2;
			if (1 <= k && k <= mid) {
				int count = 1;
				while (count < k) {
					nextPermu(arr, N);
					count++;
				}
			} else {
				int tmp = N;
				for (int i = 0; i < arr.length; i++)
					arr[i] = (tmp--);
				int count = end;
				while (count > k) {
					prevPermu(arr, N);
					count--;
				}
			}
			for (int j = 0; j < arr.length; j++)
				System.out.print(arr[j] + " ");
			System.out.println();
		} else if (pNum == 2) {
			int[] compare = new int[N];
			for (int i = 0; i < arr.length; i++)
				arr[i] = scan.nextInt();
			if (1 <= arr[0] && arr[0] <= N / 2) {
				for (int i = 0; i < compare.length; i++)
					compare[i] = i + 1;
				int count = 1;
				boolean check = false;
				while (true) {
					for (int i = 0; i < N; i++) {
						if (arr[i] == compare[i])
							check = true;
						else
							check = false;
					}
					if (check == true)
						break;
					nextPermu(compare, N);
					count++;
				}
				System.out.println(count);
			} else {
				int tmp = N;
				for (int i = 0; i < compare.length; i++)
					compare[i] = (tmp--);
				int end = 1;
				for (int i = N; i > 0; i--)
					end *= i;
				int count = end;
				boolean check = false;
				while (true) {
					for (int i = 0; i < N; i++) {
						if (arr[i] == compare[i])
							check = true;
						else {
							check = false;
							break;
						}
					}
					if (check == true)
						break;
					prevPermu(compare, N);
					count--;
					if (count == 3)
						break;
				}
				System.out.println(count);
			}
		}
	}
}
