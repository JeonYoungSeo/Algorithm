class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        
        out : 
        for(int i=0; i<5; i++){
            for(int y=0; y<5; y++){
                for(int x=0; x<5; x++){
                    if(places[i][y].charAt(x)=='P')
                      answer[i] = dfs(y,x,0,0,places[i]);
                    if(answer[i] == 0){
                        System.out.println(y+" "+x);
                        continue out;
                    }
                }
            }
        }
        
        return answer;
    }
    
    static int[] my = {-1,0,1,0};
    static int[] mx = {0,-1,0,1};
    
    public static int dfs(int y, int x, int dist,int from, String[] seat){
        if(seat[y].charAt(x)=='X') return 1;
        if(dist>0 && seat[y].charAt(x)=='P')
            return 0;
        if(dist==2) return 1;

        int answer = 1;
        if(dist == 0){
            for(int i=0; i<4; i++){
                int ny = y+my[i];
                int nx = x+mx[i];

                if(ny<0 || nx<0 || ny>=5 || nx>=5) continue;

                answer = dfs(ny,nx, dist+1, i, seat);

                if(answer==0) return 0;
            }
        }else{
            for(int i=0; i<4; i++){
                if(i==((from+2)%4)) continue;
                int ny = y+my[i];
                int nx = x+mx[i];

                if(ny<0 || nx<0 || ny>=5 || nx>=5) continue;

                answer = dfs(ny,nx, dist+1, i, seat);

                if(answer==0) return 0;
            }
        }

        return answer;
    }
}
