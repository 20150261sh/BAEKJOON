/* 1부터 N까지의 수로 이루어진 순열이 있다. 이 때, 사전순으로 바로 이전에 오는 순열을 구하는 프로그램을 작성하시오.
사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다. 
첫째 줄에 입력으로 주어진 순열의 이전에 오는 순열을 출력한다. 만약, 사전순으로 가장 처음에 오는 순열인 경우에는 -1을 출력한다. */

import java.util.Scanner;

public class 10973 {

	static void swap(int[] arr, int n1, int n2) {
		int tmp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = tmp;
	}

	static void reverseSort(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			swap(arr, i, arr.length - 1 - i);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N;
		N = scan.nextInt();
		int[] arr = new int[N];
		int n1 = 0, n2 = 0;
		boolean check = false;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}

		for(int i = arr.length - 1; i > 0; i--){
			if (arr[i-1] > arr[i]) {
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
				for (int j = 0; j < arr.length; j++)
					System.out.print(arr[j] + " ");
				System.out.println();
			} else {
				int[] tmp = new int[N - n1 - 1];
				int idx = n1 + 1;
				for (int i = 0; i < tmp.length; i++) {
					tmp[i] = arr[idx++];
				}
				reverseSort(tmp);
				for (int j = 0; j <= n1; j++)
					System.out.print(arr[j] + " ");
				for (int j = 0; j < tmp.length; j++)
					System.out.print(tmp[j] + " ");
				System.out.println();
			}

		}
	}
}
