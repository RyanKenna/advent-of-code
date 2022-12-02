package day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounter
{
   public static void main(String[] args) throws IOException
   {
      String file = "src/day01/input.txt";
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

      String curLine;
      ArrayList<Integer> totals = new ArrayList<Integer>();
      int total = 0;
      while ((curLine = bufferedReader.readLine()) != null) {
         if (curLine.equals("")) {
            totals.add(total);
            total = 0;
         } else
         {
            total += Integer.parseInt(curLine);
         }
      }
      bufferedReader.close();
//      System.out.println("Max value: " + Collections.max(totals));
      Collections.sort(totals);
      List<Integer> top3 = totals.subList(totals.size() -3, totals.size());
      int sum = top3.stream().mapToInt(Integer::intValue).sum();
      System.out.println(sum);
   }

}
