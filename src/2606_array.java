import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N, M;
	static int u, v;
	static int[][] mat;
	static int[] isVisit;
	static int count = 0;
	
	static void dfs(int startnode) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(startnode);
		isVisit[startnode] = 1;
		while (!st.isEmpty()) {
			int tmp = st.peek();
			boolean checkPop = true;
			for (int i = 0; i < N; i++) {
				if (isVisit[i] == 0 && mat[tmp][i] == 1) {
					st.push(i);
					isVisit[i] = 1;
					count++;
					checkPop = false;
					break;
				}
			}
			if (checkPop) {
				st.pop();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = "";
		tmp = br.readLine();
		N = Integer.parseInt(tmp);
		tmp = br.readLine();
		M = Integer.parseInt(tmp);
		mat = new int[N][N];
		isVisit = new int[N];
		for (int i = 0; i < M; i++) {
			tmp = br.readLine();
			String[] spl = tmp.split(" ");
			u = Integer.parseInt(spl[0]);
			v = Integer.parseInt(spl[1]);
			mat[u - 1][v - 1] = 1;
			mat[v - 1][u - 1] = 1;
		}
		dfs(0);
		System.out.println(count);
	}
}
