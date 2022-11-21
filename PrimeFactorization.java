import java.util.Scanner;
import java.lang.Math;
public class Main{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        while(n%2==0){
            System.out.print(2+" ");
            n/=2;
        }
        for(int i=3;i<=Math.sqrt(n);i++){
            while(n%i==0){
                System.out.print(i+" ");
                n/=i;
            }
        }

        if(n>2){
            System.out.print(n);
        }
    }
}
