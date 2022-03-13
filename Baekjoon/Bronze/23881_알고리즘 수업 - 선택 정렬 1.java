import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
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
                int temp = A[max];
                A[max] = A[i];
                A[i] = temp;
                K--;
                if(K==0){
                    System.out.println(A[max]+" "+A[i]);
                    return;
                }

            }
        }
        System.out.println(-1);

    }
}
