import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] table;
    public static int answer, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        table = new int[T][5];

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            table[i][0] = a/100;
            a = a%100;
            table[i][1] = a/10;
            a = a%10;
            table[i][2] = a;

            int b = Integer.parseInt(st.nextToken());
            table[i][3] = b;
            int c = Integer.parseInt(st.nextToken());
            table[i][4] = c;
        }
        answer = 0;
        permu(0, new int[] {0,0,0});

        System.out.println(answer);

    }

    private static void permu(int n, int[] arr) {
        if(n==3){
            if(able(arr)){
                answer++;
            }

            return ;
        }
        out :
        for(int i=1; i<10; i++){
            for(int j=0; j<n; j++){
                if(arr[j]==i) continue out;
            }
            arr[n]= i;
            permu(n+1, arr);
        }
    }

    private static boolean able(int[] arr) {

        for(int i=0; i<T; i++){
            int ball = 0;
            int strike = 0;

            for(int ori=0; ori<3; ori++){
                for(int com=0; com<3; com++){
                    if(ori==com){
                        if(table[i][ori] == arr[com]){
                            strike++;
                        }
                    }else{
                        if(table[i][ori] == arr[com]){
                            ball++;
                        }
                    }
                }
            }
            if(strike != table[i][3] || ball != table[i][4]){
                return false;
            }

        }

        return true;
    }
}
