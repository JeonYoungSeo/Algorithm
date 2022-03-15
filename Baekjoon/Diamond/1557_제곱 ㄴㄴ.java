import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[42001];

        arr[1] = 1;
        for(int i=1; i<=42000; i++){
            for(int j = 2*i; j<=42000; j+=i){
                arr[j] -= arr[i];
            }
        }

        long first = 0, last = K*2;
        while(first<last-1){
            long mid = (first+last)/2;
            if(cnt(arr, mid) < K) first = mid;
            else last = mid;
        }

        System.out.println(last);

    }

    private static double cnt(int[] arr,long mid) {
        double cnt = 0;
        for(int i=1; i*i<=mid; i++){
            cnt += arr[i]*mid / (i*i);
        }
        return cnt;
    }
}
