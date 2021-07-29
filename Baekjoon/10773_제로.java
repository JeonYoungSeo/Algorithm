import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        List<Integer> lst = new ArrayList<Integer>();
        int number = -1;
        
        for(int i=0; i<n; i++){
            int temp = sc.nextInt();
            
            if(temp != 0){
                lst.add(temp);
                number++;
            }else {
            	lst.remove(number);
            	number--;
            }
        }
        int sum = 0;
        for(int i=0; i<=number; i++){
            sum += lst.get(i);
        }
        
        System.out.println(sum);
        
    }
}
