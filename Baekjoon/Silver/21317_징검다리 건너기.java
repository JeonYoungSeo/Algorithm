import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static int N, bigJump, result;
    static int[] energy, bigEnergy, minEnergy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        energy = new int[N];
        bigEnergy = new int[N];

        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            energy[i] = Integer.parseInt(st.nextToken());
            bigEnergy[i] = Integer.parseInt(st.nextToken());
        }

        bigJump = Integer.parseInt(br.readLine());

        result = 987654321;

        findEnergy(1,0,false);

        System.out.println(result);

    }

    private static void findEnergy(int num, int totalEnergy, boolean jump) {
        if(num==N){
            result = Math.min(result, totalEnergy);
            return;
        }
        
        if(result<totalEnergy){
            return;
        }

        findEnergy(num+1, totalEnergy+energy[num],jump);
        if(num+2<=N){
            findEnergy(num+2, totalEnergy+bigEnergy[num], jump);
        }
        if(!jump && num+3<=N){
            findEnergy(num+3,totalEnergy+bigJump, true);
        }

    }
}
