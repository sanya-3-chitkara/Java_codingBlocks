import java.util.*;
public class Main {



    public static int consecutive1(int[] arr)
    {
        //Write your code here
        int count=0;
        int result=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count=0;
            }
            else{
                count++;
                result=Math.max(result,count);
            }
        }
        return result;
    }



    public static void main (String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(consecutive1(arr));
    }

}
