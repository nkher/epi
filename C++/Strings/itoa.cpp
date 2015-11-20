#include <iostream>
#include <string>

using std::string;

string itoa(int number) {

  bool neg = false;
  if (number < 0) {
    neg = !neg;
    number = number * (-1);
  }

  string s_num;
  while (number > 0) {
    s_num += '0' + (number % 10);
    number /= 10;
  }

  reverse(s_num.begin(), s_num.end());

  if (neg) {
    s_num = '-' + s_num;
  }

  return s_num;
}
