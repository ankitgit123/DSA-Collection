9
// generate all fibonnaci

class Solution {
    public int fib(int n) {

    int[] dp = new int[n+1];
    
    Arrays.fill(dp,-1);

    int fib=generateFibonnaci(n,dp);

    return fib;
        
    }

    public int generateFibonnaci(int n,int[] dp) {

        if(n<=1){
            if(dp[n]==-1){
                dp[n]=n;
                return dp[n];
            }
            return 1;
        }

        if(n==0){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int x= fib(n-1);
        int y= fib(n-2);

        dp[n]=x+y;
        return dp[n];
    }
}


no. of ways to climb steps
class Solution {
    public int climbStairs(int n) {

    int[] dp = new int[n+1];
    
    Arrays.fill(dp,-1);

    int steps=generateStepsToClimbStairs(n,dp);

    return steps;
        
    }

    public int generateStepsToClimbStairs(int n,int[] dp) {

        if(n==1){
            
            return 1;
        }

        if(n==2){
            return 2;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int x= generateStepsToClimbStairs(n-1,dp);
        int y= generateStepsToClimbStairs(n-2,dp);

        dp[n]=x+y;
        return dp[n];
    }
}


// perfect squares
class Solution {
    public int numSquares(int n) {

        int ans=Integer.MAX_VALUE;

        int[] dp=new int[n+1];

        Arrays.fill(dp,-1);   

        return generateMinimumPerfectSquares(n,ans,dp);
        
    }

    public int generateMinimumPerfectSquares(int n,int ans,int[] dp) {

        if(n==0){
            return 0;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }

        for(int i=1;i*i<=n;i++){
            int x=generateMinimumPerfectSquares(n-(i*i),ans,dp);

            int y=x+1;
            ans=Math.min(ans,y);

            dp[n]=ans;               
        }

        return dp[n];  
    }
}

//sum of non adjacent numbers in array 
class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp  = new int[n+1];
        Arrays.fill(dp,-1);
        return generateMaxSum(0,arr,dp);
    }
    
    int generateMaxSum(int i, int[] arr,int[] dp) {
        // code here
        
        if(i>=arr.length){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        // take the value
        int firstSum = arr[i]+generateMaxSum(i+2,arr,dp);
        
        //ignore current vakue and pick adjacent element
        //and take the value
        int secondSum = generateMaxSum(i+1,arr,dp);
        
        
        dp[i]=Math.max(firstSum,secondSum);
        
        return dp[i];
        
    }
}