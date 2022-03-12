import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = 0;

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            String str = br.readLine();

            if(str.charAt(1)=='+'){
                x++;
            }else{
                x--;
            }
        }
        System.out.println(x);
    }
}
