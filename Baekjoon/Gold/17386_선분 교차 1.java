import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static double ccw(double[] a, double[] b, double[] c){
        return (b[0]-a[0])*(c[1]-a[1])-(b[1]-a[1])*(c[0]-a[0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double[] l1 = new double[4];
        double[] l2 = new double[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            l1[i] = Double.parseDouble(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            l2[i] = Double.parseDouble(st.nextToken());
        }

        if(isIntersect(l1,l2)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    private static boolean isIntersect(double[] l1, double[] l2) {
        double[] a = {l1[0], l1[1]};
        double[] b = {l1[2], l1[3]};
        double[] c = {l2[0], l2[1]};
        double[] d = {l2[2], l2[3]};

        double val1 = ccw(a,b,c) * ccw(a,b,d);
        double val2 = ccw(c,d,a) * ccw(c,d,b);
        if(val1==0 && val2==0){
            double ax = Math.min(l1[0],l1[2]);
            double bx = Math.max(l1[0],l1[2]);
            double cx = Math.min(l2[0],l2[2]);
            double dx = Math.max(l2[0],l2[2]);

            double ay = Math.min(l1[1],l1[3]);
            double by = Math.max(l1[1],l1[3]);
            double cy = Math.min(l2[1],l2[3]);
            double dy = Math.max(l2[1],l2[3]);

            return (bx>=cx && dx>=ax) && (by>=cy && dy>=ay);
        }

        return val1<=0 && val2<=0;
    }
}
