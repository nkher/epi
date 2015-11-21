#include <iostream>
#include "../LookAndSay.cpp"

int main() {

  string str = look_and_say(6);

  cout << str << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 lookandsay_test.cpp -o lookandsay
./lookandsay

*/
