import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int n0 = Integer.parseInt(br.readLine());

        for(int i=n0; i<=n0+100; i++){
            if(c1*i > a1*i+a0 || a1*i+a0 > c2*i){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
