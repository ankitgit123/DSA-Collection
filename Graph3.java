//Commutable islands
import java.util.*;


public class Solution {

    class Pair{


        int destinationIsland;

        int costOfBridge;


        Pair(int destinationIsland,int costOfBridge){
            
            this.destinationIsland=destinationIsland;
            this.costOfBridge=costOfBridge;

        }
    }

    //declare the priority queue sorte
    PriorityQueue<Pair> priorityQueue = new PriorityQueue<>( (p1,p2) -> p1.costOfBridge-p2.costOfBridge );

    //adjancey list
    ArrayList<ArrayList<Pair>> adjanceylist = new ArrayList<>();

    // distance
    int distance=0;


    public int solve(int A, int[][] B) {

        int numberOfBridges = B.length;


        // solution using primes algo
        boolean[] visited = new boolean[A+1];

        
        //build a adjanceylist
        buildAdjacencyList(A,numberOfBridges,B);

        
        calculateBridgeCostUsinfPrimesAlgo(visited);

        return distance;

    }

    public void buildAdjacencyList(int A, int numberOfBridges, int[][] B ){



        for(int i=1 ; i<=A+1 ; i++){
            adjanceylist.add(new ArrayList<Pair>());
        }


        //assign the values to all nodes and their child nodes
        for(int i=1 ; i<=numberOfBridges ; i++){
            
            //it is undirected graph so ned to add both vertes who are having common edge from both sides
            adjanceylist.get( B[i][0] ).add( new Pair( B[i][1] , B[i][2] ) );

            adjanceylist.get( B[i][1] ).add( new Pair( B[i][0] , B[i][2] ));

        }
    }


    public void calculateBridgeCostUsinfPrimesAlgo(boolean[] visited){

        
        priorityQueue.offer(new Pair(1,0));


        // checking for other islands
        while( !priorityQueue.isEmpty() ){
            
            Pair removedPair = priorityQueue.remove();

            if( visited[removedPair.destinationIsland]== false ){

                visited[removedPair.destinationIsland]=true;


                // calculate distance
                distance = distance+removedPair.costOfBridge;


                // check for its linked/asdjacent islandsone by one
                for(Pair adjacentIsland: adjanceylist.get(removedPair.destinationIsland)){


                    
                    if(visited[ adjacentIsland.destinationIsland ] == false ) {
                        priorityQueue.offer( new Pair( adjacentIsland.destinationIsland,adjacentIsland.costOfBridge ) );
                    }

                }
                
            }else{

                // continue to different island as we have already vcisited this island
                continue;
            }


        }


    }
}



//Djikstra Algo
public class Solution {


    class Pair {
        int currentVertex;
        int weightOfEdgeToReachcurrentVertex;

        public Pair(int currentVertex, int weightOfEdgeToReachcurrentVertex) {
            this.currentVertex = currentVertex;
            this.weightOfEdgeToReachcurrentVertex = weightOfEdgeToReachcurrentVertex;
        }
    }


   public int[] solve(int A, int[][] B, int C) {


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
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weightOfEdgeToReachcurrentVertex));

        priorityQueue.add(new Pair(C, 0));

        int[] distanceFromSourceArray = new int[A];

        Arrays.fill(distanceFromSourceArray, Integer.MAX_VALUE);

        distanceFromSourceArray[C] = 0;

        // Process priorityQueue
        while ( !priorityQueue.isEmpty() ) {

            Pair removedPair = priorityQueue.poll();


            // Check if the vertex is marked or not
            if ( distanceFromSourceArray[removedPair.currentVertex] > removedPair.weightOfEdgeToReachcurrentVertex ) {

                

                for ( Pair neighbourPair : graph.get(removedPair.currentVertex) ) {

                    int distanceToReachNeighbourPair = distanceFromSourceArray[removedPair.currentVertex] + neighbourPair.weightOfEdgeToReachcurrentVertex;
                    
                    if ( distanceFromSourceArray[neighbourPair.currentVertex] > distanceToReachNeighbourPair ) {
                        
                       

                        priorityQueue.add(new Pair(neighbourPair.currentVertex, distanceToReachNeighbourPair ));

                        distanceFromSourceArray[neighbourPair.currentVertex] = distanceToReachNeighbourPair;
                    }

                }


            }
            else{
                
                continue;
            }
           
        }


        // Convert the array to ArrayList
        for(int i = 0; i < A; i++){
            
            if( distanceFromSourceArray[i] == Integer.MAX_VALUE ){
                distanceFromSourceArray[i] = -1;
            }

        }

        return distanceFromSourceArray;
    }

}


//construction cost
import java.util.*;

// same as question 1
public class Solution {

    class Pair{


        int destinationIsland;

        int costOfBridge;


        Pair(int destinationIsland,int costOfBridge){
            
            this.destinationIsland=destinationIsland;
            this.costOfBridge=costOfBridge;

        }
    }

    int mod = 1000000007;

    //declare the priority queue sorte
    PriorityQueue<Pair> priorityQueue = new PriorityQueue<>( (p1,p2) -> p1.costOfBridge-p2.costOfBridge );

    //adjancey list
    ArrayList<ArrayList<Pair>> adjanceylist = new ArrayList<>();

    // distance
    int distance=0;


    public int solve(int A, int[][] B) {

        int numberOfBridges = B.length;


        // solution using primes algo
        boolean[] visited = new boolean[A+1];

        
        //build a adjanceylist
        buildAdjacencyList(A,numberOfBridges,B);

        
        calculateBridgeCostUsinfPrimesAlgo(visited);

        return distance%mod;

    }

    public void buildAdjacencyList(int A, int numberOfBridges, int[][] B ){



        for(int i=0 ; i<=A ; i++){
            adjanceylist.add(new ArrayList<Pair>());
        }


        //assign the values to all nodes and their child nodes
        for(int i=0 ; i<numberOfBridges ; i++){
            
            //it is undirected graph so ned to add both vertes who are having common edge from both sides
            adjanceylist.get( B[i][0] ).add( new Pair( B[i][1] , B[i][2] ) );

            adjanceylist.get( B[i][1] ).add( new Pair( B[i][0] , B[i][2] ));

        }
    }


    public void calculateBridgeCostUsinfPrimesAlgo(boolean[] visited){

        
        priorityQueue.offer(new Pair(1,0));


        // checking for other islands
        while( !priorityQueue.isEmpty() ){
            
            Pair removedPair = priorityQueue.remove();

            if( visited[removedPair.destinationIsland]== false ){

                visited[removedPair.destinationIsland]=true;


                // calculate distance
                distance = (distance+removedPair.costOfBridge)%mod;


                // check for its linked/asdjacent islandsone by one
                for(Pair adjacentIsland: adjanceylist.get(removedPair.destinationIsland)){


                    
                    if(visited[ adjacentIsland.destinationIsland ] == false ) {
                        priorityQueue.offer( new Pair( adjacentIsland.destinationIsland,adjacentIsland.costOfBridge ) );
                    }

                }
                
            }else{

                // continue to different island as we have already vcisited this island
                continue;
            }


        }


    }
}
