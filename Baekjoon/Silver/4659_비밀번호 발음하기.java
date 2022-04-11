import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while(true){
            str = br.readLine();
            boolean mo = false;
            boolean cont = false;
            int mc =0;
            int jc =0;
            int cnt = 1;
            if("end".equals(str)) return;

            int len = str.length();

            for(int i=0; i<len; i++){
                if("aeiou".indexOf(str.charAt(i))!=-1) {
                    mo = true;
                    if(cont==false){
                        cont = true;
                        mc = 0;
                        jc = 0;
                    }
                    mc++;
                }else{
                    if(cont==true){
                        cont = false;
                        mc = 0;
                        jc = 0;
                    }
                    jc++;
                }
                if(jc>=3 || mc>=3){
                    mo = false;
                    break;
                }

                if(i>=1 && str.charAt(i-1)==str.charAt(i)){
                    if("eo".indexOf(str.charAt(i))==-1){
                        mo=false;
                        break;
                    }
                }
            }
            if(mo){
                System.out.println("<"+str+"> is acceptable.");
            }else{
                System.out.println("<"+str+"> is not acceptable.");
            }
        }


    }
}
