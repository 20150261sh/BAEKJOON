import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int[] height = new int[9];
   static int[] save = new int[7];
   static ArrayList<Integer> heList = new ArrayList<>();
   static int total = 0;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for (int i = 0; i < 9; i++) {
         height[i] = Integer.parseInt(br.readLine());
      }
   }
}