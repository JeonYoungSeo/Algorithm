import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[1_000_001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i=4; i<=1_000_000; i++){
            arr[i] = (arr[i-1]+arr[i-2])%1_000_000_009;
            arr[i] = (arr[i]+arr[i-3])%1_000_000_009;
        }

        while(T-->0){
            int n = Integer.parseInt(br.readLine());

            bw.write(arr[n]+"\n");
        }

        bw.flush();
    }
}
