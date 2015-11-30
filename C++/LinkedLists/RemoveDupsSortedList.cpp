#include <iostream>

#include "../Library/LinkedListNode.h"

using namespace std;

shared_ptr<LinkedListNode<int>> remove_dups(shared_ptr<LinkedListNode<int>>& head) {
  auto iter = head->next, prev = head;
  while (iter) { // iterate through the list
    while (iter && iter->data == prev->data) {
      iter = iter->next;
    }
    if (!iter) break;
    prev->next = iter;
    prev = iter;
    iter = iter->next;
  }

  return head;
}

void print(shared_ptr<LinkedListNode<int>>& head) {
  auto iter = head;
  while (iter) {
    cout << iter->data << ", ";
    iter = iter->next;
  }
  cout << endl;
}
