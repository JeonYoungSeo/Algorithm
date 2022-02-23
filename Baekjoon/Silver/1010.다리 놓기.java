import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] tri = new int[31][31];

        for(int y=1; y<31; y++){
            for(int x=1; x<=y; x++){
                if(x==1){
                    tri[y][x] = 1;
                    continue;
                }

                tri[y][x] = tri[y-1][x-1]+tri[y-1][x];
            }
        }

        while(T-->0){
            int n,m;

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            System.out.println(tri[m+1][n+1]);

        }



        bw.flush();
        bw.close();
        br.close();
    }

}


