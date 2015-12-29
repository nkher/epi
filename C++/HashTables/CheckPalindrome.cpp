#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>

using namespace std;

bool check_palindrome(string& s) {

  int len = s.size();
  if (len < 3) return true;
  int max_allowed_unique, num_unique;

  // check odd or even chars
  max_allowed_unique = ((len&1) == 1) ? (len/2)+1 : len/2;

  // store the char counts
  unordered_map<char, int> char_counts;
  for (int i=0; i<len; i++) {
    char c = s[i];
    auto search = char_counts.find(c);
    if (search == char_counts.end()) {
      char_counts[c] = 1;
    }
    else {
      char_counts[c]++;
    }
  }

  num_unique = char_counts.size();
  if (num_unique > max_allowed_unique) return false;

  int odd_counts = 0;
  for (const pair<char, int>& p : char_counts) {
    if ((p.second & 1) == 1) {
      odd_counts++;
    }
  }

  if ((len&1) == 0 && odd_counts > 0) return false;
  if ((len&1) == 1 && odd_counts > 1) return false;

  return true;
}

int main() {

  string s = "aabbfe", x = "aabaa";
  string y = "ertyuiop";
  cout << check_palindrome(s) << endl;
  cout << check_palindrome(x) << endl;
  cout << check_palindrome(y) << endl;

  return 0;
}


/*

How to run
-------------
g++ -std=c++11 CheckPalindrome.cpp -o checkpalindrome
./checkpalindrome

*/
