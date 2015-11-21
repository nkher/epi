#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;


/* Does not validate the six exception cases when a small number appears to the left of a larger one */
int roman_to_number(const string& s) {
  unordered_map<char, int> map = { {'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000} };

  int ans = map[s.back()];
  for (int i=s.length()-2; i>=0; i--) {
    if (map[s[i]] > map[s[i+1]]) { // non increasing sequence hence add
      ans += map[s[i]];
    }
    else {
      ans -= map[s[i]];
    }
  }

  return ans;
}
