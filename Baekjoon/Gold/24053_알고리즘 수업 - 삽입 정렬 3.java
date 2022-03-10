import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = new int[N];
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            if(B[i]==A[i]) cnt++;
        }
        if(cnt==N){
            System.out.println(1);
            return;
        }

        for (int i = 1; i < N; i++) {
            int loc = i - 1;
            int newItem = A[i];

            while (0 <= loc && newItem < A[loc]) {
                if(A[loc+1]==B[loc+1])
                    cnt--;
                A[loc + 1] = A[loc];
                loc--;
                if(A[loc+2]==B[loc+2])
                    cnt++;
                if(cnt==N){
                    System.out.println(1);
                    return;
                }
            }
            if (loc + 1 != i) {
                if(A[loc+1]==B[loc+1])
                    cnt--;
                A[loc + 1] = newItem;
                if(A[loc+1]==B[loc+1])
                    cnt++;
                if(cnt==N){
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);

    }
}
