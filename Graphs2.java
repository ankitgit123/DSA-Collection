//isCycle present
/*Complete the function below*/

class Solution {
    
    boolean isPossibleToFInish=false;
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
        
        return isPossibleToFInish;
        
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
                        isPossibleToFInish=true;
                    }
                }
            }
        }
        
        //when backtracking mark current path as false
        inCurrentPath[startNode]=false;
        
    }
}



//Another BFS
public class Solution {


    class Pair {
        int currentVertex;
        int weightOfEdgeToReachcurrentVertex;

        public Pair(int currentVertex, int weightOfEdgeToReachcurrentVertex) {
            this.currentVertex = currentVertex;
            this.weightOfEdgeToReachcurrentVertex = weightOfEdgeToReachcurrentVertex;
        }
    }


   public int solve(int A, int[][] B, int C,int D) {


        // Create a graph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();


        for (int i = 0; i < A; i++) {

            graph.add(new ArrayList<>());
        }

        for (int i=0; i<B.length; i++) {

            int sourceVertex = B[i][0];
            int destinationVertex = B[i][1];
            int weight = B[i][2];

            graph.get(sourceVertex).add(new Pair(destinationVertex, weight));
            graph.get(destinationVertex).add(new Pair(sourceVertex, weight));

        }

        //Dijkstra's algorithm
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>( (a,b) -> a.weightOfEdgeToReachcurrentVertex-b.weightOfEdgeToReachcurrentVertex );

        priorityQueue.add(new Pair(C, 0));

        int[] distanceFromSourceArray = new int[A];

        Arrays.fill(distanceFromSourceArray, -1);

        // Process priorityQueue
        while ( !priorityQueue.isEmpty() ) {

            Pair removedPair = priorityQueue.poll();
            
            int distance = removedPair.weightOfEdgeToReachcurrentVertex;

            int nodeValue = removedPair.currentVertex;

            // Check if the node/vertex is visited or not
            if ( distanceFromSourceArray[nodeValue] == -1 ) {

                distanceFromSourceArray[nodeValue]=distance;

                for(Pair neighbourPair:graph.get(nodeValue) ){

                     int neighbourNodeValue=neighbourPair.currentVertex;

                     int neighbourDistance = neighbourPair.weightOfEdgeToReachcurrentVertex;
                     
                     if ( distanceFromSourceArray[neighbourNodeValue] == -1 ) {
                     
                         priorityQueue.add(new Pair(neighbourNodeValue, distance+neighbourDistance ));
                     
                     }

                }

            }
            
            else{
                
                continue;
            }
           
        }


        

        return distanceFromSourceArray[D];
    }

}


//Topological Sort
import java.util.*;

public class Solution {

    int maxn = 10009;

    int[] in = new int[maxn];

    ArrayList < ArrayList < Integer > > adj;

    Stack<Integer> stack =  new Stack<>(); 


    public int[] solve(int A, int[][] B) {

        adj = new ArrayList < ArrayList < Integer > > (maxn);

        for (int i = 0; i < maxn; i++) {
            in [i] = 0;
            adj.add(new ArrayList < Integer > ());
        }

        for (int[] edge: B) {

            adj.get(edge[0]).add(edge[1]); 

        }



        for (int i = 1; i <= A; i++) {

            if ( in [i] == 0){
                topologicalSort(i);
            }
        }

        ArrayList < Integer > ans = new ArrayList < Integer > ();

        

        while (!stack.isEmpty()) {

            int temp = stack.pop();

            ans.add(temp);
            
           
        }

        Collections.reverse(ans);
 

        int[] res = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        
        return res;
    }


    public void topologicalSort(int node) {

        in[node]=1;

        for (int i : adj.get(node)) {
            
            if(in[i]==0){

                topologicalSort(i);
            }

        }

        stack.push(node);

    }
}