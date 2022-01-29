import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        while(N-->0){
            int num = Integer.parseInt(br.readLine());
            if(N!=0) num--;
            result += num;

        }

        System.out.println(result);
    }
}
