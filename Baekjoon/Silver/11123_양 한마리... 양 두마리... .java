import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            char[][] map = new char[n][m];

            for(int i=0; i<n; i++){
                String str = br.readLine();
                for(int j=0; j<m; j++){
                    map[i][j] = str.charAt(j);
                }
            }

            int answer = 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j]=='.') continue;

                    answer ++;
                    dfs(i,j, map);

                }
            }

            System.out.println(answer);
        }

    }
    static int[] my = {1,-1,0,0};
    static int[] mx = {0,0,1,-1};
    private static void dfs(int y, int x, char[][] map) {
        map[y][x] = '.';

        for(int i=0; i<4; i++){
            int ny = y+my[i];
            int nx = x+mx[i];

            if(ny<0 || nx<0|| ny>=n || nx>=m) continue;
            if(map[ny][nx]=='.') continue;
            dfs(ny,nx,map);
        }
    }
}
