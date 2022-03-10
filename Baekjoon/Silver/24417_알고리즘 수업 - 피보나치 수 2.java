import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int a=1, b=1;
        for(int i=3; i<=N; i++){
            int temp = b;
            b = (a+b)%1_000_000_007;
            a = temp ;
        }
        int result = N-2;
        if(result<1) result = 1;
        System.out.println(b+" "+result);

    }
}
