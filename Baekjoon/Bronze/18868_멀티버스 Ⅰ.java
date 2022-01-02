import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] uni = new int[M][N];



        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                uni[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for(int i=0; i<M; i++){//첫번째 우주
            out :
            for(int j=i+1; j<M; j++){ //두번째 우주
                if(i==j) continue;
                //행성 비교
                for(int k=0; k<N-1; k++){
                    for(int l=k+1; l<N; l++) {
                        if (uni[i][k] < uni[i][l] && uni[j][k] < uni[j][l]) {
                            continue;
                        }
                        if (uni[i][k] == uni[i][l] && uni[j][k] == uni[j][l]) {
                            continue;
                        }
                        if (uni[i][k] > uni[i][l] && uni[j][k] > uni[j][l]) {
                            continue;
                        }
                        continue out;
                    }
                }
                result++;
            }
        }

        System.out.println(result);



    }
}
