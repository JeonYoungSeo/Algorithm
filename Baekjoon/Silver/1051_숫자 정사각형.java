import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-48;
            }
        }

        int result = 1;

        for(int i=0; i<N; i++){
            if(result>N-i)
                continue;
            for(int j=0; j<M; j++){
                if(result>M-j) continue;

                int curr = map[i][j];

                int size = 0;

                while(true){
                    size++;
                    if(size>=N-i || size>=M-j) break;
                    if(map[i][j+size]!=curr || map[i+size][j]!=curr || map[i+size][j+size]!=curr){
                        continue;
                    }

                    result = Math.max(result,size+1);

                }

            }
        }

        System.out.println(result*result);

    }
}
