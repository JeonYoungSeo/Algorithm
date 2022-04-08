import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[10_001][4];

        arr[1][1] = arr[2][1] = arr[2][2] = arr[3][1] = arr[3][2] = arr[3][3] = 1;

        for(int i=4; i<=10_000; i++){
            arr[i][1] += arr[i-1][1];
            arr[i][2] += arr[i-2][1]+arr[i-2][2];
            arr[i][3] += arr[i-3][1]+arr[i-3][2]+arr[i-3][3];
        }

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());

            bw.write(arr[N][1]+arr[N][2]+arr[N][3]+"\n");
        }

        bw.flush();
        bw.close();

    }
}
