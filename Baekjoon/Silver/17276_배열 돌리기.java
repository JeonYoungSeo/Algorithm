import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            M = M/45;
            if(M>4) M = M-8;
            if(M<-4) M = 8+M;
            while(M!=0){
                int pos = 0;
                while(pos<=N/2) {
                    if (M > 0) {
                        int tmp = map[pos][pos];
                        map[pos][pos] = map[N/2][pos];
                        map[N/2][pos] = map[N-pos-1][pos];
                        map[N-pos-1][pos] = map[N-pos-1][N/2];
                        map[N-pos-1][N/2] = map[N-pos-1][N-pos-1];
                        map[N-pos-1][N-pos-1] = map[N/2][N-pos-1];
                        map[N/2][N-pos-1] = map[pos][N-pos-1];
                        map[pos][N-pos-1] = map[pos][N/2];
                        map[pos][N/2] = tmp;
                    } else {
                        int tmp = map[pos][pos];
                        map[pos][pos] = map[pos][N/2];
                        map[pos][N/2] = map[pos][N-pos-1];
                        map[pos][N-pos-1] = map[N/2][N-pos-1];
                        map[N/2][N-pos-1] = map[N-pos-1][N-pos-1];
                        map[N-pos-1][N-pos-1] = map[N-pos-1][N/2];
                        map[N-pos-1][N/2] = map[N-pos-1][pos];
                        map[N-pos-1][pos] = map[N/2][pos];
                        map[N/2][pos] = tmp;
                    }
                    pos++;
                }
                if(M<0) M++;
                else M--;

            }

            for(int[] line : map){
                for(int n : line){
                    answer.append(n+" ");
                }
                answer.append("\n");
            }
        }

        System.out.println(answer);

    }
}
