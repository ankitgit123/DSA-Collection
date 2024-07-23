

// cutting rod
public class Solution {


    public int solve(int[] A) {


        int[] dp=new int[A.length+1];


        

        //value of rod for each length
        for(int i=1 ; i<=A.length ; i++){

            int max_price=Integer.MIN_VALUE;

            //length upto i 
            for(int j=1 ; j<=i ; j++){
            
                max_price=Math.max( max_price , A[j-1]+dp[i-j] );

            }

            dp[i]=max_price;

        }
       
    return dp[A.length];
        
    }
}





import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// top down /memoization solution
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        
        int[][] dp= new int[n][n+1]; 
        
        for(int[] rowsOfDp:dp){
            Arrays.fill(rowsOfDp,-1);
        }
        
        
        
        return cutRodRecursive(n,n-1,price,dp);
    }
    
    public int cutRodRecursive(int totalItemsLeft,int currentIndex,int price[],int[][] dp) {
        //code here
        
        if(currentIndex==0){
            dp[currentIndex][totalItemsLeft]=totalItemsLeft*price[0];
            return dp[currentIndex][totalItemsLeft];
        }
        
        if(dp[currentIndex][totalItemsLeft]!=-1){
            return dp[currentIndex][totalItemsLeft];
        }
        
        
        int pickItem=Integer.MIN_VALUE;
        
        if(totalItemsLeft>=currentIndex+1){
            pickItem=cutRodRecursive(totalItemsLeft-(currentIndex+1),currentIndex,price,dp)+price[currentIndex];
        }
        
        int dontPickItem=cutRodRecursive(totalItemsLeft,currentIndex-1,price,dp);
        
        dp[currentIndex][totalItemsLeft]=Math.max(pickItem,dontPickItem);
        
        return dp[currentIndex][totalItemsLeft];
        
        
    }
}        
        
        return cutRodRecursive(n,n-1,price,dp);
    }
    
    public int cutRodRecursive(int totalItemsLeft,int currentIndex,int price[],int[][] dp) {
        //code here
        
        if(currentIndex==0){
            dp[currentIndex][totalItemsLeft]=totalItemsLeft*price[0];
            return dp[currentIndex][totalItemsLeft];
        }
        
        if(dp[currentIndex][totalItemsLeft]!=-1){
            return dp[currentIndex][totalItemsLeft];
        }
        
        
        int pickItem=Integer.MIN_VALUE;
        
        if(totalItemsLeft>=currentIndex+1){
            pickItem=cutRodRecursive(totalItemsLeft-(currentIndex+1),currentIndex,price,dp)+price[currentIndex];
        }
        
        int dontPickItem=cutRodRecursive(totalItemsLeft,currentIndex-1,price,dp);
        
        dp[currentIndex][totalItemsLeft]=Math.max(pickItem,dontPickItem);
        
        return dp[currentIndex][totalItemsLeft];
        
        
    }
}



//coin sum infinite 2
class Solution {
    public int change(int amount, int[] coins) {

        // to store overlapping and repetitive patterns

        int[][] dp= new int[coins.length+1][amount+1]; 

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        

        int currentIndex=coins.length-1;

        return combinationsOfCoins(dp,coins,currentIndex,amount);
        
    }

    public int combinationsOfCoins(int[][] dp,int[] coins, int currentIndex, int amount) {

        if(amount==0){
            dp[currentIndex][amount]=1;
            return dp[currentIndex][amount];
        }

        else if(amount<0){
            return 0;
        }

        else if(currentIndex<0){
            return 0;
        }

        else if(dp[currentIndex][amount]!=-1){
            return dp[currentIndex][amount];
        }

        int pickItem=combinationsOfCoins(dp,coins,currentIndex,amount-coins[currentIndex]);

        int dontPickItem=combinationsOfCoins(dp,coins,currentIndex-1,amount);

        dp[currentIndex][amount]=pickItem+dontPickItem;

        return dp[currentIndex][amount];
    }
}