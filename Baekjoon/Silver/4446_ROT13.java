import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mo = "aiyeou";
        String Mo = "AIYEOU";
        String ja = "bkxznhdcwgpvjqtsrlmf";
        String Ja = "BKXZNHDCWGPVJQTSRLMF";
        String str = "";
        while((str = br.readLine())!=null) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                int mo_in = mo.indexOf(str.charAt(i));
                int Mo_in = Mo.indexOf(str.charAt(i));
                int ja_in = ja.indexOf(str.charAt(i));
                int Ja_in = Ja.indexOf(str.charAt(i));
                if (mo_in != -1) {
                    answer.append(mo.charAt((mo_in + 3) % 6));
                } else if (ja_in != -1) {
                    answer.append(ja.charAt((ja_in + 10) % 20));
                } else if (Mo_in != -1) {
                    answer.append(Mo.charAt((Mo_in + 3) % 6));
                } else if (Ja_in != -1) {
                    answer.append(Ja.charAt((Ja_in + 10) % 20));
                } else {
                    answer.append(str.charAt(i));
                }
            }
            System.out.println(answer);
        }
    }
}
