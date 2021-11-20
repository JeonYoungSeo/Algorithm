import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N*2-1; i++){

            for(int j=1; j<N-Math.abs(N-i); j++){
                sb.append(" ");
            }

            for(int j=1; j<=2*(Math.abs(N-i)+1)-1; j++){
                sb.append('*');
            }

            sb.append('\n');

        }

        System.out.println(sb);
    }

}
