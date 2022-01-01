import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for(int i=0; i<N; i++){
            result.append("a");
        }

        System.out.println(result.toString());

    }
}
