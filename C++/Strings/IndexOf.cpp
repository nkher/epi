#include <iostream>
#include <string>

#define d 256
#define p 31

using namespace std;

/* Uses the Rabin Karp Algorithm for searching
   Worst Case Running time is : O(n + m)
*/
void index_of(const string& text, const string& pat) {

  int N = text.size(), M = pat.size();
  int i, j;
  int ph=0, th=0, h=1;

  for (i=0; i<M-1; i++) {
    h = (h*d)%p;
  }

  // calculate the hash for the first window of text and also the pattern
  for (int i=0; i<M; i++) {
    ph = (ph*d + pat[i]) % p;
    th = (th*d + text[i]) % p;
  }

  // Starte checking
  for (i=0; i<=N-M; i++) {
    if (ph == th) { // start checking each character in that window
      for (j=0; j<M; j++) {
        if (text[i+j] != pat[j]) {
          break;
        }
      }

      if (j == M) {
        cout << "Match found at : " << i << endl;
      }
    }

    // Calculate the hash vaue for the next window
    if (i < N-M) {
      th = (d*(th - text[i]*h) + text[i+M]) % p;

      // if we get a negative value then make it positive
      if (th < 0) {
        th += p;
      }
    }
  }
}
