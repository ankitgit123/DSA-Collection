

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


