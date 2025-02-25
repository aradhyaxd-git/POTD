//approach 1: TC: O(n3)
class Solution3 {
    final int mod= 1000000007;
    public int numOfSubarrays(int[] arr) {
      int count=0; int n= arr.length;
      for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
          int sum=0;
          for(int k=i;k<=j;k++){
            sum+= arr[k];
          }
          if(sum%2!=0){
            count++;
          }
        }
      }
      return count%mod;
    }
}

//appraoch 2: better O(n2)
class Solution2 {
    final int mod= 1000000007;
    public int numOfSubarrays(int[] arr) {
      int count=0; int n= arr.length;
      for(int i=0;i<n;i++){
        int sum=0;
        for(int j=i;j<n;j++){
          sum+=arr[j];
          if(sum%2!=0)
            count++;
        }
      }
      return count%mod;    
    }
}


/*APPROACH 3: USED SUBARRAY SUM DIVISBLE BY K TECHNIQUE 
  TC: O(N) */
class Solution1 {
    final int mod= 1000000007;
    public int numOfSubarrays(int[] arr) {
      int n= arr.length;
      long totalSubarrays = (long)n*(n +1)/2;
      //we will calculate the reminder which is divisble by 2
      int count=0;
      HashMap<Integer,Integer> map= new HashMap<>();
      map.put(0,1);
      int sum=0;
      for(int i=0;i<n;i++){
        sum+=arr[i];
        int remainder= sum%2;
        if(remainder<0){
          remainder+=2;
        }
        if(map.containsKey(remainder)){
          count= (count+map.get(remainder))%mod;
        }
        count= (count%mod)%mod;

        map.put(remainder,map.getOrDefault(remainder,0)+1);
      }
       return (int) (((totalSubarrays%mod-count+mod)%mod)%mod);
    }
}

/*APPROACH 4: USED PREFIX SUM AND CONCEPT THAT ODD+EVEN= ODD AND EVEN+ODD= ODD*/
class Solution4 {
  final int mod= 1000000007;
    public int numOfSubarrays(int[] arr) {
      int n= arr.length;
      int prefix[]= new int[n];
      prefix[0]=arr[0];
      for(int i=1;i<n;i++){
        prefix[i]=prefix[i-1]+arr[i];
      }
      int count=0,odd=0,even=1;
      for(int i=0;i<n;i++){
        if(prefix[i]%2==0) {
           //odd+even=odd
           count = (count+odd)%mod;
           even++;
        }
        else{ //even+odd=odd
          count = (count+even)%mod;
          odd++;
        }
      }
      return count;
    }
}

//APPROACH 5: MOST OPTIMAL, USED SUM INSTEAD OF PREFIXsum
class Solution {
  final int mod= 1000000007;
    public int numOfSubarrays(int[] arr) {
      int n= arr.length;
      int sum=0;
      int count=0,odd=0,even=1;
      for(int i=0;i<n;i++){
        sum+= arr[i];
        if(sum%2==0) {
           //odd+even=odd
           count = (count+odd)%mod;
           even++;
        }
        else{ //even+odd=odd
          count = (count+even)%mod;
          odd++;
        }
      }
      return count;
    }
}