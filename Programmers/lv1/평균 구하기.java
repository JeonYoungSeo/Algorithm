class Solution {
    public double solution(int[] arr) {
        int len = arr.length;
        
        double sum = 0;
        
        for(int i=0; i<len; i++){
            sum+= arr[i];
        }
        
        return sum/len;
    }
}
