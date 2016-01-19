package main

import (
  "fmt"
  "../Structures"
)

func main() {

  var root *bstnode.BstNode
  root = bstnode.Insert(root, 70)
  root = bstnode.Insert(root, 25)
  root = bstnode.Insert(root, 100)
  root = bstnode.Insert(root, 60)
  root = bstnode.Insert(root, 40)
  root = bstnode.Insert(root, 15)

  bstnode.Inorder(root);

  fmt.Println('\n')
}
