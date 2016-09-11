package main

import (
    "fmt"
    "../Helper"
)

func main() {

    var list = []string{"debitcard", "silent", "elvis", "badcredit", "lives", "freedom", "listen", "levis"}
    result := FindAnagramGroups(list)

    for i := range result {
        fmt.Println(result[i])
    }
}

func FindAnagramGroups(list []string) [][]string {

    result := [][]string{}
    hashmap := make(map[string][]string) // hashmap from string to list of strings

    for i := range list {
        str := list[i]
        sortedStr := stringutils.SortString(str)
        val, ok := hashmap[sortedStr];
        if ok {
            val = append(val, str)
            hashmap[sortedStr] = val
         } else {
            var sublist = []string{}
            sublist = append(sublist, str)
            hashmap[sortedStr] = sublist
         }
    }
    // doing the grouping here
    for k, v := range hashmap {
        fmt.Printf("%v: %v\n", k, v)
        result = append(result, v)
    }
    return result
}
