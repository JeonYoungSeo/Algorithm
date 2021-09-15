import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	static int C,R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        double D2 = Math.pow(D, 2);
        double H2 = Math.pow(H, 2);
        double W2 = Math.pow(W, 2);
        
        System.out.println((int)Math.sqrt(D2*H2/(H2+W2))+" "+(int)Math.sqrt(D2*W2/(H2+W2)));
        
    }
}
