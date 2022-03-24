class Solution {
    public String solution(String new_id) {
    
        //1단계 소문자화
        new_id = new_id.toLowerCase();
        //2단계 특수문자 제거
        new_id = new_id.replaceAll("[^a-zA-Z0-9_.-]","");
        //3단계 중복 점 제거
        new_id = new_id.replaceAll("[.]+",".");
        //4단계 처음 마지막 마침표 제거
        if(new_id.charAt(0)=='.')
            new_id = new_id.substring(1);
        int len = new_id.length();
        if(len!=0){
            if(new_id.charAt(len-1)=='.')
            new_id = new_id.substring(0,len-1);
        }
        
        //5단계
        if(new_id.length() == 0){
            new_id = "a";
        }
        //6단계
        if(new_id.length() > 15){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1)=='.')
                new_id = new_id.substring(0,new_id.length()-1);
        }
        
        // //7단계
        if(new_id.length() <3){
            char str = new_id.charAt(new_id.length()-1);
            while(new_id.length() <3){
                new_id = new_id+str;
            }
        }
        

            
        return new_id;
    }
}
