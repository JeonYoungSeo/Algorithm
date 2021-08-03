package practice;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<N; i++){
            String str = sc.nextLine();
            
            List<Character> lst = new ArrayList<>();
            for(int j=0; j<str.length();j++) {
            	lst.add(str.charAt(j));
            }
            int j=0;
            int number = lst.size();
            do{
                if(lst.get(j)=='('){
                    if(lst.get(j+1)==')'){
                        lst.remove(j+1);
                        lst.remove(j);
                        number -=2;
                        j -= 2;
                    }
                }
                j++;
                if(j<0) j=0;
            }while(j<number-1);
            
            if(lst.size()==0) System.out.println("YES");
            else System.out.println("NO");
        }
        
        
    }
}
