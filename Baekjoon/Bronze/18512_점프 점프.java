import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());



        while(p1 != p2){
            if(p1<p2){
                p1 += x;
            }else{
                p2 += y;
            }

            if(p1>987654321){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(p1);



    }
}
