import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static String[] word;
	static String[] sort;
	static Hashtable<String, Integer> h = new Hashtable<String, Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		word = new String[N];

		String tmp = "";
		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = st.nextToken();
			if (h.get(tmp) == null) {
				h.put(tmp, 1);
				word[idx++] = tmp;
			}
		}
		sort = new String[idx];

		for (int i = 0; i < sort.length; i++) {
			sort[i] = word[i];
		}

		Arrays.sort(sort, new Comparator<String>() {

			@Override
			public int compare(String up, String low) {
				// TODO Auto-generated method stub
				return up.length() - low.length();
			}
		});

		Arrays.sort(sort, new Comparator<String>() {

			@Override
			public int compare(String up, String low) {
				// TODO Auto-generated method stub
				if (up.length() == low.length()) {
					return up.compareTo(low);
				}
				return 0;
			}
		});

		for (int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}
	}
}