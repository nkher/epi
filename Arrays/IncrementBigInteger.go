package main

import "fmt"

func main() {

    var bigInteger = []int{9, 9, 9}
    fmt.Println("Before Incrementing : ", bigInteger)
    bigInteger = IncrementBigInteger(bigInteger)
    fmt.Println("After Incrementing : ", bigInteger)
}

// This function takes in an input integer which represents
// a number. The function adds one to the number and returns
// the result in the form of an array.
func IncrementBigInteger(bigInteger []int) []int {

    n := len(bigInteger)
    bigInteger[n-1] = bigInteger[n-1] + 1 // add 1 to the last digit

    for i:=n-1 ; i>0 && bigInteger[i] == 10; i-- {
      bigInteger[i] = 0;
      bigInteger[i-1] = bigInteger[i-1] + 1;
    }

    if bigInteger[0] == 10 {
      b := 1
      bigInteger = append([]int{b}, bigInteger...) // preprending 1 to the array
      bigInteger[1] = 0 // putting zero at the second last element
    }

    return bigInteger
}
