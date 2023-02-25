import java.util.*;
public class Main {
    public static void main(String args[]) {
         Scanner scn=new Scanner(System.in);
        int n = scn.nextInt(); 
         int[] arr=new int[n];
           for (int i = 0; i < n; i++) 
            arr[i]=scn.nextInt();
            System.out.print(maxProfit(arr)); 
    }
      public static int maxProfit(int prices[]) {
       // Write your code here
       int n=prices.length;
       int buy = prices[0], max_profit = 0;
    for (int i = 1; i < n; i++) {
 
      // Checking for lower buy value
      if (buy > prices[i])
        buy = prices[i];
 
      // Checking for higher profit
      else if (prices[i] - buy > max_profit)
        max_profit = prices[i] - buy;
    }
    return max_profit;
    }
}
