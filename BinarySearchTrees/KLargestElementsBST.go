package main

import (
    "fmt"
    "../Structures/bst"
)

func main() {

    var root *bst.BstNode
    root = bst.Insert(root, 19)
    root = bst.Insert(root, 7)
    root = bst.Insert(root, 43)
    root = bst.Insert(root, 3)
    root = bst.Insert(root, 11)
    root = bst.Insert(root, 23)
    root = bst.Insert(root, 47)
    root = bst.Insert(root, 2)
    root = bst.Insert(root, 5)
    root = bst.Insert(root, 17)
    root = bst.Insert(root, 37)
    root = bst.Insert(root, 53)
    root = bst.Insert(root, 13)
    root = bst.Insert(root, 29)
    root = bst.Insert(root, 41)
    root = bst.Insert(root, 31)

    var kLargestElements []int
    kLargestElements = FindKLargestElements(root, 3)

    fmt.Println("3 largest elements are : ", kLargestElements)

    //bst.Inorder(root)
    fmt.Println()
}

func FindKLargestElements(root *bst.BstNode, n int) []int {
    var kLargestElements []int
    return findKLargestElementsHelper(root, n, kLargestElements)
}

func findKLargestElementsHelper(node *bst.BstNode, n int, kLargestElements []int) []int {
    if node != nil && len(kLargestElements) < n {
      kLargestElements = findKLargestElementsHelper(node.Right, n, kLargestElements)
      if (len(kLargestElements) < n) {
        kLargestElements = append(kLargestElements, node.Data)
        kLargestElements = findKLargestElementsHelper(node.Left, n, kLargestElements)
      }
    }
    return kLargestElements
}
