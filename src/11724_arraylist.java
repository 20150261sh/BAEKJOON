import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int u, v;
	static ArrayList<Integer>[] adjList;
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
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		String[] spl = tmp.split(" ");
		N = Integer.parseInt(spl[0]);
		M = Integer.parseInt(spl[1]);
		isVisit = new int[N];
		adjList = new ArrayList[N];
		for(int i = 0; i < N; i++)
			isVisit[i] = 0;
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			tmp = br.readLine();
			spl = tmp.split(" ");
			u = Integer.parseInt(spl[0]);
			v = Integer.parseInt(spl[1]);
			adjList[u - 1].add(v - 1);
			adjList[v - 1].add(u - 1);
		}

		for (int i = 0; i < N; i++) {
			if (isVisit[i] == 0) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
}
