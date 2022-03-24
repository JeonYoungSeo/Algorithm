class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int len = s.length();
        
        for(int i=0; i<len; i++){
            char curr = s.charAt(i);
            
            if(curr-'0'<10){
                answer.append((char)curr+"");
                continue;
            }
            
            switch(curr){
                case 'z':
                    i+=3;
                    answer.append("0");
                    continue;
                case 'o':
                    i+=2;
                    answer.append("1");
                    continue;
                case 't':
                    if(s.charAt(i+2)=='o'){
                        i+=2;
                        answer.append("2");
                    }else{
                        i+=4;
                        answer.append("3");
                    }
                    continue;
                case 'f' :
                    if(s.charAt(i+3)=='r'){
                        i+=3;
                        answer.append("4");
                    }else{
                        i+=3;
                        answer.append("5");
                    }
                    continue;
                case 's' :
                    if(s.charAt(i+2)=='x'){
                        i+=2;
                        answer.append("6");
                    }else{
                        i+=4;
                        answer.append("7");
                    }
                    continue;
                case 'e' :
                    i+=4;
                    answer.append("8");
                    continue;
                case 'n' :
                    i+=3;
                    answer.append("9");
                    continue;
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
}
