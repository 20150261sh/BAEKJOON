import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int[] height = new int[9];
   static int x1, x2;
   static int total = 0;

   static void findReal() {
      for (int i = 0; i < 9; i++) {
         total -= height[i];
         for(int j = 1; j < 9; j++) {
            if(total - height[j] == 100) {
               x1 = i;
               x2 = j;
               return;
            }
         }
         total += height[i];
      }
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 0; i < 9; i++) {
         height[i] = Integer.parseInt(br.readLine());
         total += height[i];
      }

      Arrays.sort(height);
      findReal();
      for(int i = 0; i < 9; i++) {
         if(i == x1 || i == x2)
            ;
         else
            System.out.println(height[i]);
      }
   }
}