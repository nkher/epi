package main

import (
  "fmt"
  "epi/utils"
  "bytes"
  "strconv"
)

func main() {

  num1, num2 := "1234567", "123456"

  fmt.Println("Multiplying integers ", num1, " and ", num2, ". Result is : ", MultiplyBigIntegers(num1, num2))

}

func MultiplyBigIntegers(num1, num2 string) string {

  isPositive := true

  if num1[0] == '-' {
    isPositive = !isPositive
    num1 = num1[1:len(num1)]
  }

  if num2[0] == '-' {
    isPositive = !isPositive
    num2 = num2[1:len(num2)]
  }

  // reverse numbers
  num1, num2 = utils.Reverse(num1), utils.Reverse(num2)

  num1L, num2L := len(num1), len(num2)

  result := make([]int, (num1L + num2L))

  for i:=0; i < num1L; i++ {

    for j:=0; j < num2L; j++ {

        result[i+j] += int(rune(num1[i]-'0')) * int(rune(num2[j]-'0')) // add the carry, if there is any from previous step
        result[i+j+1] += result[i+j] / 10 // shift the carry to the next position
        result[i+j] %= 10
      }
  }

  i := num1L + num2L - 1
  for result[i] == 0 && i != 0 {
    i--
  }

  var buffer bytes.Buffer
  if !isPositive && result[i] != 0 {
    buffer.WriteString("-")
  }

  for i >= 0 {
    buffer.WriteString(strconv.Itoa(result[i]))
    i--
  }

  return buffer.String()
}
