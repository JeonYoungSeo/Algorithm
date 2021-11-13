import java.io.*;
import java.util.StringTokenizer;

/* 
* 백준 2116 : 주사위 각면이 바닥,천장일때 가장 높게 나올수 있는 수를 따로 저장하여 시간을 줄여 주었다. 
* 
*/

public class Main {
    static int[][] dice, max;
    static int result, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dice = new int[N][6];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = new int[N][6];

        for(int i=0; i<N; i++){
            int Max = 0;
            for(int j=1; j<5; j++){
                Max = Math.max(Max, dice[i][j]);
            }

            max[i][0] = max[i][5] = Max;

            Max = 0;

            int[] arg = {0,2,4,5};

            for(int j : arg){
                Max = Math.max(Max, dice[i][j]);
            }
            max[i][1] = max[i][3] = Max;

            Max = 0;

            arg = new int[] {0,1,3,5};

            for(int j : arg){
                Max = Math.max(Max, dice[i][j]);
            }
            max[i][2] = max[i][4] = Max;

        }

        result = 0;
        for(int i=1; i<=6; i++) {
            sum(0, i, 0);
        }

        System.out.println(result);
    }

    private static void sum(int sum, int face, int number) {
        if(number==N){
            result = Math.max(result, sum);
            return;
        }

        for(int i=0; i<6; i++){
            if(face == dice[number][i]){
                switch(i){
                    case 1 :
                        sum(sum+max[number][i], dice[number][3], number+1);
                        break;
                    case 2:
                        sum(sum+max[number][i], dice[number][4], number+1);
                        break;
                    case 3:
                        sum(sum+max[number][i], dice[number][1], number+1);
                        break;
                    case 4:
                        sum(sum+max[number][i], dice[number][2], number+1);
                        break;
                    case 5:
                        sum(sum+max[number][i], dice[number][0], number+1);
                        break;
                    case 0:
                        sum(sum+max[number][i], dice[number][5], number+1);
                        break;
                }

            }

        }


    }
}
