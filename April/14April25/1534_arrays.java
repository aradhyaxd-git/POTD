class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n=arr.length;
        int triplets=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(Math.abs(arr[i]-arr[j])<=a && Math.abs(arr[k]-arr[j])<=b && Math.abs(arr[i]-arr[k])<=c ){
                        triplets++;
                    }
                }
            }
        }
        return tripets;
    }
}