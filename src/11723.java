/* 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.


add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다.
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다. 


첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.
둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다. */

import java.util.Scanner;

public class B11723 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		int S = 0;
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < M; i++) {
			String input = scanner.next();

			if ("add".equals(input)) {
				int x = scanner.nextInt();
				S |= (1 << x);
			} else if ("remove".equals(input)) {
				int x = scanner.nextInt();
				S ^= (1 << x);
			} else if ("check".equals(input)) {
				int x = scanner.nextInt();
				int result = (S & (1 << x));
				if (result > 0) {
					answer.append("1\n");
				} else if (result == 0) {
					answer.append("0\n");
				}
			} else if ("toggle".equals(input)) {
				int x = scanner.nextInt();
				S = S ^ (1 << x);
			} else if ("all".equals(input)) {
				S = (1 << 21) - 1;
				S = S & ~(1);
			} else if ("empty".equals(input)) {
				S = 0;
			}
		}
		System.out.println(answer);
	}
}
