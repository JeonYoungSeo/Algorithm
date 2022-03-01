import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static int[] LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] odd = new int[N/2];
        int[] even = new int[N/2];
        odd[N/2-1] = arr[N-2];
        even[N/2-1] = arr[N-1];


        int pos = N-4;
        for(int i=N/2-2; i>=0; i--){
            odd[i] = odd[i+1] + arr[pos];
            pos-=2;
        }
        pos = N-3;
        for(int i=N/2-2; i>=0; i--){
            even[i] = even[i+1] + arr[pos];
            pos-=2;
        }

        int result = Math.max(even[0], odd[0]);

        for(int i=0; i<N/2-1; i++){
            result = Math.max(result, odd[0]-odd[i+1]+even[i+1]);
            result = Math.max(result, odd[0]-odd[i+1]+even[i]-even[N/2-1]);
        }

        System.out.println(result);
    }
}
