#include <iostream>

using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while(true){
        string line = " ";
        cin >> line;

        if(line == "end"){
            break;
        }

        int x = 0;
        int o = 0;

        for(int i=0; i<9; i++){
            if(line[i]=='X') x++;
            else if(line[i] == 'O') o++;
        }

        if(x-o<0 || x-o >=2){
            cout << "invalid\n";
            continue;
        }
        int xl = 0;
        int ol = 0;

        if(line[0] == line[1] && line[0] == line[2]){
            if(line[0] == 'X') xl++;
            else if(line[0] == 'O') ol++;
        }

        if(line[3] == line[4] && line[3] == line[5]){
            if(line[3] == 'X') xl++;
            else if(line[3] == 'O') ol++;
        }
        if(line[6] == line[7] && line[6] == line[8]){
            if(line[6] == 'X') xl++;
            else if(line[6] == 'O') ol++;
        }
        if(line[0] == line[3] && line[0] == line[6]){
            if(line[0] == 'X') xl++;
            else if(line[0] == 'O') ol++;
        }
        if(line[1] == line[4] && line[1] == line[7]){
            if(line[1] == 'X') xl++;
            else if(line[1] == 'O') ol++;
        }
        if(line[2] == line[5] && line[2] == line[8]){
            if(line[2] == 'X') xl++;
            else if(line[2] == 'O') ol++;
        }
        if(line[0] == line[4] && line[0] == line[8]){
            if(line[0] == 'X') xl++;
            else if(line[0] == 'O') ol++;
        }
        if(line[2] == line[4] && line[2] == line[6]){
            if(line[2] == 'X') xl++;
            else if(line[2] == 'O') ol++;
        }       

        if(xl >=1 && ol >=1){
            cout << "invalid\n";
        }else if(xl==0 && ol==0 && x+o!=9){
            cout << "invalid\n";
        }else if(xl>0 || ol > 0){
            if(ol>0 && x>o) cout << "invalid\n";
            else if(xl>0 && x==o) cout << "invalid\n";
            else cout << "valid\n";
        }
        else{
            cout << "valid\n";
        }
    }
}
