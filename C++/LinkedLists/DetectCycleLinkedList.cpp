#include <iostream>

#include "../Library/LinkedListNode.h"

using namespace std;

shared_ptr<LinkedListNode<int>> detect_cycle(shared_ptr<LinkedListNode<int>>& head) {

  shared_ptr<LinkedListNode<int>> slow = head, fast = head;

  while (fast && fast->next) {
    slow = slow->next;
    fast = fast->next->next;
    if (slow == fast) {
      break;
    }
  }

  // error check
  if (!fast || !fast->next) {
    return nullptr;
  }

  // Now slow = fast
  slow = head;

  while (slow != fast) {
    slow = slow->next;
    fast = fast->next;
  }

  if (!slow) return nullptr;

  return slow;
}
