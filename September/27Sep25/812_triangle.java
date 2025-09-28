package September.27Sep25;

public class 812_triangle {
    
}
class Solution {
    public double largestTriangleArea(int[][] points) {

        int n= points.length;

        double maxi=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){

                    int x1= points[i][0];
                    int y1= points[i][1];

                    int x2= points[j][0];
                    int y2= points[j][1];

                    int x3= points[k][0];
                    int y3= points[k][1];

                   double area = Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)) /2.0; 
// The difference in y-coordinates should follow a specific pattern (y2-y3, y3-y1, y1-y2)

                    maxi= Math.max(maxi,area);




                }
            }
        }
        return maxi;
        
    }
}