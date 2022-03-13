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

        st = new StringTokenizer(br.readLine());

        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int n0 = Integer.parseInt(br.readLine());

        double D = a1*a1-4*(a2-c1)*a0;
        double D2 = a1*a1-4*(a2-c2)*a0;

        boolean con1 = false;
        boolean con2 = false;

        if(a2-c1<0){
            con1 = false;
        }else if(a2-c1==0){
            if(a1==0) {
                if (a0 >= 0) {
                    con1 = true;
                } else {
                    con1 = false;
                }
            }else{
                if(a1 <0){
                    con1 = false;
                }else if(n0>=-(a0/a1)){
                    con1 = true;
                }
            }
        }else {
            if (D <= 0) {
                con1 = true;
            } else {
                double right = (-a1 + Math.sqrt(D)) / (2 * (a2 - c1));
                double left = (-a1 - Math.sqrt(D)) / (2 * (a2 - c1));
                double big = Math.max(right, left);

                if (big <= n0) {
                    con1 = true;
                } else {
                    con1 = false;
                }
            }
        }


        if(a2-c2>0){
            con2 = false;
        }else if(a2-c2==0){
            if(a1==0) {
                if (a0 <= 0) {
                    con2 = true;
                } else {
                    con2 = false;
                }
            }else{
                if(a1>0){
                    con2 = false;
                }else{
                    if(n0>=-(a0/a1)){
                        con2 = true;
                    }else{
                        con1 = false;
                    }
                }
            }
        }else {

            if (D2 <= 0) {
                con2 = true;
            } else {
                double right = (-a1 + Math.sqrt(D2)) / (2 * (a2 - c2));
                double left = (-a1 - Math.sqrt(D2)) / (2 * (a2 - c2));
                double big = Math.max(right, left);

                if (big <= n0) {
                    con2 = true;
                } else {
                    con2 = false;
                }
            }
        }
        if(con1 && con2){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
}
