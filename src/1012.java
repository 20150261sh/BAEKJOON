import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int T;
   static int M, N, K;
   static int u, v;
   static int[][] mat;
   static boolean[][] isVisit;
   static int count = 0;
   static int x, y, xx, yy;
   static int[] dx = { 0, 1, 0, -1 };
   static int[] dy = { 1, 0, -1, 0 };

   static void dfs(int n1, int n2) {
      isVisit[n1][n2] = true;
      for (int k = 0; k < 4; k++) {
         xx = n1 + dx[k];
         yy = n2 + dy[k];
         if (xx < 0 || yy < 0 || xx >= N || yy >= M)
            continue;
         if (!isVisit[xx][yy] && mat[xx][yy] == 1) {
            dfs(xx, yy);
         }
      }
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = null;
      st = new StringTokenizer(br.readLine());
      T = Integer.parseInt(st.nextToken());
      while (T > 0) {
         count = 0;
         T--;
         st = new StringTokenizer(br.readLine(), " ");
         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());
         mat = new int[N][M];
         for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
               mat[i][j] = 0;
         isVisit = new boolean[N][M];
         for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
               isVisit[i][j] = false;

         for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            mat[v][u] = 1;
         }

         for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
               if (!isVisit[i][j] && mat[i][j] == 1) {
                  dfs(i, j);
                  count++;
               }
            }
         }
         System.out.println("*" + count);
      }
   }
}