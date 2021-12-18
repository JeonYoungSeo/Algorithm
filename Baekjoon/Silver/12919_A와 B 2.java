import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder S = new StringBuilder(br.readLine());

        StringBuilder T = new StringBuilder(br.readLine());


        System.out.println(check(S,T));


    }

    private static int check(StringBuilder s, StringBuilder t) {
        if(s.length() == t.length()){
            if(s.toString().compareTo(t.toString())==0){
                return 1;
            }else{
                return 0;
            }
        }

        int TLen = t.length();
        int result = 0;
        if(t.charAt(TLen-1)=='A'){
            t.setLength(TLen-1);
            result = check(s,t);
            if(result == 1){
                return result;
            }
            t.append('A');
        }

        if(t.charAt(0)=='B'){
            t.reverse();
            t.setLength(TLen-1);
            result = check(s,t);
            if(result == 1){
                return result;
            }
            t.append('B');
            t.reverse();
        }

        return result;
    }
}
