import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int y = 0;
        int x = 0;

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp==1){
                    System.out.println(Math.abs(2-i)+Math.abs(2-j));
                    return;
                }
            }
        }


    }
}
