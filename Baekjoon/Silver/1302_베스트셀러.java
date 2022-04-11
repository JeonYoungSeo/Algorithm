import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int best = 1;
        while(T-->0) {
            String str = br.readLine();

            if(map.containsKey(str)){
                int n = map.get(str);
                map.put(str, n+1);
                best = Math.max(best, n+1);
            }else{
                map.put(str, 1);
            }
        }

        LinkedList<String> list = new LinkedList<>();

        for(String str : map.keySet()){
            if(map.get(str)==best){
                list.add(str);
            }
        }

        int size = list.size();
        String[] arr = new String[size];
        int i = 0;
        for(String s : list){
            arr[i++] = s;
        }

        Arrays.sort(arr);

        System.out.println(arr[0]);
    }
}
