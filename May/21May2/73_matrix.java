/*POTD: 21 MAY 2025 
Approach 1: 
                2 Pass 

TC: O(M*N) SC: O(M+N)

--> make a rowFlag and colFlag arrays 
--> jaha jis bhi row mei ya column mei 0 aa raha hai, usko true mark kardo

--> dusre pass mei ,  jaha jaha hai ya to column ya row waha par 0 mark kardo */
class Solution1 {
    public void setZeroes(int[][] matrix) {
        int n= matrix[0].length;
        int m= matrix.length;
        boolean rowFlag[]= new boolean[m];
        boolean colFlag[]= new boolean[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowFlag[i]=true;
                    colFlag[j]=true;
                }
            }
        }

        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowFlag[i] || colFlag[j]){
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}


/*Approach 2:  SC: O(1)

The main concept lying here is to use first row and first column as markers

--> Phele check karo variables se se ki firstRow ya firstColumn mei zero hai ya nahi --> Zero hai to seedha break krdo
--> use first Row and Column as markers 
--> fir set Zero based on those markers

--> at,last check if firstRow or firstColumn has 0
                ---> row Mei hai to column se zero karo
                ---> column mei hai to row se zero karo */

class Solution {
    public void setZeroes(int[][] matrix) {
        int n= matrix[0].length;
        int m= matrix.length;

        boolean hasFirstRowZero=false;
        boolean hasFirstColumnZero=false;

      
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][0]==0)
                    hasFirstColumnZero=true;
            }
        }



        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[0][j]==0){
                    hasFirstRowZero=true;
                }
            }
        }


        //now mark zero 
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 ||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(hasFirstRowZero){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }

        if(hasFirstColumnZero){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }

    }
}




//approach 3: strivers jaisi 
class Solution2 {
    public void setZeroes(int[][] matrix) {//order m*n
    int m= matrix.length;
    int n= matrix[0].length;
    int col0=1;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==0){
                matrix[i][0]=0;
                if(j!=0){
                    matrix[0][j]=0;
                }
                else{
                    col0=0;
                }
            }
        }
    }
    //step 2: update the inner matrix: (1,1) to (m-1,n-1)
    for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
            if(matrix[i][0]==0 || matrix[0][j]==0){
                matrix[i][j]=0;
            }
        }
    }

    //step 3: update first row if needed
    if(matrix[0][0]==0){
        for(int j=0;j<n;j++){
            matrix[0][j]=0;
        }
    }

    //step4 : update first column if needed

    if(col0==0){
        for(int i=0;i<m;i++){
            matrix[i][0]=0;
        }
    }
    }
}









