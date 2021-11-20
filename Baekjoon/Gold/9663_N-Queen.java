import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];

        System.out.println(queen(0));


    }

    private static int queen(int n) {
        if(n==N){
            return 1;
        }

        int result = 0;

        for(int i=0; i<N; i++){
            boolean check = true;
            int tempN = n;
            int dif = 0;
            while(tempN>=0){
                if(map[tempN][i]) check = false;
                if(i+dif<N){
                    if(map[tempN][i+dif]) check = false;
                }
                if(i-dif>=0){
                    if(map[tempN][i-dif]) check = false;
                }
                if(!check) break;

                tempN--;
                dif++;
            }

            if(!check) continue;

            map[n][i] = true;
            result += queen(n+1);
            map[n][i] = false;

        }

        return result;
    }

}
