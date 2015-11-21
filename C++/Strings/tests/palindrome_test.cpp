#include <iostream>
#include "../Palindrome.cpp"

int main() {

  string s = "nittini";

  /* Test for iterative function */
  bool res = is_palindrome(s);
  if (res) {
    cout << "'" + s + "'" + " is a palindrome." << endl;
  }
  else {
    cout << "'" + s + "'" + " is not a palindrome." << endl;
  }

  /* Test for recursive function */
  res = is_palindrome_recursive(s);
  if (res) {
    cout << "'" + s + "'" + " is a palindrome." << endl;
  }
  else {
    cout << "'" + s + "'" + " is not a palindrome." << endl;
  }

  return 0;
}


/*

How to run

g++ -std=c++11 palindrome_test.cpp -o palindrome
./palindrome

*/
