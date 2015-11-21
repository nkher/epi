#include <iostream>
#include <string>

using std::cout;
using std::endl;
using std::string;
using std::tolower;

/* Declarations */
bool s_palindrome(const string&);
bool is_palindrome_recursive(const string &s);
bool is_palindrome_recursive_helper(const string&s, int, int);

bool is_palindrome(const string& s) {

  int start = 0, end = s.size() - 1;
  while (start < end) {
      if (tolower(s[start]) != tolower(s[end])) {
        return false;
      }
      start++;
      end--;
  }

  return true;
}

bool is_palindrome_recursive(const string &s) {
  int end = s.size() - 1;
  return is_palindrome_recursive_helper(s, 0, end);
}

bool is_palindrome_recursive_helper(const string &s, int start, int end) {
  if (start >= end) {
    return true;
  }
  if (tolower(s[start]) != tolower(s[end])) {
      return false;
  }
  return is_palindrome_recursive_helper(s, ++start, --end);
}
