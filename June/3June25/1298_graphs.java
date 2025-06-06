class Solution {
    //Companies asked: Airbnb
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n= status.length;
        int totalCandies=0;
        boolean visited[]= new boolean[n]; //to check ki kisi box ko dobara se visited na kar sake
        boolean foundBox[]= new boolean[n]; // agar koi box hum logo ko inside containedBoxes mila hai, to atleast usko true mark kar sake
                                            // kyuki, bhale hi agar humare pass kisi box ki chabhi present hai 
                                            // but wo box mila nahi hai--> we cannot open it
                                                //--> therefore, we store this foundBox array , just to make sure, about what all boxes we have found so far

        for(int box: initialBoxes){//iterate in initialBoxes kyuki inhi boxes se hum log dfs kar sakte hai, into each depth
            totalCandies+= dfs(box,status,candies,keys,containedBoxes,initialBoxes,visited,foundBox);
        }
        return totalCandies;
    }


    public int dfs(int box,int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes , boolean visited[], boolean foundBox[]){
        if(visited[box]) return 0; //agar box ko phele hi visited kar chuke hai --> seedha return 0
        if(status[box]==0){ ///agar box locked hai, means uska status 0 hai --> return 0
            ///--> but the noteWorthy point is, we have found the box, to agar chabhi milegi iski kabhi baad mei --> to isko khol sakte hai
                        ///---> hence, we will mark this as true
            foundBox[box]=true;
            return 0;
        }
        //box ko visited mark karo, and uske andar jitni candies thi sab utha lo 
        visited[box]=true;
        int candiesCollected= candies[box];

    //now, we will check inside our , containedBoxes ki, is box mei kitne aur boxes hai-->  and uspe dfs marengay
        for(int insideBox: containedBoxes[box]){
            candiesCollected+= dfs(insideBox,status,candies,keys,containedBoxes,initialBoxes,visited,foundBox); 
        }

        //now, also, us same box mei agar, koi key mili hum logo ko --> to uska status hum log 1 krdengay --> key mil gyi hai
            // now, since box bhi hai and chabhi bhi mil gayi --> dfs maar do uspe
        for(int boxKey: keys[box]){
            status[boxKey]=1;
            if(foundBox[boxKey]==true){
                candiesCollected+= dfs(boxKey,status,candies,keys,containedBoxes,initialBoxes,visited,foundBox);
            }

        }
        return candiesCollected;
        
    }
}