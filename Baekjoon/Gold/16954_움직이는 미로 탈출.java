import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[8][8];
        int wall = 0;
        for(int i=0; i<8; i++){
            String line = br.readLine();
            for(int j=0; j<8; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j]=='#') wall++;
            }
        }
        if(wall==0){
            System.out.println(1);
            return;
        }

        map[7][0] = 'M';
        int me = 1;
        int[] my = {-1,-1,-1,0,0,1,1,1};
        int[] mx = {-1,0,1,-1,1,-1,0,1};
        while(true){
            //이동
            boolean[][] visited = new boolean[8][8];
            for(int i=7; i>=0; i--){
                for(int j=0; j<8; j++){
                    if(map[i][j]!='M'||visited[i][j]) continue;

                    for(int k=0; k<8; k++){
                        int ny = i+my[k];
                        int nx = j+mx[k];

                        if(ny<0 || nx<0 || nx>=8 || ny>=8) continue;
                        if(map[ny][nx]=='#' || map[ny][nx]=='M') continue;

                        map[ny][nx] = 'M';
                        visited[ny][nx] = true;
                        me++;
                    }
                }
            }

            //벽 이동
            for(int i=7; i>=0; i--){
                for(int j=0; j<8; j++){
                    if(map[i][j] != '#') continue;

                    if(i==7){
                        map[i][j] = '.';
                        wall--;
                        continue;
                    }

                    map[i][j]='.';
                    if(map[i+1][j]=='M') me--;
                    map[i+1][j]='#';

                }
            }

            if(me==0){
                System.out.println(0);
                return;
            }
            if(wall==0){
                System.out.println(1);
                return;
            }

        }
    }
}
