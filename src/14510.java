import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int day = 0;
	static boolean[] visit;
	static int answer = 0;
	static int[][] cons;

	static void dfs(int day, int money) {
		if (visit[day])
			return;
		visit[day] = true;
		if (N - day >= cons[0][day]) {
			money += cons[1][day];
			day += cons[0][day];
			if (money > answer)
				answer = money;
		}

		for (int i = day; i < N; i++) {
			if (!visit[i] && N - i >= cons[0][i]) {
				dfs(i, money);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cons = new int[2][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				cons[j][i] = sc.nextInt();
			}
		}

		for (int day = 0; day < N; day++) {
			visit = new boolean[N];
			dfs(day, 0);
		}
		System.out.println(answer);
	}
}