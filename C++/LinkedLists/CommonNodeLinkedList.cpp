#include <iostream>

#include "../Library/LinkedListNode.h"

using namespace std;

void advance_head_by_k(shared_ptr<LinkedListNode<int>>*, int k);
shared_ptr<LinkedListNode<int>> find_common_node(shared_ptr<LinkedListNode<int>>&, shared_ptr<LinkedListNode<int>>&);
int list_length(shared_ptr<LinkedListNode<int>>);

shared_ptr<LinkedListNode<int>> find_common_node(shared_ptr<LinkedListNode<int>>& h1,
                                                 shared_ptr<LinkedListNode<int>>& h2) {

      int len_h1 = list_length(h1), len_h2 = list_length(h2);

      // advance the longer list by the difference between both the lists
      advance_head_by_k(len_h1 > len_h2 ? &h2 : &h2, abs(len_h1 - len_h2));

      // now advance together and check for common node
      while (h1 && h2 && h1 != h2) {
        h1 = h1->next;
        h2 = h2->next;
      }

      return h1;
}

int list_length(shared_ptr<LinkedListNode<int>> h) {
  int len = 0;
  while (h) {
    len++;
    h = h->next;
  }
  return len;
}

void advance_head_by_k(shared_ptr<LinkedListNode<int>>* h, int k) { // passing a pointer here
  while (k--) {
    *h = (*h)->next;
  }
}
