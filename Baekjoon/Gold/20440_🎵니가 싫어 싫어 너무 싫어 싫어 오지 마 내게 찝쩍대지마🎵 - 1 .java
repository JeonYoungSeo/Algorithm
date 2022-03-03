import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] in = new int[N];
        int[] out = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int In = Integer.parseInt(st.nextToken());
            int Out = Integer.parseInt(st.nextToken());

            in[i] = In;
            out[i] = Out;
        }
        Arrays.sort(in);
        Arrays.sort(out);

        int max_time = 0;
        int start_time = 0;
        int entire_time = 0;
        int mosquito = 0;
        int result = 0;
        int result_start = 0, result_end = 0;
        int In = 0;
        int Out = 0;

        while(In<N || Out<N){

            if(In<N) {
                if (in[In] == out[Out]) {
                    In++;
                    Out++;
                    continue;
                }

                if (in[In] < out[Out]) {
                    start_time = in[In];
                    mosquito++;
                    In++;
                }
            }
            if(In<N && out[Out]>in[In]){
                continue;
            }else if(In==N || out[Out]<in[In] ){
                entire_time = out[Out]-start_time;

                if(result<mosquito) {
                    result = mosquito;
                    result_start = start_time;
                    result_end = out[Out];
                }

                mosquito--;
                Out++;

            }
        }

        System.out.println(result);
        System.out.println(result_start+" "+result_end);


    }
}
