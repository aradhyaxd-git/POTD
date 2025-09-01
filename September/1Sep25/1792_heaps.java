class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for(int i=0;i<n;i++){
            double currPassRatio= (double) classes[i][0]/classes[i][1];
            double newPassRatio= (double)(classes[i][0]+1)/(classes[i][1]+1);
            double increment= newPassRatio-currPassRatio;
            pq.offer(new double[]{increment,i});
        }
        while(extraStudents-- !=0){
            double find[]=pq.poll();
            int index= (int)(find[1]);
            classes[index][0]++;
            classes[index][1]++;
            double currPassRatio= (double) classes[index][0]/classes[index][1];
            double newPassRatio= (double)(classes[index][0]+1)/(classes[index][1]+1);
            double increment= newPassRatio-currPassRatio;
            pq.offer(new double[]{increment,index});
        }
        double result=0.0;
        for(int i=0;i<n;i++){
            result+= (double)(classes[i][0])/(classes[i][1]);
        }
        return result/n;
    }
}