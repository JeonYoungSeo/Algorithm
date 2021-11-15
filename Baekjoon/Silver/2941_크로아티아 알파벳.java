import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());

        int result = 0;

        for(int i=0; i<sb.length(); i++){
            if(i==sb.length()-1){
                result++;
                continue;
            }
            
            if(sb.charAt(i)=='c'){
                if(sb.charAt(i+1)=='=' || sb.charAt(i+1)=='-'){
                    i++;
                    result++;
                    continue;
                }
            }

            if(sb.charAt(i)=='d'){
                if(sb.charAt(i+1)=='-'){
                    i++;
                    result++;
                    continue;
                }
                if(i+2<sb.length() && sb.charAt(i+1)=='z' && sb.charAt(i+2)=='='){
                    i+=2;
                    result++;
                    continue;
                }

            }

            if(sb.charAt(i)=='l'){
                if(sb.charAt(i+1)=='j'){
                    i++;
                    result++;
                    continue;
                }
            }

            if(sb.charAt(i)=='n'){
                if(sb.charAt(i+1)=='j'){
                    i++;
                    result++;
                    continue;
                }
            }

            if(sb.charAt(i)=='s'){
                if(sb.charAt(i+1)=='='){
                    i++;
                    result++;
                    continue;
                }
            }

            if(sb.charAt(i)=='z'){
                if(sb.charAt(i+1)=='='){
                    i++;
                    result++;
                    continue;
                }
            }
            result++;
        }

        System.out.println(result);
    }
}
