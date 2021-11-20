import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while(N!=1){
            int div = 2;

            while(true) {
                if (N % div == 0) {
                    N /= div;
                    bw.write(div+"\n");
                    break;
                }
                div++;
            }

        }


        bw.flush();
        bw.close();
        br.close();

    }
}
