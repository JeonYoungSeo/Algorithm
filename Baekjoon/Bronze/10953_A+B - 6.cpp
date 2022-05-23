#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

int main(){

    int n;


    cin >> n;

    while(n-->0){
        stringstream ss;
        string s;
        cin >> s;
        ss.str(s);

        int answer = 0;
        string num;
        while(getline(ss, num, ',')){
            answer += stoi(num);
        }

        cout << answer << endl;

    }

}
