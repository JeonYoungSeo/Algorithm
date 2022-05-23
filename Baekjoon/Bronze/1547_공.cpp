#include <iostream>
using namespace std;

int main(){

    int cnt;

    cin >> cnt ;
    int cup[4] = {0,1,0,0};
    int x,y;
    while(cnt-->0){
        cin >> x >> y;

        int temp = cup[x];
        cup[x] = cup[y];
        cup[y] = temp;
    }

    for(int i=1; i<4; i++){
        if(cup[i] == 1){
            cout << i << endl;
            return 0;
        }
    }

}
