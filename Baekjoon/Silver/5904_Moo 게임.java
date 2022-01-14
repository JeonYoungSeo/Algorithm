import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        System.out.println(moo(3,1,N));

    }

    private static char moo(int num,int i, int N) {
        if(N==1){
            return 'm';
        }else if(N<=3){
            return 'o';
        }

        if(N < num+i+3){
            if(num +1 == N){
                return 'm';
            }else{
                return 'o';
            }
        }else if(N < 2*num+i+3){
            return moo(3,1,N-num-i-3);
        }

        return moo(2*num+i+3,i+1,N);

    }
}
