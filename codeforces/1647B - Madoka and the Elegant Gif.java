import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main{
    static long[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        out :
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
 
            int[][] map = new int[n][m];
 
            for(int i=0; i<n; i++){
                String str = br.readLine();
                for(int j=0; j<m; j++){
                    map[i][j] = str.charAt(j)-'0';
                }
            }
 
            for(int i=0; i<n-1; i++){
                for(int j=0; j<m-1; j++){
                    int one = 0;
                    int zero = 0;
 
                    for(int y=0; y<2; y++){
                        for(int x=0; x<2; x++){
                            int ny = i+y;
                            int nx = j+x;
                            if(ny<0 || nx<0|| ny>=n ||nx>=m) break;
 
                            if(map[ny][nx]==0)zero++;
                            else one++;
                        }
                    }
 
                    if(one==3 && zero==1){
                        System.out.println("No");
                        continue out;
                    }
                }
            }
            System.out.println("Yes");
 
        }
 
 
    }
 
}
