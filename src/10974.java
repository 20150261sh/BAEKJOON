/* N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
 * 첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다. */

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class 10974 {
	
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
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		int end = 1;
		for(int i = N; i > 0; i--)
			end *= i;
		
		for(int i = 0; i < N; i++) 
			arr[i] = i + 1;
		
		for(int i = 0; i < end; i++) {
			for(int j = 0; j < arr.length; j++) 
				System.out.print(arr[j] + " ");
			System.out.println();
			if(permutation(arr, N) == -1)
				break;
		}
	}
}
