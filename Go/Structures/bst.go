package bst

import "fmt"

type BstNode struct {
    Left *BstNode
    Data int
    Right *BstNode
}

func Insert(root *BstNode, data int) *BstNode {
  if root == nil {
      return &BstNode{nil, data, nil}
  }
  if data < root.Data {
    root.Left = Insert(root.Left, data)
    return root
  } else {
    root.Right = Insert(root.Right, data)
    return root
  }
}

func Inorder(root *BstNode) {
  if root != nil {
    Inorder(root.Left)
    fmt.Print(root.Data, " ")
    Inorder(root.Right)
  }
}

func Height(root *BstNode) int {
  if root == nil {
    return 0
  }
  leftHeight := Height(root.Left)
  rightHeight := Height(root.Right)
  if leftHeight > rightHeight {
    return leftHeight+1
  }
  return rightHeight+1
}
