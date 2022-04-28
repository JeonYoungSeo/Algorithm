import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int min = str1.length();
        int max = str2.length();

        int answer = 51;

        for(int i=0; i<=max-min; i++){
            int num = 0;
            for(int j=i; j<i+min; j++){
                if(str1.charAt(j-i)!=str2.charAt(j)) num++;
            }
            answer = Math.min(answer, num);
        }

        System.out.println(answer);

    }
}
