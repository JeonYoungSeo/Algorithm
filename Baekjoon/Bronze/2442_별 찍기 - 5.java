import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            for(int j=0; j<N-1-i; j++){
                System.out.print(" ");
            }

            for(int j=0; j<2*i+1; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }

}
