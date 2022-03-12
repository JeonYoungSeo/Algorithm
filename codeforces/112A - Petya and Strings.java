import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine().toLowerCase();
        String B = br.readLine().toLowerCase();

        int len = A.length();

        for(int i=0; i<len; i++){
            char a = A.charAt(i);
            char b = B.charAt(i);

            if(a>b){
                System.out.println(1);
                return;
            }
            if(a<b){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(0);

    }
}
