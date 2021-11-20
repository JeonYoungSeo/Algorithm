import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();


        int result = 0;
        for(int i=0; i<num.length(); i++){
            int curr = num.charAt(i)-65;
            int add = 0;
            if(curr<19){
                add = curr/3+3;
                if(add==9) add = 8;
            }else{
                add = (curr-1)/3+3;
                if(add==11) add = 10;
            }
            result+= add;

        }

        System.out.println(result);
    }
}
