import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int value[] = new int[N];
        int shipment[] = new int[N];


        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            value[i] = Integer.parseInt(st.nextToken());
            shipment[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1_000_001;
        int max = 0;

        for(int i=0; i<N;i++){
            int pro = 0;
            for(int j=0; j<N; j++){
                if(value[i]>value[j]) continue;

                int profit = Math.min(value[i],value[j])-shipment[j];
                if(profit<=0) continue;

                pro += profit;
            }

            if(pro<=0) continue;

            if(max<pro){
                max = pro;
                answer = value[i];
            }else if(max==pro){
                answer = Math.min(answer,value[i]);
            }
        }
        if(answer==1_000_001) answer = 0;
        System.out.println(answer);
    }
}
