import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());

        long small = 100001;
        int pre = -1;
        long ea = 0;
        boolean inc = false;
        for(int i=0; i<n; i++){
            int cost = Integer.parseInt(br.readLine());

            if(inc){
                if(pre>cost){
                    W += ea* pre;
                    ea = 0;
                    inc = false;
                    small = cost;
                }
                pre = cost;
                continue;
            }

            if(pre!=-1 && pre<cost){
                ea = W/small;
                W -= ea*small;
                inc = true;
                small = 100001;
                pre = cost;
                continue;
            }

            small = Math.min(small, cost);

            pre = cost;
        }

        if(inc){
            W += ea*pre;
        }

        System.out.println(W);

    }
}
