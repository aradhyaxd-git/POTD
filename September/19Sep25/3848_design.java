class Spreadsheet {
    Map<String,Integer> sheet;
    int rows;

    public Spreadsheet(int rows) {
       sheet= new HashMap<>();
       this.rows=rows;
    }
    
    public void setCell(String cell, int value) {
        sheet.put(cell,value);     
    }
    
    public void resetCell(String cell) {
        sheet.put(cell,0);
    }
    
    public int getValue(String formula) {

        //="5+7"
        String s= formula.substring(1);
        String st[]= s.split("\\+");
        int sum=0;

        for(String p:st){

                if(Character.isDigit(p.charAt(0))){
                    sum+= Integer.parseInt(p);
                }
                else
                    sum+=sheet.getOrDefault(p,0);
        } 
        return sum;       
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */