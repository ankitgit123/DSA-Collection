
//regex matching

class Solution {
    public boolean isMatch(String s, String p) {
        
        // int stringSize=s.length();

        // int patternSize=p.length();

        Boolean dp[][] = new Boolean[s.length()+1][p.length()+1];

      

        boolean isMatched = matchStringAndPattern(s,p,0,0,dp);

        return isMatched;
    }

    
    public boolean matchStringAndPattern(String s, String p, int i, int j,Boolean[][] dp) {
        
            // base case
            // if both strings are traversed completely

            if(i>=s.length() && j>=p.length()){
                return true;
            }

            if(j>=p.length()){
                return false;
            }

            if (dp[i][j] != null) {
               return dp[i][j];
            }

            boolean firstCharMatched=false;

            if(i<s.length()){
                
                if(s.charAt(i)==p.charAt(j)){
                    firstCharMatched=true;
                }
                else if(p.charAt(j)=='.'){
                    firstCharMatched=true;
                } 
            }
            

            if( j+1<p.length() && p.charAt(j+1)=='*'){

                // we have 2 scenarios

                // check if need to ignore * and do not match chars and jump to next char
                    boolean notIncludeStar=matchStringAndPattern(s,p,i,j+2,dp);

                // or match all preceding chars before * with string chars
                    boolean includeStar=firstCharMatched && matchStringAndPattern(s,p,i+1,j,dp);

                    dp[i][j] = notIncludeStar || includeStar;

                    //dp[i][j]=matched;
            }else{
                    if(firstCharMatched){
                        dp[i][j]=matchStringAndPattern(s,p,i+1,j+1,dp);
                    }else{
                        dp[i][j]=false;
                    }
            }

            return dp[i][j];

        }
    }


// all possible subsets of array

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> subArray = new ArrayList<>();

        printAllSubsets(0,nums,subArray,ans);
        
        return ans;
    }

    public void printAllSubsets(int index,int[] nums,List<Integer> subArray,List<List<Integer>> ans) {

        if(index==nums.length){
            ans.add(new ArrayList<>(subArray));
            return;
        }

        subArray.add(nums[index]);
        
        int addedIndex=index+1;

        printAllSubsets(addedIndex,nums,subArray,ans);
        
        
        subArray.remove(subArray.size()-1);

        printAllSubsets(addedIndex,nums,subArray,ans);
    }
}

// print all permutations of array

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> subArray = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        Arrays.fill(visited, false);

        printAllPermutations(visited,ans,0,nums,subArray);

        return ans;
        
    }

    public void printAllPermutations(boolean[] visited,List<List<Integer>> ans,int index,int[] nums,List<Integer> subArray) {

        if(index==nums.length){
            ans.add(new ArrayList<>(subArray));
            return;
        }
        for(int i=0;i<nums.length;i++){

            if(visited[i]==false){

                visited[i]=true;
                subArray.add(nums[index]);
                printAllPermutations(visited,ans,index+1,nums,subArray);
                visited[i]=false;
                subArray.remove(subArray.size()-1);
            }

        }    

       
        
    }
    
}


//generate all parenthisis
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans= new ArrayList<String>();

        generateALllParenthesis(n,0,0,"",ans);

        return ans;
        
    }
    public void generateALllParenthesis(int n,int open,int close,String str,List<String> ans) {

        if(str.length()==2*n){
            ans.add(str);
            return;
        }

        if(open<n){
            String newStr=str+"(";
            generateALllParenthesis(n,open+1,close,newStr,ans);
        }

        if(close<open){
            String newStr=str+")";
            generateALllParenthesis(n,open,close+1,newStr,ans);
        }
        
    }
}


