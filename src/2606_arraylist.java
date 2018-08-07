import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
	static int N, M;
	static int u, v;
	static ArrayList<Integer>[] adjList;
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
			for(int i = 0; i < adjList[tmp].size(); i++) {
				if (isVisit[adjList[tmp].get(i)] == 0) {
					st.push(adjList[tmp].get(i));
					isVisit[adjList[tmp].get(i)] = 1;
					checkPop = false;
					break;
				}
			}
			if (checkPop) {
				st.pop();
			}
		}
		for(int i = 0; i < isVisit.length; i++)
			count += isVisit[i];
		count--;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = "";
		tmp = br.readLine();
		N = Integer.parseInt(tmp);
		tmp = br.readLine();
		M = Integer.parseInt(tmp);
		isVisit = new int[N];
		adjList = new ArrayList[N];
		for(int i = 0; i < N; i++)
			isVisit[i] = 0;
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			tmp = br.readLine();
			String[] spl = tmp.split(" ");
			u = Integer.parseInt(spl[0]);
			v = Integer.parseInt(spl[1]);
			adjList[u - 1].add(v - 1);
			adjList[v - 1].add(u - 1);
		}
		dfs(0);
		System.out.println(count);
	}
}
