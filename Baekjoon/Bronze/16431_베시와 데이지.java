import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int Br = Integer.parseInt(st.nextToken());
        int Bc = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int Dr = Integer.parseInt(st.nextToken());
        int Dc = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int Jr = Integer.parseInt(st.nextToken());
        int Jc = Integer.parseInt(st.nextToken());

        int B = (Math.abs(Br-Jr)>Math.abs(Bc-Jc))?Math.abs(Br-Jr):Math.abs(Bc-Jc);
        int D = Math.abs(Dr-Jr)+Math.abs(Dc-Jc);

        if(B<D){
            System.out.println("bessie");
        }else if(D<B){
            System.out.println("daisy");
        }else{
            System.out.println("tie");
        }
    }
}
