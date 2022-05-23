#include <iostream>
#include <string>
using namespace std;

int main(){

    int arr[10] = {0,};

    string num;
    cin >> num;

    int answer = 0;
    for(int i=0; i<num.length(); i++){
        int n = num.at(i)-'0';
        arr[n]++;
    }
    for(int i=9; i>=0; i--){
        while(arr[i]!=0){
            answer *= 10;
            answer += i;
            arr[i]--;
        }
    }

    cout << answer << endl;

}
