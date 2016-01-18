package main

import "fmt"

func main() {

    fmt.Println(generatePrimes(20))
}

func generatePrimes(n int) []int {
    var primes []int
    isPrime := make([]bool, n+1)

    /* Initialize the boole array */
    for i:=0; i<n+1; i++ {
      isPrime[i] = true
    }

    for p:=2; p<n; p++ {
      if (isPrime[p]) {
        primes = append(primes, p);
        fmt.Printf("%v\n", p)
      }

      // Iterate over its multiples an make them false
      for j:=p; j<=n; j=j+p {
        isPrime[j] = false
      }
    }
    return primes
}
