

1. max profit inside time limit

import java.util.*;

public class Solution {
    
    public class PairOfExpiryAndProfit{
    
        int expiry;
        int profit;

        public PairOfExpiryAndProfit(int expiry, int profit){
            this.expiry = expiry;
            this.profit = profit;

        }

    }


    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

            long totalMaxProfit = 0;

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int n=A.size();

            ArrayList<PairOfExpiryAndProfit> pairList = new ArrayList<>();

            for(int i=0;i<n;i++){
                pairList.add( new PairOfExpiryAndProfit( A.get(i),B.get(i) ) );
            }

           

            int timeOfExpiry=0;

             Collections.sort(pairList,(a,b)->{
                        return ( a.expiry-b.expiry );
            });

            for(int i=0;i<n;i++){

                if(timeOfExpiry < pairList.get(i).expiry){

                        minHeap.add(pairList.get(i).profit);
                        timeOfExpiry++;

                }else{

                    if(pairList.get(i).profit > minHeap.peek()){
                        minHeap.remove();
                        minHeap.add(pairList.get(i).profit);

                    }
                }
            }

            
            
            while( minHeap.size()>0 ){
                totalMaxProfit = (totalMaxProfit+minHeap.remove())%1000000007;
            }
            
            return (int) totalMaxProfit;

    }
}

2. min candies 

class Solution {
    public int candy(int[] ratings) {

        // minimum candies to distribute
        int[] totalCandies=new int[ratings.length];

        int sumCandies=0;

        int size=ratings.length;


        // atleast 1 candy should be there
        for(int i=0;i<size;i++){
            totalCandies[i]=1;
        }

        // checking from left to right
        for(int j=1;j<=size-1;j++){

            if( ratings[j] > ratings[j-1] ){
                totalCandies[j]=totalCandies[j-1]+1;
            }

        }

        // checking from right to left
        for(int k=size-2;k>=0;k--){

            if( ratings[k] > ratings[k+1] ){
                
                // if candies at k less than euqal k+1
                if(totalCandies[k] <= totalCandies[k+1]){
                    totalCandies[k]=totalCandies[k+1]+1;
                }
                
                // if candies at k already greater than k+1
                else if(totalCandies[k] > totalCandies[k+1]){
                    totalCandies[k]=totalCandies[k];
                }

            }

        }

        
        // total sum of candies

        // checking from left to right
        for(int l=0;l<totalCandies.length;l++){

            
                sumCandies=sumCandies+totalCandies[l];
            

        }

        return sumCandies;

    }
}





3. max jobs in before end time
public class Solution {
    
    public class PairOfStartAndEndTime{
    
        int startTime;
        int endTime;

        public PairOfStartAndEndTime(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;

        }

    }
    
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

         //total jobs
         int totalJobs=1;
         
         // declare array list of type pair for each item of A and its corresponding B item
         ArrayList<PairOfStartAndEndTime> pair = new ArrayList<>();


        //traverse through A and B to insert items in pair ArrayList
        for(int i=0;i<A.size();i++){
            pair.add(new PairOfStartAndEndTime( A.get(i),B.get(i) ));
        }

        //sort pair array based on endTime
        Collections.sort(pair,(a,b)->{
            return ( a.endTime-b.endTime );
        });


        //end time of previous job
        int endTimeOfPreviousJob=pair.get(0).endTime;

        for(int i=1;i<A.size();i++){
            if(pair.get(i).startTime>=endTimeOfPreviousJob){
                endTimeOfPreviousJob=pair.get(i).endTime;
                totalJobs+=1;
            }
        }


        return totalJobs;
        
    }



}
