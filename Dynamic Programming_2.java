//unique paths in a grid

class Solution {
    public int uniquePaths(int m, int n) {

        // for dp
        int[][] dp= new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        // no. of ways to reach end of grid
        return generateUniquePaths(m-1,n-1,dp);
        
    }

    public int generateUniquePaths(int row, int column, int[][] dp) {

        if(row==0 && column==0){
            return 1;
        }

        if(row>0 && column==0){
            return 1;
        }

        if(row==0 && column>0){
            return 1;
        }

        if(dp[row][column]!=-1){
            return dp[row][column];
        }

        int down=generateUniquePaths(row-1,column,dp);

        int right=generateUniquePaths(row,column-1,dp);
        
        dp[row][column]=down+right;
        return dp[row][column];

    }
}


// unique [aths in grid with obstacles
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rowLength=obstacleGrid.length;
        int columnLength=obstacleGrid[0].length;

        int[][] dp=new int[rowLength][columnLength];

        //dp[0][0]=1;

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<columnLength;j++){

                
               
                if(i==0 && j==0){
                     if(obstacleGrid[0][0]==0){
                        dp[0][0]=1;
                    }
                    else if(obstacleGrid[0][0]==1){
                        dp[0][0]=0;
                    }
                }
                
                else if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }
                else if(i==0){
                    dp[i][j]=dp[i][j-1];
                }

                else if(j==0){
                    dp[i][j]=dp[i-1][j];
                }
                
                else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }    
        }

        return dp[rowLength-1][columnLength-1];
    }
}


// dungeons and princess
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int[][] healthArray = new int[dungeon.length][dungeon[0].length];

        
        for(int i=dungeon.length-1;i>=0;i--){
            for(int j=dungeon[0].length-1;j>=0;j--){
                
                if(i==dungeon.length-1 && j==dungeon[0].length-1){
                    healthArray[i][j]=Math.max(1-dungeon[i][j],1);
                }
                else if(i==dungeon.length-1){
                    healthArray[i][j]=Math.max(healthArray[i][j+1]-dungeon[i][j],1);
                }
                else if(j==dungeon[0].length-1){9
                    healthArray[i][j]=Math.max(healthArray[i+1][j]-dungeon[i][j],1);
                }else{
                    healthArray[i][j]=Math.max(Math.min(healthArray[i+1][j],healthArray[i][j+1])-dungeon[i][j],1);
                }
            }    
        }

        return healthArray[0][0];
    }
}




