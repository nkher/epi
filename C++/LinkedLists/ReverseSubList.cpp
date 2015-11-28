#include <iostream>

#include "../Library/LinkedListNode.h"

using namespace std;

void reverse_sublist(const shared_ptr<LinkedListNode<int>>& head, int s, int f) {
  shared_ptr<LinkedListNode<int>> beforeStart = head;
  int i=1;
  /* Get the node before the sth node */
  while (i < s-1) {
    beforeStart = beforeStart->next;
    i++;
  }

  shared_ptr<LinkedListNode<int>> curr = beforeStart->next, prev = nullptr, next = curr->next;
  i=s;
  while (i <= f) { // running from s to f
    next = curr->next;
    curr->next = prev;
    prev = curr;
    curr = next;
    i++;
  }

  /* Adjusting the pointers */
  beforeStart->next->next = next;
  beforeStart->next = prev;
}

void print(shared_ptr<LinkedListNode<int>> head) {
  if (head) {
    cout << head->data << " ";
    print(head->next);
  }
}
