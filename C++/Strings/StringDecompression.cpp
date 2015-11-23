#include <iostream>
#include <string>
#include <cctype>

using namespace std;

string decompress(const string& str) {

  string res;
  char prev = str[0];
  int count = 1, n = str.size();

  for (int i=1; i<n; i++) {
    if (isdigit(str[i])) {
      count = (count * 10) + (str[i] - '0');
    }
    else {
      if (!isdigit(str[i-1])) { // if prev was a character, then append it to result (its count was one)
        res += prev;
      }
      else {
        while (count > 0) {
          res += prev;
          count--;
        }
      }
      prev = str[i];
    }
  }

  if (!isdigit(str[n-1])) res += prev;

  else {
    while (count > 0) {
      res += prev;
      count--;
    }
  }

  return res;
}
