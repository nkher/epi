#include "../RomanToInteger.cpp"

int main() {

  string s = "LIX";

  int ans = roman_to_number(s);

  cout << s + " -> " << ans << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 romantointeger_test.cpp -o romantointeger
./romantointeger

*/
