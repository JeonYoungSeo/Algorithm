#include <iostream>
using namespace std;

int main(){

    bool stud[31] = {0,};

    for(int i=0; i<28; i++){
        int num;
        cin >> num;
        stud[num] = true;
    }

    for(int i=1; i<31; i++){
        if(!stud[i]) cout << i << endl;
    }


}
