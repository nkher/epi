#include <iostream>

#include "../Library/LinkedListNode.h"

using namespace std;

/* Deletion without pointer is also possible */
bool delete_node_alternate(shared_ptr<LinkedListNode<int>>& node) {
  if (!node || !node->next) {
    return false;
  }
  shared_ptr<LinkedListNode<int>> next = node->next;
  node->data = next->data;
  node->next = next->next;
  return true;
}


/* Deletion using pointer */
bool delete_node(shared_ptr<LinkedListNode<int>>* node){
  if (!(*node) || !(*node)->next) {
    return false;
  }
  shared_ptr<LinkedListNode<int>> next = (*node)->next;
  (*node)->data = next->data;
  (*node)->next = next->next;
  return true;
}

void print(shared_ptr<LinkedListNode<int>> h) {
  while (h) {
    cout << h->data << ", ";
    h = h->next;
  }
  cout << endl;
}
