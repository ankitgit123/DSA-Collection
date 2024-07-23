
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
 // merge k sorted lists
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>((listNodeA,listNodeB)->listNodeA.val-listNodeB.val);

        for(int i=0;i<lists.length;i++){
            
            ListNode x = lists[i];

            ListNode currentNode = x;


            // insert into heap for allnodes of singlr list

            while(currentNode!= null){
                pq.add(currentNode);
                currentNode=currentNode.next;
            }

        }


        // now remove from heap and add it to answerList

        ListNode rootAnswerList = pq.poll();

        ListNode currentNode = rootAnswerList;

        while( !pq.isEmpty() ){
            ListNode x =pq.poll();
            currentNode.next=x;
            currentNode=currentNode.next;
        }

        if(currentNode!=null){
            currentNode.next=null;
        }

        return rootAnswerList;
    }
}

//sort an array
import java.util.*;

class Solution {
    public int[] sortArray(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // adding into heap(pq)
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        int i=0;

        //getting and extracting(deleting) element from heap(pq)
        while(!pq.isEmpty()){
            int x=pq.poll();

            nums[i]=x;
            i++;
        }

        return nums;
        
    }
}



//kth largest element

import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0;i<k;i++){
            pq.add(nums[i]);
        }

       for(int j = k;j<nums.length;j++){

            

            if( nums[j] > pq.peek() ){

                pq.poll();

                pq.add(nums[j]);
            }
        }

        return pq.peek();
        
    }
}