import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int[] height = new int[9];
   static int[] save = new int[7];
   static ArrayList<Integer> heList = new ArrayList<>();
   static int total = 0;

   static void back(int d, int idx, int total, int saving) {
      if (d == 7) {
         if (total == 100) {
            for(int i = 0; i < 7; i++)
               heList.add(save[i]);
         } else if (total > 100) {
            save[idx-1] = 0;
            total -= height[idx++];
            d--;
         }
         return;
      } else {
         for (; idx < 7; idx++) {
            back(d + 1, idx + 1, total += height[idx], save[idx] = height[idx]);
         }
      }
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for (int i = 0; i < 9; i++) {
         height[i] = Integer.parseInt(br.readLine());
      }
   }
}