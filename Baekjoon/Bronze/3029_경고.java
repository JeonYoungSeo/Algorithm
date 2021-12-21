import java.util.*;
import java.io.*;


public class Main
{

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int hour = (second.charAt(0)-'0')*10+second.charAt(1)-'0'-((first.charAt(0)-'0')*10+first.charAt(1)-'0');
        int min = (second.charAt(3)-'0')*10+second.charAt(4)-'0'-((first.charAt(3)-'0')*10+first.charAt(4)-'0');
        int sec = (second.charAt(6)-'0')*10+second.charAt(7)-'0'-((first.charAt(6)-'0')*10+first.charAt(7)-'0');

        if(sec<0){
            sec = 60+sec;
            min--;
        }
        if(min<0){
            min = 60+min;
            hour--;
        }
        if(hour<0){
            hour = 24+hour;
        }
        if(sec==0 && min==0 && hour==0){
            hour = 24;
        }
        System.out.println(String.format("%02d:%02d:%02d",hour,min,sec ));

    }
}
