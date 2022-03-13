import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cnt, N;
    static int[] B ;
    static boolean print;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        cnt = 0;
        B = new int[N];
        print = true;

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
            if(A[i]==B[i])
                cnt++;
        }
        if(cnt==N){
            System.out.println("1");
            return;
        }

        merge_sort(0,N-1,A);

        if(print)
            System.out.println(0);
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
            if(A[i]==B[i]) cnt--;

            A[i++] = tmp[t++];
            if(A[i-1]==B[i-1]) cnt++;

            if(print && cnt==N) {
                System.out.println("1");
                print = false;
            }
        }
    }

}
