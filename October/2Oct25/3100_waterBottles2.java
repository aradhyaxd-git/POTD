class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {

        int drank=0, empty=0;

        while(numBottles>0){
            while(numBottles>0 && empty<numExchange){
                drank++;
                empty++;
                numBottles--;
            }

            if(empty==numExchange){
                numExchange++;
                empty=0;
                numBottles++;
            }
        }
        return drank;
        
    }
}