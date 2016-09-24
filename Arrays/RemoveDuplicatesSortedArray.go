package main

import (
  "fmt"
)

func main() {

  var sortedArr = []int{2, 2, 3, 3, 5, 5, 5, 7, 7, 7, 7, 8, 9, 25, 25}

  fmt.Println("Before Removal : ", sortedArr)

  RemoveDuplicatesFromSortedArray(sortedArr)

  fmt.Println("After Removal : ", sortedArr)
}

func RemoveDuplicatesFromSortedArray(sortedArr []int) {

  var lastValue int = sortedArr[0]
  writeIndex := 1

  for i:=1; i < len(sortedArr); i++ {
    if sortedArr[i] != lastValue {
        sortedArr[writeIndex] = sortedArr[i]
        writeIndex++
        lastValue= sortedArr[i]
    }
  }

  for i:=writeIndex; i < len(sortedArr); i++ {
    sortedArr[i] = 0
  }
}
