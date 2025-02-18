/*2364. Count Number of Bad Pairs

You are given a 0-indexed integer array nums. 
A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].

Return the total number of bad pairs in nums.

 

Example 1:

Input: nums = [4,1,3,3]
Output: 5
Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
There are a total of 5 bad pairs, so we return 5. */

//APPROACH 1: SIMPLE MAHA BRUTEFORCE
class Solution1 {
    public long countBadPairs(int[] nums) {
        long count=0; int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(j-i!=(nums[j]-nums[i])){
                    count++;
                }
            }
        }
        return count;
    }
}

/*APPROACH 2: INTUTION BUILDING
 NOTE: in the kind of questions where the relation b/w indexes is given we interchange and 
 try to make them kind of same side
        Here, j-i != nums[j]- nums[i]
            ->   nums[i]-i  != nums[j]-j
            eg: {4,1,3,3}  -> do nums[i]-i in each case
                -> {4,0,1,0}
                Now We have to store bad pairs.. where nums[i]-i != nums[j]-j
                        Take A hashmap, now if the key is already in hashmap
                        it means it is repeated... and cannot make a bad pair
                start from j=0
                TOTAL_NO_BEFORE_J= j
                if we have nums[j] in the map then we store how many time it occured

                actual bad pair= TOTAL_NO_BEFORE_J - Who occured previously 
                */
class Solution {
    public long countBadPairs(int[] nums) {
        long count=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            nums[i]= nums[i]-i;
        }
        while(j<nums.length){
            int countFreq=0;
            int totalNoBefore= j;
            if(map.containsKey(nums[j])){
                countFreq= map.get(nums[j]);
            }
            int badPairs= totalNoBefore-countFreq;
            count+=badPairs;
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            j++;
        }
        return count;
    }
}

//Approach 3: Similar Approach. Just counted good pairs, then minus with total pairs-goodpairs= bad pairs

class Solution2 {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long count=0;
        for(int i=0;i<nums.length;i++){
            int diff= nums[i]-i;
            int goodpairs=0;
            if(map.containsKey(diff)){
                goodpairs= map.get(diff);
            }
            int totalPairs=i;
            count+=(totalPairs-goodpairs);
            map.put(diff,map.getOrDefault(diff,0)+1);

        }
        return count;
        
    }
}