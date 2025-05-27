class Solution {
    /*TYPE: Dynammic Programming + Topo Sort + Cycle detection using Kahn's */
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        //note n= colors.length, not edges
        int n= colors.length();
        //topological sorted order mei indegree nikalni hoti hai 
        int indegree[]= new int[n];
        char color[]= colors.toCharArray();
        for(int i=0;i<n;i++) 
            adj.add(new ArrayList<>());

        for(int edge[]:edges){
            int u= edge[0],v=edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue= new LinkedList<>();
        //we have taken a 2d table to fill the states

        //dp[npde][color]=x , of all paths ending at node the max frequency of a color is x
        int dp[][]= new int[n][26];
        for(int i=0;i<n;i++){
            if(indegree[i]==0){ //jis jis ki indegree 0 hai, usko queue mei daal do
                queue.offer(i);
                dp[i][color[i]-'a']++;
            }
        }

        int ans=0;
        int countNodes=0; //aaccording to kahn's algorithm , if a cycle is present then atleast 1 node aisa hoga
                        //jo process ni hua hoga

        while(!queue.isEmpty()){
            int u= queue.poll();
            countNodes++;
            ans= Math.max(ans,dp[u][color[u]-'a']); //ans ko baar baar update karo
            for(int v:adj.get(u)){ ///check u's neighbour --> v
                for(int i=0;i<26;i++){ //v mei bhi, ye find karo ki max kiska hai
                    // already present hai wo max hai ya fir
                    //hum log u se aaye hai + v pe aaye hai, agar v ka color is i then add 1
                    dp[v][i]= Math.max(dp[v][i],dp[u][i]+(((color[v]-'a')==i)?1:0));
                }
                indegree[v]--;
                if(indegree[v]==0){
                    queue.offer(v);
                }
            }
        }
        //kahns algo mei agar cycle hogi to , ek node hymesha aisa hoga jo process nahi hua hoga..
        //hence countNodes<n condition
        return (countNodes<n)?-1:ans;   
    }
}