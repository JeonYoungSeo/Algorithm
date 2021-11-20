import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N*2; i++){
            for(int j=i; j<i+N; j++){
                if(j%2==1)
                    sb.append('*');
                else
                    sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
