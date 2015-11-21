#include <iostream>
#include <string>

using std::cout;
using std::endl;
using std::string;

void reverse_words(string*);

// Time complexity = O(n)
void reverse_words(string* s) {

  // Reverse the whole sentence
  reverse(s->begin(), s->end());

  int n = s->size(), start = 0;

  for (int i=0; i<n; i++) {
    if (s->at(i) == ' ') {
      reverse(s->begin() + start, s->begin() + i);
      start = i+1;
    }
    else if ( (i == n-1) && s->at(i) != ' ') {
      reverse(s->begin() + start, s->end());
    }
  }
}
