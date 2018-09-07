import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static String input = "";
	static String univ = "CAMBRIDGE";
	static boolean[] check = new boolean[91];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		input = st.nextToken();

		for (int i = 0; i < univ.length(); i++)
			check[univ.charAt(i)] = true;

		for (int i = 0; i < input.length(); i++)
			if (!check[input.charAt(i)])
				System.out.print(input.charAt(i));
	}
}