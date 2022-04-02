import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String present = br.readLine();

        int answer = 0;

        if(present.charAt(0)=='W') answer++;
        if(N>=2){
            if(present.charAt(present.length()-1)=='E'){
                answer++;
            }
        }
        for(int i=1; i<N; i++){
            if(present.charAt(i-1)=='E' && present.charAt(i)=='W'){
                answer++;
            }
        }

        System.out.println(answer);

    }
}
