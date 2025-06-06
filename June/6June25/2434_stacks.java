class Solution {
    //it is a greedy montonic type stack here 

    /*My earlier intution was 
    eg: s= bac 
    --> stack for t and stringBuilder as p
    --> intially ye socha ki, jaise hi chota character aya stack mei, to usko stack mei dalke
            ---> pura stack khali karke , pop() kardo and store in stringBuilder

    BUT THAT WAS WRONG BECAUSE WE DONT KNOW ABOUT THE FUTURE --> AAGE AUR CHOTE ELEMENTS AA SAKTE HAI

    WHAT WE DID ??
    --> Frequency store karli saare elements ki phele se hi 
        --> This helped to create lexicographically smallest string */
    public String robotWithString(String s) {
        Stack<Character> st= new Stack<>();
        StringBuilder res= new StringBuilder();
        int n= s.length();
        int freq[]= new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i=0;i<n;i++){
            char ch= s.charAt(i);
            st.push(ch); //stack mei daaal do and frequency ghata do
            freq[ch-'a']--;

            //jab tak stack khali nahi hai, and , agar future mei koi character na mile
                //--> tab tak result mei append kardo
            while(!st.isEmpty() && !hasSmaller(st.peek(),freq)){ //note yaha pe, st.peek() hoga humesha
                res.append(st.pop());
            }
        }
            //incase stack mei kuch bacha ho, badi values --> sab res mei append kardo
        while(!st.isEmpty()) res.append(st.pop());
        return res.toString();
        
    }

    //this function helps to find, agar future mei humko smaller characters milengay ya nahi
    //we start and go till ch-'a; because --> lexicographically smallest to whi se milegnay 
    public boolean hasSmaller(char ch, int freq[]){
        for(int i=0;i<ch-'a';i++){
            if(freq[i]>0){//agar future mei koi element hai, jiski freq 1 ya usse jyada hai to
                            //lexicographically smallest bana sakte hai
                return true;
            }
        }
        return false;
    }
}