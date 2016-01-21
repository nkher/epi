package main

import (
    "fmt"
    "strconv"
)

func main() {

    str := "12345"
    fmt.Println("Equivalent number is:", Stoi(str)+1)

    num := 12345
    fmt.Println("Equivalent string is : ", Itoa(num) + "678")
}

func Stoi(str string) int {
    isNeg := false
    if str[0] == '-' {
      isNeg = true
    }
    num := 0
    for i:=0; i< len(str); i++ {
        dig := int(str[i] - '0') // this converts to byte therefore explicit conversion
        num = num * 10 + dig
    }
    if (isNeg) {
      return num * (-1)
    }
    return num
}

func Itoa(x int) string {
    isNeg := false
    if x < 0 {
      x = x * (-1)
      isNeg = true
    }
    str := ""
    for x > 0 {
        str += strconv.FormatInt(int64(x%10), 10)
        x /= 10
    }
    if (isNeg) {
      str += string('-')
    }
    str = Reverse(str) // using out reverse function
    return str
}

func Reverse(s string) string {
    runes := []rune(s)
    for i, j :=0, len(runes) - 1; i < j; i, j = i+1, j-1 {
        runes[i], runes[j] = runes[j], runes[i]
    }
    return string(runes)
}
