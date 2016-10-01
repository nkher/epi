package main

import (
    "fmt"
    "../Structures/bst"
)

func main() {

    var root *bst.BstNode
    root = bst.Insert(root, 500)
    root = bst.Insert(root, 200)
    root = bst.Insert(root, 100)
    root = bst.Insert(root, 100)
    root = bst.Insert(root, 50)
    root = bst.Insert(root, 250)
    root = bst.Insert(root, 300)
    root = bst.Insert(root, 900)
    root = bst.Insert(root, 1000)
    root = bst.Insert(root, 1000)
    root = bst.Insert(root, 700)
    root = bst.Insert(root, 800)

    ans := findFirstOccurence(root, 100)

    fmt.Println(ans.Data, ans.Right.Data)
}

func FindFirstOccurence(node *bst.BstNode, key int) *bst.BstNode {
    if node == nil {
      return nil
    } else if key == node.Data {
      leftnode := findFirstOccurence(node.Left, key)
      if leftnode == nil {
        return node
      }
    }
    if node.Data < key {
      return findFirstOccurence(node.Right, key)
    }
    return findFirstOccurence(node.Left, key)
}
