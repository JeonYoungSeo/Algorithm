import java.util.*;
import java.io.*;


public class Main
{


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] alcohol = new long[N];

        long max = 0;

        for (int i = 0; i < N; i++) {
            alcohol[i] = Long.parseLong(br.readLine());

            max = Math.max(alcohol[i], max);
        }

        long left = 0;
        long right = max;
        long mid;

        long result = 0;
        while(left<=right){
            mid = (left+right)/2;
            mid = (mid==0)?1:mid;
            long ea = 0;
            for(int i=0; i<N; i++){
                ea += alcohol[i]/mid;
            }

            if(ea == 0){
                System.out.println(0);
                return;
            }
            if(ea < K){ //막걸리수 적다 -> 용량 줄여야함
                right = mid-1;
            }else{ //반대
                result = mid;
                left = mid+1;
            }
        }

        System.out.println(result);
    }
}
