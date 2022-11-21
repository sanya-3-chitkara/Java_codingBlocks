import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a=s.nextInt();
        for(int i=n;i<a;i++){
            int check,sum=0,rem;
            check=i;
            while(check!=0){
                rem=check%10;
                sum=sum+rem*rem*rem;
                check/=10;
            }
            if(sum==i){
                System.out.println(i);
            }
        }
        // Your Code Here
    }
}
