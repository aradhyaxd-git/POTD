/*2349. Design a Number Container System

Design a number container system that can do the following:

Insert or Replace a number at the given index in the system.
Return the smallest index for the given number in the system.

Implement the NumberContainers class:

NumberContainers() : Initializes the number container system.

void change(int index, int number) : Fills the container at index with the number
. If there is already a number at that index, replace it.

int find(int number) :Returns the smallest index for the given number, 
or -1 if there is no index that is filled by number in the system. */

class NumberContainers {
    HashMap<Integer,Integer> idxToNum= new HashMap<>();
    HashMap<Integer,TreeSet<Integer>> numToIdx= new HashMap<>();

    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        if(idxToNum.containsKey(index)){
            int prevNo= idxToNum.get(index);
            numToIdx.get(prevNo).remove(index);
            if(numToIdx.get(prevNo).isEmpty()){
                numToIdx.remove(prevNo);
            }
        }

        idxToNum.put(index,number);
        numToIdx.putIfAbsent(number,new TreeSet<>());
        numToIdx.get(number).add(index);
        
    }
    
    public int find(int number) {
        if(numToIdx.containsKey(number)){
            return numToIdx.get(number).first();
        }
        return -1;
        
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */