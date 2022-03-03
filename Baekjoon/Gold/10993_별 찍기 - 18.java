import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int r = 1;
        for(int i=2; i<=N; i++){
            r = r*2+1;
        }
        int c = r*2-1;

        char[][] map = new char[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                map[i][j] = ' ';
            }
        }
        star(N,(N%2==0)?r-1:0,c/2,r-1,map);
        StringBuilder result = new StringBuilder();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == '\n'){
                    break;
                }
                result.append(map[i][j]);
            }
            result.append("\n");
        }

        System.out.println(result);

    }

    private static void star(int n, int r, int c,int size, char[][] map) {
        if(n==0){
            return;
        }

        int ns = size;
        int nr = r;
        int nc = c;
        int cnt = 0;
        if(n%2==0){
            while(ns-->=0){
               map[nr][nc+cnt] = '*';
               map[nr][nc-cnt] = '*';
                if(n==N && (nc+cnt+1<map[0].length)){
                    map[nr][nc+cnt+1] = '\n';
                }
               cnt++;
               nr--;
            }
            nr++;
            cnt--;
            for(int i=nc-cnt; i<=nc+cnt; i++){
                map[nr][i]= '*';
            }
            nr++;
        }else{
            while(ns-->=0){
                map[nr][nc+cnt] = '*';
                map[nr][nc-cnt] = '*';
                if(n==N && (nc+cnt+1<map[0].length)){
                    map[nr][nc+cnt+1] = '\n';
                }
                cnt++;
                nr++;
            }
            nr--;
            cnt--;
            for(int i=nc-cnt; i<=nc+cnt; i++){
                map[nr][i]= '*';
            }
            nr--;
        }

        star(n-1, nr, c, (size-1)/2,map);

    }
}
