package main

import (
  "fmt"
)

func main() {

  var array = []int{2, 1, 1, 3, 4, 1, 4, 1, 5, 1, 1, 6, 6, 7, 8, 0, 0}

  fmt.Println("Before Deletion : ", array)

  DeleteKeyFromArray(1, array)

  fmt.Println("After Deletion : ", array)
}

func DeleteKeyFromArray(key int, array []int) {

  writeIndex := 0

  for i:=0; i < len(array); i++ {
    if array[i] != key {
      array[writeIndex] = array[i]
      writeIndex++
    }
  }

  // make all the elements after writeIndex to default value
  for i:=writeIndex; i < len(array); i++ {
    array[i] = 0
  }
}
