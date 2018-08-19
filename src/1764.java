import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static String[] d;
	static String[] b;
	static int count = 0;
	static String res = "";

	public static void main(String[] args) throws IOException {
		Hashtable<String, Integer> h = new Hashtable<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		d = new String[N];
		b = new String[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			d[i] = st.nextToken();
			h.put(d[i], 1);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			b[i] = st.nextToken();
			if (h.get(b[i]) != null) {
				int tmp = h.get(b[i]);
				h.put(b[i], ++tmp);
			} else
				h.put(b[i], 1);
		}

		Enumeration keys = h.keys();
		while (keys.hasMoreElements()) {
			String keyS = (String) keys.nextElement();
			if (h.get(keyS) == 2) {
				count++;
				res += keyS + "\n";
			}
		}
		String[] db = res.split("\n");
		Arrays.sort(db);
		System.out.println(count);
		for (int i = 0; i < db.length; i++)
			System.out.println(db[i]);
	}
}