package main

import (
    "fmt"
    "strconv"
)

func main() {
    fmt.Println(LookAndSay(5))
}

func LookAndSay(n int) string {
    str := "1"
    for i:=1; i<n; i++ {
      str = nextNumberString(str)
    }
    return str
}

func nextNumberString(str string) string {
    var s string
    for i:=0; i < len(str); i++ {
        count := 1
        for (i+1) < len(str) && str[i] == str[i+1] {
          i, count = i+1, count+1
        }
        s += strconv.FormatInt(int64(count), 10) + string(str[i])
    }
    return s
}
