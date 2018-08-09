import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static String[] word;
	static ArrayList<String> pwdList = new ArrayList<>();
	static String pwd = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		word = new String[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++)
			word[i] = st.nextToken();
	}
}