#include <iostream>

#include "../Library/LinkedListNode.h"

using namespace std;

shared_ptr<LinkedListNode<int>> reverse_list(const shared_ptr<LinkedListNode<int>>& head) {
    if (!head || !head->next) {
      return head;
    }
    auto temp = reverse_list(head->next);
    head->next->next = head;
    head->next = nullptr;
    return temp;
}

void print(shared_ptr<LinkedListNode<int>> head) {
  if (head) {
    cout << head->data << " " << endl;
    print(head->next);
  }
}
