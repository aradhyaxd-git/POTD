/*APPROACH -1 USING TWO STACKS */
class Solution1 {
    public boolean canBeValid(String s, String locked) {
        int n= locked.length();
        if(n%2!=0) return false;
        Stack<Integer> open= new Stack<>();
        Stack<Integer> open_close= new Stack<>();
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0'){
                open_close.push(i);
            }
            else if(s.charAt(i)=='('){
                open.push(i);
            }
            else if(s.charAt(i)==')'){
                if(!open.isEmpty())
                    open.pop();
                else if(!open_close.isEmpty())
                    open_close.pop();
                else 
                    return false;
            }
        }
        while(!open.isEmpty() && !open_close.isEmpty() && open.peek()< open_close.peek()){
            open.pop(); 
            open_close.pop();
        }

        if(!open.isEmpty())
            return false;
        return true;
    }
}

//APPROACH -2 USING TWO TIMES TRAVERSAL 
class Solution {
    public boolean canBeValid(String s, String locked) {
        int open=0,closed=0;
        int n= s.length();
        if(n%2!=0) return false;
        /*STEP 1 : Traverse from left to right and check the count of open */
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || locked.charAt(i)=='0')
                open++;
            else 
                open--;
            
            if(open<0) return false;
        }
         /*STEP 2 : Traverse from left to right and check the count of closed */
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==')' || locked.charAt(i)=='0')
                closed++;
            else
                closed--;
            if(closed<0) return false;
        }
        return true;
    }
}