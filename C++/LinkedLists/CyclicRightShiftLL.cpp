#include <iostream>

#include "../Library/LinkedListNode.h"

using namespace std;

shared_ptr<LinkedListNode<int>> cyclic_right_shift(shared_ptr<LinkedListNode<int>> head, int k) {

  if (!head) {
    return head;
  }

  auto new_end = head;
  int n=1;
  while (n < k) {
    new_end = new_end->next;
    n++;
  }

  auto new_start = new_end->next;
  auto mid = new_start;

  while (mid->next) {
    mid = mid->next;
  }

  mid->next = head;
  new_end->next = nullptr;

  return new_start;
}

void print(shared_ptr<LinkedListNode<int>>& head) {
  auto iter = head;
  while (iter) {
    cout << iter->data << " ";
    iter = iter->next;
  }
  cout << endl;
}
