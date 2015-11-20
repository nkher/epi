#include <iostream>
#include <string>

using std::string;
using std::cout;
using std::endl;

int string_to_int(const string& s) {

  bool neg = false;
  if (s[0] == '-') {
    neg = true;
  }

  int num = 0;

  for (int i = s[0]=='-' ? 1 : 0 ; i < s.size(); i++) {
    int digit = s[i] - '0';
    num = (num * 10) + digit;
  }

  if (neg) {
    num *= -1;
  }

  return num;
}
