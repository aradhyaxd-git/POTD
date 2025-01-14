/*APPROACH-1 , WE TOOK 2 BOOLEAN ARRAYS, FOR EACH INDEX 
    1) mark A[i]= true  mark B[i]=true;
    2) now from the starting check if both
        boolean arrays are marked true; 
        -> if yes , increase the count
        -> if no, eat five star
        */
        class Solution2 {
            public int[] findThePrefixCommonArray(int[] A, int[] B) {
                int n= A.length;
                boolean isPresentA[]= new boolean[n+1];
                boolean isPresentB[]= new boolean[n+1];
                int C[]= new int[n];
                for(int i=0;i<n;i++){
                    int a= A[i]; int b= B[i];
                    isPresentA[a]=true;
                    isPresentB[b]=true;
                    int count=0;
                    for(int j=1;j<=n;j++){
                        if(isPresentA[j]== true && isPresentB[j]==true)
                            count++;
                    }
                    C[i]=count;
                }
                return C;
            }
        }
        
        /*APPROACH -2 We Somehow figured out, that every element 
                    occures at most twice, therefore:
                    1) We used a freq array , and incremented frequency of each
                    character of A[i] and B[i] by one
                    2) by using a supplementary function, we found all of the frequencies
                    which are updated upto 2 
                    we store the result in C[i]
                    */
        class Solution1 {
            public int countFreq(int freq[]){
                int n= freq.length; int count=0;
                for(int i=0;i<n;i++){
                    if(freq[i]==2)
                        count++;
                }
                return count;
            }
            public int[] findThePrefixCommonArray(int[] A, int[] B) {
                int count=0;
                int n= A.length;
                int C[]= new int[n];
                int freq[]= new int[n+1];
                for(int i=0;i<n;i++){
                    int a= A[i], b= B[i];
                    freq[a]++; freq[b]++;
                    C[i]= countFreq(freq);
                }
                return C;  
            }
        }
        
        /*Approach-3  Since we figured it out that , all the elements occur
                       atmost twice, then there is no use of an external function
                    1) use a hashmap instead: and increment frequency by 1
                    2) when frequency reached 2 : we inrement the counter
                    */
        class Solution3 {
            public int[] findThePrefixCommonArray(int[] A, int[] B) {
                int count=0;
                int n= A.length;
                int result[]= new int[n];
                HashMap<Integer,Integer> map= new HashMap<>();
                for(int i=0;i<n;i++){
                    map.put(A[i],map.getOrDefault(A[i],0)+1);
                    if(map.get(A[i])==2) count++;
                    map.put(B[i],map.getOrDefault(B[i],0)+1);
                    if(map.get(B[i])==2) count++;
                    result[i]=count;
                }
                return result;
            }
        }
        //BETTER ALTERNATIVE
        class Solution {
            public int[] findThePrefixCommonArray(int[] A, int[] B) {
                int n=A.length;
                int[] freq=new int[n+1];
                int[] result=new int[n];
                int count=0;
                for(int i=0;i<n;i++)
                {
                    if(++freq[A[i]]==2)
                    count++;
                    if(++freq[B[i]]==2)
                    count++;
                    result[i]=count;
                }
                return result;
            }
        }