import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        stack.add(str.charAt(0));

        int thick = 0;
        int result = 0;
        char pre = '(';

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)=='('){
                stack.add('(');
                pre = '(';
                thick ++;
            }else{
                if(pre == '('){
                    result += thick;

                }else{
                    result ++;
                }
                pre = ')';
                thick--;
            }
        }
        System.out.println(result);


    }
}
