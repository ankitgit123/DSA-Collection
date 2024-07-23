// Online Java Compiler
// Use this editor to write, compile and run your Java code online


//Hashing

import java.util.*;



class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        int[] arr={4,0,7,9,8,5,8};
        
        int K=10;
        
        boolean flag=false;
        
        int n = arr.length;
        
        HashSet<Integer> hashSet = new HashSet<Integer>();
        
        for(int i = 0 ; i<n ; i++){
            
            int num=K-arr[i];
            
            if(hashSet.contains(num)){
                
                flag=true;
            
                
            }else{
                hashSet.add(arr[i]);
            }
        }
        
        
        System.out.println(flag);


    }
}


// count of pairs of sum equal to k
        
int[] arr={2,4,2,5,8,5,4,8};

int K=9;

int n = arr.length;

int count=0;

//HashMap<Integer,Integer> hashMap = new Map<Integer,Integer>();
HashMap<Integer, Integer> hashMap = new HashMap<>();

for(int i = 0 ; i<n ; i++){
	
	int num=K-arr[i];
	
	if( !hashMap.containsKey(arr[i]) ){
		
		hashMap.put(arr[i],1);
		
	}else{
		int frequency=hashMap.get(arr[i]);
		
		frequency=frequency+1;
		
		hashMap.put(arr[i],frequency);
		
	}
	
	
	if(hashMap.containsKey(num)){
		count=count+hashMap.get(num);
	}
}

        
        
2 pointers

System.out.println("Try programiz.pro");
        
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; 
        int N = arr.length;
        
        int left_max=0;
        int right_max=0;
        
        int left=0;
        int right=N-1;
        
        int totalWaterStored=0;
        
        while(left<=right){
            
            
            
            if(left_max>=right_max){
                
                // then we need to find the difference of current index and max
                
                int waterTrapped = right_max-arr[right];
                
                if(waterTrapped>0){
                    totalWaterStored=totalWaterStored+waterTrapped;
                }
                
                right_max=Math.max(right_max,arr[right]);
                
                right=right-1;
                
            }else{
                
                int waterTrapped = left_max-arr[left];
                
                if(waterTrapped>0){
                    totalWaterStored=totalWaterStored+waterTrapped;
                }
                
                left_max=Math.max(left_max,arr[left]);
                
                left=left+1;
                
            }
        }
        
System.out.println(totalWaterStored+"answer");


//is sum present

int arr[] = { 1,2,3,4,5 }; 
int N = arr.length;

int K=10;

int left=0;

int right=N-1;

boolean isSumPresent=false;

while(left<right){
	int sum = arr[left]+arr[right];
	
	if(sum == K){
		
		System.out.println(left+""+right);
		
		isSumPresent= true;
		break;
		
	}else{
		
		if(sum < K){
			
			 left=left+1;
		}else{
			 right=right-1;
		}
		
	}
	
}

System.out.println(isSumPresent+" answer");

// count pairs of given sum

 int arr[] = { 1,2,3,4,5,6,7,8 }; 
        int N = arr.length;
        
        int K=10;
        
        int left=0;
        
        int right=N-1;
        
        int  count=0;
        
        while(left<right){
            int sum = arr[left]+arr[right];
            
            if(sum == K){
                
                //System.out.println(left+""+right);
                
                count= count+1;
                
                left=left+1;
                right=right-1;
                
                continue;
                
            }else{
                
                if(sum < K){
                    
                     left=left+1;
                     
                }else{
                    
                     right=right-1;
                     
                }
                
            }
            
        }
        
        System.out.println(count+" answer");
		
 
  // subarray  present having sum ==K
		
  int arr[] = { 1,3,15,10,20,3,23,33,43}; 
        int N = arr.length;
        
        int K=33;
        
        int left=0;
        
        int right=0;
        
        int sum=arr[0];
        
        boolean  isSubArrayPresent=false;
        
        while(right<N){
            
            
            if(sum == K){
                isSubArrayPresent=true;
                break;
                
            }else{
                
                if(sum < K){
                     right=right+1;
                     sum=sum+arr[right];
                     
                     
                }else{
                    
                     sum=sum-arr[left];
                     left=left+1;
                     
                }
                
            }
            
            
            
        }
        
        System.out.println(isSubArrayPresent+" isSubArrayPresent");
		

// 3 sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> arr = new ArrayList<Integer>();

        Arrays.sort(nums);

        int i=0;
        while(i<nums.length-2){

            if(i>0 && nums[i]==nums[i-1]){
                i++;
            }else{
                int j=i+1;
                int k=nums.length-1;

                while(j<k){
                
                    int sum=nums[i]+nums[j]+nums[k];

                    if(sum==0){
                        
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));

                        while(j<k && nums[j]==nums[j+1]){
                            j++;
                        }

                        while( j<k && nums[k]==nums[k-1]){
                            k--;
                        }

                        j++;
                        k--;

                    }
                    else if(sum>0){
                        k--;
                    }else{
                        j++;
                    }
            }
            i++;
            }

            
        } 

        return result;
        
    }
}