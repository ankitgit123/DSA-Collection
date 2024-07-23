//Check if path exists in graph

import java.util.*;

public class Solution {
    
    public int solve(int A, int[][] B) {

        // to store the adjaceny list
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();


        for(int i=0;i<B.length;i++){

            ArrayList<Integer> arrayList =new ArrayList<>();

            //source
            int source=B[i][0];
            //destination
            int destination=B[i][1];

            //check if map contains this source already or not
            if(map.containsKey(source)){
                //get that source
                arrayList=map.get(source);
            }
            arrayList.add(destination);
            map.put(source,arrayList);
        }   

        // to track the visited nodes
        boolean[] visited = new boolean[A+1];

        //visit the nodes
        dfsSearch(1,map,visited);


        if(visited[A]){
            return 1;
        }else{
            return 0;
        }

    }


    public void dfsSearch(int startNode, HashMap<Integer,ArrayList<Integer>> map, boolean[] visited){
        
        // marke the first node as visited
        visited[startNode]=true;

        ArrayList<Integer> linkedNodes = map.get(startNode);

        if(linkedNodes!=null){
            for(int value:linkedNodes){
                if(visited[value]==false){
                    dfsSearch(value,map,visited);
                }
            }
        }


    }    

}



//isCycle present
/*Complete the function below*/

class Solution {
    
    boolean isCycle=false;
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
    
        // to store the adjancy list
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        
        //to monitor visited nodes
        boolean[] visited=new boolean[V+1];
        
        //present in current path or not
        boolean[] inCurrentPath=new boolean[V+1];
        
        for(int j=0;j<V;j++){
            dfs(j,adj,visited,inCurrentPath);
        }
        
        return isCycle;
        
    }
    
    
    public void dfs(int startNode, ArrayList<ArrayList<Integer>> map, boolean[] visited,boolean[] inCurrentPath) {
        
        //mark as visited
        visited[startNode]=true;
        
        //mark as in current path
        inCurrentPath[startNode]=true;
        
        ArrayList<Integer> nodes=map.get(startNode);
        
        if(nodes!=null){
            for(int node:nodes){
                
                if(!visited[node]){
                    dfs(node,map,visited,inCurrentPath);
                }else{
                    
                    // it means this is not visited 
                    
                    // now check if its in current path or not
                    // if in current path then it has cycle
                    if(inCurrentPath[node]){
                        isCycle=true;
                    }
                }
            }
        }
        
        //when backtracking mark current path as false
        inCurrentPath[startNode]=false;
        
    }
}


//number of islands
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        
        // Code here
        
        // to keep in check which cells are visited so again when visiting them again 
        // we dont need to  mark them again
        int[][] visited=new int[grid.length][grid[0].length];
        
        
        int count=0;
        
        int totalRows=grid.length;
        int totalColumns=grid[0].length;
        
        
        for(int i=0;i<totalRows;i++){
            
            for(int j=0;j<totalColumns;j++){
                
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    
                    count=count+1;
                    
                    dfs(visited,grid,i,j,totalRows,totalColumns);
                }
            }
            
        }
        
        return count;
    }
    
    
    public void dfs(int[][] visited,char[][] grid, int i,int j,int totalRows,int totalColumns) {
        
        if(i<0 ||j<0 ||i>totalRows-1 || j>totalColumns-1){
            return;
        }
        
        if(grid[i][j]=='0'){
            return;
        }
        
        
        
        if(grid[i][j]=='1' && visited[i][j]==0){
            
            visited[i][j]=1;
            
            dfs(visited,grid,i-1,j-1,totalRows,totalColumns);
            dfs(visited,grid,i-1,j,totalRows,totalColumns);
            dfs(visited,grid,i-1,j+1,totalRows,totalColumns);
            dfs(visited,grid,i,j-1,totalRows,totalColumns);
            dfs(visited,grid,i,j+1,totalRows,totalColumns);
            dfs(visited,grid,i+1,j-1,totalRows,totalColumns);
            dfs(visited,grid,i+1,j,totalRows,totalColumns);
            dfs(visited,grid,i+1,j+1,totalRows,totalColumns);
        }
        
        
    }
    
}




//




