import java.util.*;
import java.io.*;


public class Main
{

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int result = 1;

        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i)-'A';

            switch (num){
                case 0:
                    if(result==1){
                        result = 2;
                    }else if(result==2){
                        result = 1;
                    }
                    break;
                case 1:
                    if(result==2){
                        result = 3;
                    }else if(result==3){
                        result = 2;
                    }
                    break;
                case 2:
                    if(result==1){
                        result = 3;
                    }else if(result==3){
                        result = 1;
                    }
                    break;
            }
        }

        System.out.println(result);

    }
}
