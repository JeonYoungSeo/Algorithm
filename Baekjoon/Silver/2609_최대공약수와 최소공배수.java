import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int i = 2;
        int mn = a*b;
        int mx = 1;
        while(i<=a && i<=b){
            if(a%i==0 && b%i ==0){
                mx *= i;
                a /= i;
                b /= i;
                i = 1;
            }
            i++;
        }
        
        bw.write(mx+" "+mn/mx);
        
        bw.flush();
        bw.close();
        br.close();
    }
}
