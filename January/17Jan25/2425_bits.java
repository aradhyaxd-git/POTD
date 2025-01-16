/* PROBLEM STATEMENT:
You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers.
 There exists another array, nums3, which contains the bitwise XOR of all pairings of integers 
 between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).
Return the bitwise XOR of all integers in nums3. */


//APPROACH:1 BRUTEFORCE: jO BOLA HAI WAHI KARDO
class Solution2 {
    public int findXor(int x, int[]nums2){
        List<Integer> list= new ArrayList<>();
        for(int num:nums2){
            list.add(x^num);
        }
        int ans=0;
        for(int num:list){
            ans ^=num;
        }
        return ans; 
    }
    public int xorAllNums(int[] nums1, int[] nums2) {
        int result=0;
        for(int num:nums1){
            result ^= findXor(num,nums2);
        }
        return result;     
    }
}

//APPROACH:2 
class Solution1 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        /* nums1= {a,b,c} ->m
           nums2= {d,e} ->n
           a occurs twice, lly b,c ie. n times
           d,e occurs m times;
           We know the property of XOR:
           ->Even wale cancel hojayengay
           -> Odd wale rahengay
        */
        HashMap<Integer,Integer> map= new HashMap<>();
        int m= nums1.length;
        int n= nums2.length;
        /*In this approach, we take a map, and put for num1, put everything n times
                            for num2, put everything m times
        Then,
         -> WE only xor the frequencies which are odd, since the even ones will get cancelled */
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+n);
        }
        for(int num:nums2){
            map.put(num,map.getOrDefault(num,0)+m);
        }
        int res=0;
        for(int num: map.keySet()){
            if(map.get(num) % 2 !=0){
                res ^=num;
            }
        }
        return res;
    }
}

//APPROACH: 3 (OPTIMAL)

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n= nums2.length;
        int res=0;
        /*Since, from the previous approach, we already know the stuffs,
                 So, basically, here we check which array occur even time and
                 which occur odd times */

        if(m%2!=0){
            for(int num: nums2)
                res ^= num;
        }

        if(n%2!=0){
            for(int num: nums1)
                res ^=num;
        }
        return res;
    }
}