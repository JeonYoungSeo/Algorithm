import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            StringBuilder sb = new StringBuilder(br.readLine());
            int len = sb.length();
            if(len<=10){
                System.out.println(sb.toString());
            }else{
                System.out.println(""+sb.charAt(0)+(len-2)+sb.charAt(len-1));
            }


        }
    }
}
