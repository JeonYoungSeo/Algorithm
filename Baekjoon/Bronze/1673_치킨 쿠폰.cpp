#include <iostream>
using namespace std;

int main(){

    int a,b;

    while(cin>>a>>b){

        int answer = a - a % b;
        
        int remain = a/b + a%b;

        while(remain>=b){
            answer += remain - remain % b;

            remain = remain/b + remain%b;
        }

        answer += remain;

        cout << answer << endl;

    }


}
