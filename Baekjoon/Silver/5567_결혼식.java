import java.util.*;
import java.io.*;


public class Main
{

    static int n ;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] conn = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            conn[a][b] = 1;
            conn[b][a] = 1;
        }

        boolean[] result = new boolean[n+1];
        result[1] = true;
        check(0,1,conn,result);

        int cnt = 0;
        for(int i=2; i<=n; i++){
            if(result[i]){
                cnt++;
            }
        }

        System.out.println(cnt);


    }

    private static void check(int connect, int num,int[][] conn, boolean[] result) {

        for(int i=1; i<=n; i++){
            if(conn[num][i] == 1 ) {
                result[i] = true;
                if(connect == 0) {
                    check(1, i, conn, result);
                }

            }
        }
    }
}
