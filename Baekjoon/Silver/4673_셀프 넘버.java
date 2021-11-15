import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean[] self = new boolean[20000];

        for(int i=1; i<10000; i++) {
            if (i < 10) {
                self[i + i] = true;
                continue;
            }

            if (i < 100) {
                self[i + i % 10 + i / 10] = true;
                continue;
            }

            if (i < 1000) {
                self[i + i / 100 + i % 10 + i / 10 % 10] = true;
            }

            if (i < 10000) {
                self[i + i / 1000 + i / 100 % 10 + i % 10 + i / 10 % 10] = true;
            }
        }

        for(int i=1; i<=10000; i++){
            if(!self[i])
                System.out.println(i);
        }

    }
}
