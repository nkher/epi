#include <iostream>
#include "../ReverseWords.cpp"


int main() {

  string s = "Namesh is a masters student";

  reverse_words(&s);

  cout << s << endl;

  return 0;
}

/*

How to run

g++ -std=c++11 reversewords_test.cpp -o reversewords
./reversewords

*/
