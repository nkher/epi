package main

import (
    "fmt"
)

func main() {

    snakestr := SnakeString("Hello-World")
    for i := range snakestr {
      fmt.Println(snakestr[i])
    }
}

func SnakeString(s string) [][]string {

    n := len(s)
    snakestr := make([][]string, 3) // 2D array with 3 rows
    for i := range snakestr {
        snakestr[i] = make([]string, n)
    }

    // variables for first second and third row are i, j and k
    // fill first row
    for i:=1; i<n; i = i+4 {
      snakestr[0][i] = string(s[i])
    }

    for i:=0; i<n; i=i+2 {
      snakestr[1][i] = string(s[i])
    }

    for i:=3; i<n; i=i+4 {
      snakestr[2][i] = string(s[i])
    }

    return snakestr
}
