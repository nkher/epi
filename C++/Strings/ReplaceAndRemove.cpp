#include <iostream>
#include <string>

using std::cout;
using std::endl;
using std::string;

// removes 'b' and replace each 'a' by dd
string replace_and_remove(string &s) {

  int write_ind = 0, new_len = 0;
  int num_a = 0;
  for (int i=0; i<s.size(); i++) {
    if (s[i] == 'b') {
      continue;
    }
    else if (s[i] == 'a') {
      num_a++;
    }
    s[write_ind++] = s[i];
  }

  int curr = write_ind - 1;
  s.resize(write_ind + num_a);
  write_ind = s.size() - 1;

  while (curr >= 0) {
    if (s[curr] == 'a') {
      s[write_ind--] = 'd';
      s[write_ind--] = 'd';
    }
    else {
      s[write_ind--] = s[curr];
    }
    curr--;
  }

  return s;
}
