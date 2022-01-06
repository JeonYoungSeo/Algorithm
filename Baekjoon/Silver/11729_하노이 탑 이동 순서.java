import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder subResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        subResult = new StringBuilder();
        //
        int result = hanoi(1,3,2,N);


        System.out.println(result);
        System.out.println(subResult.toString());
    }



    private static int hanoi(int from,int to, int mid,int N) {

        if(N==1) {
            subResult.append(from+" "+to+"\n");

            return 1;
        }

        int result = 1;

        result += hanoi(from,mid,to,N-1);

        subResult.append(from+" "+to+"\n");

        result += hanoi(mid,to,from, N-1);

        //
        return result;
    }


}
