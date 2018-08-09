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

	static void back(int d, int idx, String pwd) {
		
		if (L == d) {
			int mo = 0;
			int ja = 0;
			for (int i = 0; i < pwd.length(); i++) {
				if (pwd.charAt(i) == 'a' || pwd.charAt(i) == 'e' || pwd.charAt(i) == 'i' || pwd.charAt(i) == 'o'
						|| pwd.charAt(i) == 'u')
					mo++;
				else
					ja++;
			}
			if(mo >= 1 && ja >= 2) {
				pwdList.add(pwd);
			}
			return;
		} else {
			for (; idx < C; idx++)
				back(d + 1, idx + 1, pwd + word[idx]);
		}
	}

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

		Arrays.sort(word);
		back(0, 0, pwd);
		String[] res = new String[pwdList.size()];
		for(int i = 0; i < pwdList.size(); i++) {
			res[i] = pwdList.get(i);
		}
		Arrays.sort(res);
		for(int i = 0; i < pwdList.size(); i++) {
			System.out.println(res[i]);
		}
	}
}