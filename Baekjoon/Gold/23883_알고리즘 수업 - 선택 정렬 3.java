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
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] ori = new int[N];
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            ori[i] = arr[i];
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        selection_sort(ori, arr, map);

    }

    private static void selection_sort(int[] ori, int[] A, HashMap map) {

        for(int i=N-1; i>=1; i--){
            int max = (int)map.get(A[i]);


            if(max<i){
                int temp = ori[max];
                ori[max] = ori[i];
                ori[i] = temp;
                map.put(ori[max], max);
                K--;
                if(K==0){
                    System.out.println(ori[max]+" "+ori[i]);
                    return;
                }

            }
        }
        System.out.println(-1);

    }
}
