import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N];
        int[] result = new int[N];

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            line[i] = num;
        }

        result[0] = line[N-1];
        int curr = 0;
        for(int i=N-2; i>=0; i--){
            if(result[curr] > line[i]) //작으면 뒤로
            {
                curr++;
                result[curr] = line[i];
            }else{ //크면 앞에
                for(int j=0; j<=curr; j++){
                    if(result[j] < line[i]){
                        result[j] = line[i];
                        break;
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            if(result[i]==0){
                System.out.println(N-i);
                return;
            }
        }
        System.out.println(0);



    }
}
