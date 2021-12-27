import java.util.*;
import java.io.*;


public class Main
{
    static int N ;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] alcohol = new long[N];

        long max = 0;

        for(int i=0; i<N; i++){
            alcohol[i] = Long.parseLong(br.readLine());

            max = Math.max(alcohol[i], max);
        }


        System.out.println(search(0, max, alcohol, K));



    }

    private static long search(long left,long right, long[] alcohol, int k) {
        if(left>right) return 0;

        long ea = 0;
        long mid = (left+right)/2;
        mid = (mid==0)?1:mid;

        long result = 0;

        for(int i=0; i<N ; i++){
            ea += alcohol[i] / mid;
        }

        if(ea==0){
            return 0;
        }

        if(ea >= k){ //인원수보다 같거나 많이 나오면 늘여서 확인해봐야함
            result = mid;
            result = Math.max(search(mid+1, right, alcohol, k), result);
        }else if(ea<k){//인원수보다 적게 나오면 한잔당 l를 줄여야 함
            result = Math.max(result, search(left, mid-1, alcohol, k));
        }

        return result;
    }
}
