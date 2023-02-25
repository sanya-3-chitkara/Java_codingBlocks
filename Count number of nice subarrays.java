import java.util.*;
public class Main {



    public static int countNiceSubArrays(int[] nums,int k)
    {
        //Write your code here
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) nums[i]=0;
            else nums[i]=1;
        }
        int [] arr=new int[n+1];
        arr[0]=1;
        int sum=0;
        int ans=0;
        for(int num:nums){
            sum+=num;
            if(sum>=k)  ans+=arr[sum-k];
            arr[sum]++;
        }
        return ans;
        
    }



    public static void main (String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(countNiceSubArrays(arr,k));
    }

}
