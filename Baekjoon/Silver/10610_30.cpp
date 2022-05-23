#include <iostream>
#include <string>
using namespace std;

int main(){

    int arr[11] = {0,};

    string num ;

    cin >> num;

    int sum = 0;

    for(int i=0; i< num.length(); i++){
        int curr = num.at(i)-'0';

        sum += curr;
        arr[curr]++;

    }

    if(sum % 3 !=0 || arr[0]==0){
        cout << -1 << endl;
    }else{
        for(int i=9; i>=0; i--){
            while(arr[i]>0){
                arr[i]--;
                cout << i;
            }
        }
    }


        

}
