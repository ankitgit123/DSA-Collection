
		
 public  static void main(String[] args) {
        
        System.out.println("Try programiz.pro");
        
        int arr[] = {3,5,1,7,8,2,5,3,10,1,4,7,5,4,6};
        
        int k=4;
        
        int low=0;
        
        int high=0;
        
        int ans=0;
        
        // painter partition
        
        // find best case
        // if there are 15 painters as same number of boards
        for(int i=0;i<arr.length;i++){
            low=Math.max(arr[i],low);
        }
        
        // find worst case
        // if there is only 1 painter then he will paint all the boards
        for(int i=0;i<arr.length;i++){
            high=high+arr[i];
        }
        
        
        // we have minimise this time
        
        while(low<=high){
            
            int timeTaken=(low+high)/2;
            
            int totalPaintersRequired=isPossibleToCompleteInMidTime(arr,timeTaken);
            if(totalPaintersRequired<=k){
                
                ans=timeTaken;
                
                // reduce time
                high=timeTaken-1;
            }else{
                
                //increase time
                low=timeTaken+1;
            }
            
        }
        
        System.out.println(ans);
        
        
    }
    


public static int isPossibleToCompleteInMidTime(int[] arr,int timeTaken){
	
	int countPainters=1;
	
	int totalTimeTaken=0;
	
	for(int i=0;i<arr.length;i++){
		
		totalTimeTaken=totalTimeTaken+arr[i];
		
		// if the total time taken is exceeding the mid time
		if(totalTimeTaken > timeTaken){
			// then we have to increase painter to paint the whole items
			countPainters=countPainters+1;
			
			//now from 2nd painter he will take amount of time taken which is equal to the length of plank(item)
			totalTimeTaken=arr[i];
		}
	}
	
   return countPainters;

}



// Aggressive cows

 public  static void main(String[] args) {
        
        System.out.println("Try programiz.pro");
        
        int arr[] = {2,6,11,14,19,25,30,39,43};
        
        int cows=4;
        
        // if there are as many cows as no. of stalls
        // worst case ,cowsa are adjacent to each other ,
        int low=1;
        
        int high=0;
        
        int ans=0;
        
        // aggressive cows
        
        // find best case

        for(int i=0;i<arr.length;i++){
            
            // if there are only 2 cows
            // best case ,place them farthest at two ends
            high=arr[arr.length-1]-arr[0];
            
        }
        
        
        
        // we have maximise the distance between 2 adjaccent cows
        
    while(low<=high){
        
        int midDistance=(low+high)/2;
        
        int totalCowsRequired=isPossibleToPlaceAllCowsInMidDistance(arr,midDistance);
        
        if(totalCowsRequired>=cows){
            
            ans=midDistance;
            low=midDistance+1;
            
        }else{
            // reduce time
            high=midDistance-1;
            
        }
        
    }
    
    System.out.println(ans);
        
        
    }
    
    
    public static int isPossibleToPlaceAllCowsInMidDistance(int[] arr,int midDistance){
        
        // intitially number of cows is 1
        int numberOfcows=1;
        
        // ist cow is placed at ist stall// 0th index
        int positionOfCow=0;
        
        int distance=0;

        for(int i=1;i<arr.length;i++){
            
            
            distance=arr[i]-arr[positionOfCow];
            
            // if the distance is greater than mid
            if(distance > midDistance){
                // then we have to increase number of cows to cover whole stalls, then we have to increase the no. of cows
                numberOfcows=numberOfcows+1;
                
                //now from 2nd painter he will take amount of time taken which is equal to the length of plank(item)
                positionOfCow=i;
            }
        }
        
       return numberOfcows;
    
    }
	
	
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        int k=3;
        
        Node temp=head;
        
        for(int i=0;i<k;i++){
            
            temp=temp.next;
            
        }
        
        return temp.data;
        
        
        // to find the position of node in linked list
        
        int elementToFind=4;
        
        Node temp=head;
        
        int position=1;
        
        while(temp!=null){
            
            if(temp.data==elementToFind){
                return position; 
            }
            position+=1;
            temp=temp.next;
        }
		
		
		   // delete the node from linked list
        int deleteNode=4;
        
        if(head==null){
            return null;
        }    
            
        if(head.value==deleteNode){
            head=head.next;
            
            return head
        }
        
        Node curr=head;
        
        while(curr!=null){
            
            if(curr.next.data==deleteNode){
                curr.next=curr.next.next;
            }
            curr=curr.next;
            
        }
        
        return head;
		
		
		 // reverse the linked list
        
        
        if(head==null){
            return null;
        }    
            
        if(head.value==deleteNode){
            head=head.next;
            
            return head
        }
        
        Node temp=null;
        Node curr=head;
        Node previous=null;
        
        while(curr!=null){
            
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            
        }
        
        return head;
		
		// find mid point of the linked list
		
		slow=head;
		fast=head;
		
		while(fast.next!=null || fast.next.next != null){
			slow=slow.next;
			fast=fast.next.next;
			
		}
		
		return slow;
		
		
		//find the starting point of cycle
		// as we know x=z
		Node h1=head;
		Node h2=slow;
		
		while(h1!=h2){
			h1=h1.next;
			h2=h2.next;
		}
		
		return h1
		
		
		

    }
}



// Stacks

import java.util.*;


// valid parenthisis
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack 
            = new ArrayDeque<Character>(); 
        
        int N=s.length();

        for(int i=0;i<N;i++){

            char character = s.charAt(i); 
            
            if(character=='[' || character=='{' || character=='('){
                stack.push(character);
            }

            else{

                if( !stack.isEmpty() ){


                    if( character == ']' && stack.peek() != '[' ){
                        return false;
                    }
                    else if( character == ')' && stack.peek() != '(' ){
                        return false;
                    }
                    else if( character == '}' && stack.peek() != '{' ){
                        return false;
                    }       
                    else{
                        stack.pop();
                    }

                }

                else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
        
    }
}
















//binary tree

// invert binary tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {

        TreeNode leftChild=null;
        TreeNode rightChild=null;

        if(root == null){
            return root;
        }

        if(root.left != null){
           leftChild= invertTree(root.left);
        }

        if(root.right != null){
           rightChild= invertTree(root.right);
        }

        root.left=rightChild;
        root.right=leftChild;
        
        return root;
    }
}




2. root to leaf path sum exists

class Solution {
    boolean pathExistsInLeft=false;
    boolean pathExistsInRight=false;

    public boolean hasPathSum(TreeNode root, int targetSum) {


        if(root==null){
            return false;
        }

        if(root.left==null && root.right==null){
            if(targetSum-root.val==0){
                return true;
            }else{
                return false;
            }
        }

        if(root.left != null){
            pathExistsInLeft=hasPathSum(root.left,targetSum-root.val);
        }

        if(pathExistsInLeft){
            return true;
        }else{
            if(root.right != null){
                pathExistsInRight=hasPathSum(root.right,targetSum-root.val);
            }

            if(pathExistsInRight){
                return true;
            }else{
                return false;
            }
        }

        
        
    }
}

//connect nodes
class Solution {
    public Node connect(Node root) {
        
        if(root==null){
            return null;
        }
        
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;
        }

        if(root.next!=null){
            if(root.left!=null && root.right!=null && root.next.left!=null && root.next.right!=null){
                root.right.next=root.next.left;
            }
        }
        

        if(root.left!=null){
            connect(root.left);
        }

        if(root.right!=null){
            connect(root.right);
        }
        
        return root;
    }
}