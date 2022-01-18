import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] hou = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            hou[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hou);

        int result = 0;

        for(int i=N-1; i>=N/2; i--){
            result += hou[i]*2;
        }

        if(N!=1 && N%2 != 0){
            result -= hou[N/2];
        }

        System.out.println(result);

    }
}
