import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            BigInteger answer = new BigInteger("0");
            while(st.hasMoreTokens()){
                BigInteger plus = new BigInteger(st.nextToken());
                answer = answer.add(plus);
            }

            char[] arr = ("0"+answer).toCharArray();

            for(int i=arr.length-1; i>=0; i--){
                if(arr[i] >= '2'){
                    arr[i] -= 2;
                    arr[i-1] ++;
                }
            }

            if(arr[0] == '1') bw.write('1');
            for(int i=1; i<arr.length; i++){
                if(arr[i]=='.') break;
                bw.write(arr[i]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}
