#include <iostream>
#include <string>

using namespace std;

string run_length_encoding(const string& str) {

  int count = 1;
  char prev = str[0];
  string res;

  for (int i=1; i<str.size(); i++) {
    if (prev == str[i]) {
      count++;
    }
    else {
      res += prev;
      if (count > 1)
        res += to_string(count);
      prev = str[i];
      count = 1;
    }
  }

  res += prev;
  if (count > 1)
    res += to_string(count);

  return res;
}
