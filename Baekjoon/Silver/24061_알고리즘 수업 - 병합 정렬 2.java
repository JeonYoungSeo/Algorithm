import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, cnt;
    static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = new StringBuilder("-1");
        cnt = 0;
        merge_sort(0,N-1,A);

        System.out.println(result);
    }

    private static void merge_sort(int p, int r, int[] A) {

        if(p<r){
            int q = (p+r)/2;
            merge_sort(p, q, A);
            merge_sort(q+1, r , A);
            merge(A, p, q, r);
        }


    }

    private static void merge(int[] A, int p, int q, int r) {
        int i= p;
        int j = q+1;
        int t = 0;
        int[] tmp = new int[r-p+1];
        while( i<=q && j <= r){
            if(A[i]<A[j]){
                tmp[t++] = A[i++];
            }else{
                tmp[t++] = A[j++];
            }

        }

        while(i<=q)
            tmp[t++] = A[i++];

        while(j<=r)
            tmp[t++] = A[j++];

        i = p; t =0;

        while(i<=r) {
            A[i++] = tmp[t++];
            cnt++;
            if(cnt==K){
                result.setLength(0);
                for(int n : A){
                    result.append(n+" ");
                }
            }
        }
    }

}
