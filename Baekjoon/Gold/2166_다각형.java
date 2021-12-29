import java.util.*;
import java.io.*;
//신발끈 공식 사용 

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[][] arr = new double[N+1][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                arr[i][j] = Double.parseDouble(st.nextToken());
            }
        }
        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];

        double result = 0;

        for(int i=0; i<N; i++){
            result += arr[i][0]*arr[i+1][1];
            result -= arr[i][1]*arr[i+1][0];
        }

        result = Math.abs(result/2);

        System.out.printf("%.1f",result);

    }

}
