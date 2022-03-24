class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] dist = new int[10][10];
        
        int left = 10;
        int right = 12;
        
        StringBuilder answer = new StringBuilder();
        
        for(int number : numbers){
            if(number==0){
                number = 11;
            }
            if(number == 1 || number == 4 || number == 7){
                left = number;
                answer.append("L");
            }
            else if(number == 3 || number == 6 || number == 9){
                right = number;
                answer.append("R");
            }else{
                int leftDist = Math.abs(left%3-number%3)+Math.abs(left/3-number/3);
                int rightDist = Math.abs((right-1)%3-(number-1)%3)+Math.abs((right-1)/3-(number-1)/3);
                
                if(leftDist<rightDist){
                    left = number;
                    answer.append("L");
                }else if(leftDist>rightDist){
                    right = number;
                    answer.append("R");
                }else{
                    if(hand.equals("right")){
                        right = number;
                        answer.append("R");
                    }else{
                        left = number;
                        answer.append("L");
                    }
                }
            }
        }
        return answer.toString();
        
    }
}
