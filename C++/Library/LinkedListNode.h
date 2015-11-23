#ifndef LINKED_LIST_PROTOTYPE_H_
#define LINKED_LIST_PROTOTYPE_H_

#include <memory>

using std::shared_ptr;

template <typename T>
struct LinkedListNode {
  T data;
  shared_ptr<LinkedListNode<T>> next;
};

#endif
