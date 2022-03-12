import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toLowerCase();

        StringBuilder result = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c != 'a' && c != 'e'&&c != 'i'&&c != 'o'&&c != 'u' &&c != 'y'){
                result.append("."+c);
            }
        }
        System.out.println(result);
    }
}
