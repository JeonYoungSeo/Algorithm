import java.io.*;
import java.util.*;

public class Main {
    static int N ;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        System.out.println(func(0,0,0));

    }

    private static int func(int pre,int curr, int n) {
        if(n==3){
            return 1;
        }
        int result = 0;
        for(int i=curr+1; i<=N; i++){
            if (n != 0) {
                if (arr[curr][i] == 1 || arr[pre][i] == 1) continue;
            }
            result += func(curr,i,n+1);
        }
        return result;
    }
}
