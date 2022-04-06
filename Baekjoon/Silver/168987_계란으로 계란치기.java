import java.io.*;
import java.util.*;

public class Main {
    static int[] s,w;
    static int N, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        answer = 0;
        w = new int[N];
        s = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        func(0);

        System.out.println(answer);
    }

    private static void func(int num) {

        if(num==N){
            int n = 0;
            for(int i=0; i<N; i++){
                if(s[i]<=0) n++;
            }
            answer = Math.max(answer, n);
            return;
        }

        boolean next = true;

        for(int i=0; i<N; i++){
            if(i==num || s[i]<=0 || s[num]<=0) continue;
            next = false;
            s[i] -= w[num];
            s[num] -= w[i];
            func(num+1);
            s[i] += w[num];
            s[num] += w[i];
        }

        if(next){
            func(num+1);
        }
    }
}
