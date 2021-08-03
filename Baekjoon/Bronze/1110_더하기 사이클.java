import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        int temp = N;
        int sum = 0;
        do{
            count ++;
            sum = temp/10+temp%10;
            temp = temp%10*10 + sum%10;
        }while(N!=temp);
        
        bw.write(Integer.toString(count));
        
        bw.flush();
        bw.close();
        br.close();
        
    }
}
