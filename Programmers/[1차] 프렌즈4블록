class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        boolean end = false;
        
        while(!end){
            end = true;
            boolean[][] boom = new boolean[m][n];
            //검사 
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(map[i][j]==' ') continue;
                    if((map[i][j]==map[i][j+1])&&(map[i][j]==map[i+1][j])&&(map[i+1][j+1]==map[i+1][j])){
                        boom[i][j] = true;
                        boom[i+1][j] = true;
                        boom[i][j+1] = true;
                        boom[i+1][j+1] = true;
                        end = false;
                    }
                }
            }
            if(end) break;
            //없애고 내리기
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(boom[i][j]){
                        answer ++;
                        if(i==0){
                            map[i][j] = ' ';
                            continue;
                        }
                        map[i][j] = map[i-1][j];
                        map[i-1][j] = ' ';
                    }
                }
            }
            //위에 잔여물 내리기
            for(int i=m-2; i>=0; i--){
                for(int j=0; j<n; j++){
                    if(map[i][j]!=' ' && map[i+1][j]==' '){
                        int height = i+1;
                        while(height<m && map[height][j]==' '){
                            height++;
                        }
                        height--;
                        map[height][j] = map[i][j];
                        map[i][j] = ' ';
                    }
                }
            }
        }
        
        return answer;
    }
}
