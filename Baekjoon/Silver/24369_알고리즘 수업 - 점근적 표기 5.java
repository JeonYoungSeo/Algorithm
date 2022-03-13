import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a2 = Integer.parseInt(st.nextToken());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());


        int c = Integer.parseInt(br.readLine());

        int n0 = Integer.parseInt(br.readLine());

        double D = a1*a1-4*(a2-c)*a0;

        if(a2-c<0){
            System.out.println(0);
            return;
        }else if(a2-c==0){
            if(a1==0) {
                if (a0 >= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }else{
                if(n0>=-(a0/a1)){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
            return;
        }

        if(D<=0){
            System.out.println(1);
        }else{
            double right = (-a1+Math.sqrt(D))/(2*(a2-c));
            double left = (-a1-Math.sqrt(D))/(2*(a2-c));
            double big = Math.max(right, left);

            if(big<=n0){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }
}
