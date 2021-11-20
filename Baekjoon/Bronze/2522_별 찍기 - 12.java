import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N*2-1; i++){

            for(int j=1; j<=Math.abs(N-i); j++)
                sb.append(" ");

            for(int j=1; j<=N-Math.abs(N-i); j++)
                sb.append("*");

            sb.append('\n');

        }

        System.out.println(sb);
    }

}
