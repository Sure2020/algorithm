import java.util.ArrayList;
import java.util.List;

public class LC70_climbing_stairs{
    class Solution20240703 {
        List<Integer> dp = new ArrayList<>();
        int result = -1;
        public int climbStairs(int n) {
            if(n==1|| n==2){
                return n;
            }
            int num1=1,num2=2,num3=-1;
            for(int i=3;i<=n;i++){
                num3 = num1 + num2;
                //System.out.println(num1 + "   " + num2 + "   " + num3);
                num1=num2;
                num2=num3;

            }
            return num3;
        }
    }
//过了半个月忘了，哎。首先这是个最基础的动态规划，然后这是个斐波那契数列
//n=1,result=1
//n=2,result=2
//n=3,result=3
//n=4,result=5
//1,1,1,1
//1,2,1
//1,1,2
//2,1,1
//2,2
class Solution20240801 {
    public int climbStairs(int n) {
        int n1 = 1,n2=2,n3=0;
        if(n==1||n==2){
            return n;
        }
        for(int i=3;i<=n;i++){
            n3 = n1+n2;
            n1=n2;
            n2=n3;
        }
        return n3;
    }
}
//斐波那契数列
//f(1)=1,f(2)=2,f(3)=3,f(4)=5
//事后：用迭代的算法直接秒了
class Solution20241128 {
    public int climbStairs(int n) {
        if(n==1||n==2){
            return n;
        }
        //return climbStairs(n-1)+climbStairs(n-2);
        int n1=1,n2=2,n3=0;
        for(int i=3;i<=n;i++){
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }
        return n3;
    }
}
//斐波那契数列，但是会超时。改用迭代。

    class Solution20250513 {
        public int climbStairs(int n) {
            // f(1)=1   f(2)=2  f(3)=f(1)+f(2)
            if(n==1||n==2){
                return n;
            }
            int n1=1,n2=2,n3=0,index=3;
            for(int i=3;i<=n;i++){
                n3=n1+n2;
                n1=n2;
                n2=n3;
            }
            return n3;
        }
    }
    class Solution20250525 {
        public int climbStairs(int n) {
            if(n==0 || n==1 || n==2){
                return n;
            }
            int n1=1,n2=2,n3=0;
            for(int i=3;i<=n;i++){
                n3=n1+n2;
                n1=n2;
                n2=n3;
            }
            return n3;
        }
    }
}
