import java.util.*;
public class Main {



    public static int maxConsecutive1(int[] arr,int k)
    {
        int i=0,j;
        for(j=0;j<arr.length;j++){
            if(arr[j]==0){
                k--;
            }
            if(k<0 && arr[i++]==0)k++;

        }
        return j-i;
    }



    public static void main (String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(maxConsecutive1(arr,k));
    }

}
