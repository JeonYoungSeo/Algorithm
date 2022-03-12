import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();

        if(len==1){
            System.out.println(0);
            return;
        }
        int result = 0;
        for(int i=0; i<len-1; i++){
            if(str.charAt(i)!=str.charAt(i+1)){
                result++;
            }
        }
        result = (result%2==0)?result/2:result/2+1;
        System.out.println(result);
    }
}
