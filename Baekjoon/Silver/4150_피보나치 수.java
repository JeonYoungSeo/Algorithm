import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        if(num == 0){
            System.out.println(0);
            return;
        }else if(num==1 || num==2){
            System.out.println(1);
            return;
        }

        BigInteger temp1 = new BigInteger("0");
        BigInteger temp2 = new BigInteger("1");
        BigInteger result = new BigInteger("1");

        for(int i=3; i<=num; i++){
            temp1 = temp2;
            temp2 = result;
            result = temp1.add(temp2);
        }

        System.out.println(result.toString());


    }
}
