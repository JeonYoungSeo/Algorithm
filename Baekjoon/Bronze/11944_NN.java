import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int M = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();

        for(int i=0; i<Integer.parseInt(N); i++){
            answer.append(N);
        }

        if(answer.length()>M) {
            System.out.println(answer.substring(0, M));
        }else{
            System.out.println(answer);
        }

    }
}
