import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            int loc = i - 1;
            int newItem = arr[i];

            while (0 <= loc && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                loc--;
                cnt++;
                if (cnt == K) {
                    for(int n : arr){
                        System.out.print(n+" ");
                    }

                    return;
                }
            }
            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
                cnt++;
                if (cnt == K) {
                    for(int n : arr){
                        System.out.print(n+" ");
                    }
                    return;
                }
            }
        }
        System.out.println(-1);

    }
}
