import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int h=1; h<=9; h++){
            for(int w=1; w<=9; w++){
                if(w==h) continue;
                for(int e=0; e<=9; e++){
                    if(e==w || e==h) continue;
                    for(int o=0; o<=9; o++){
                        if(o==e|| o==w || o==h) continue;
                        for(int l=0; l<=9; l++){
                            if(l==e || l==h || l==w || l==o) continue;
                            for(int d=0; d<=9; d++){
                                if(d==e || d==h || d==w || d==o || d==l) continue;
                                for(int r=0; r<=9; r++) {
                                    if(r==e || r==h || r==w || r==o || r==l || r==d) continue;
                                    int a = 0;
                                    int b = 0;
                                    a += h;
                                    a = a * 10 + e;
                                    a = a * 10 + l;
                                    a = a * 10 + l;
                                    a = a * 10 + o;

                                    b += w;
                                    b = b * 10 + o;
                                    b = b * 10 + r;
                                    b = b * 10 + l;
                                    b = b * 10 + d;
                                    if(a+b == N){
                                        System.out.println("  "+a);
                                        System.out.println("+ "+b);
                                        System.out.println("-------");
                                        System.out.printf("%7d",N);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("No Answer");


    }
}
