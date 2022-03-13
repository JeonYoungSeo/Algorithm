import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = 0;

        int[] arr = new int[N];
        B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
            if(arr[i]==B[i]) K++;
        }
        if(K==N) {
            System.out.println(1);
            return;
        }

        selection_sort(arr);

    }

    private static void selection_sort(int[] A) {

        for(int i=N-1; i>=1; i--){
            int max = 0;

            for(int j=0; j<=i; j++){
                if(A[max] < A[j]){
                    max = j;
                }
            }

            if(max!=i){
                if(A[i]==B[i]) K--;
                if(A[max]==B[max]) K--;
                int temp = A[max];
                A[max] = A[i];
                A[i] = temp;
                if(A[i]==B[i]) K++;
                if(A[max]==B[max]) K++;
                if(K==N){
                    System.out.println(1);
                    return;
                }

            }
        }
        System.out.println(0);

    }
}
