import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] H = new int[1_000_001];

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int h = Integer.parseInt(st.nextToken());

            if(H[h]==0){
                answer++;
            }else{
                H[h]--;
            }
            H[h-1]++;
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
