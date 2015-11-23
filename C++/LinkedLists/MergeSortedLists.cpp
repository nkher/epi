#include <iostream>

#include "../Library/LinkedListNode.h"

using namespace std;

void append_node(shared_ptr<LinkedListNode<int>> *, shared_ptr<LinkedListNode<int>> *);

shared_ptr<LinkedListNode<int>> merge_two_sortedlists(shared_ptr<LinkedListNode<int>> m,
                                                      shared_ptr<LinkedListNode<int>> n) {

      shared_ptr<LinkedListNode<int>> head(new LinkedListNode<int>);
      auto tail = head;

      while (m && n) {
        append_node(m->data <= n->data ? &m : &n, &tail);
      }

      // Append the remaining nodes of m and n
      tail->next = m ? m : n;
      return head->next;
}

void append_node(shared_ptr<LinkedListNode<int>> *node, shared_ptr<LinkedListNode<int>> *tail) {

  (*tail)->next = *node; // make the node as tail's next
  *tail = *node; // update the tail
  *node = (*node)->next;
}
