package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        return (first != null ? first.equals(solution.first) : solution.first == null)
                && (last != null ? last.equals(solution.last) : solution.last == null);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Solution solution = new Solution("Donald", "Duck");
        Solution solution1 = new Solution("Donald", "Duck");
        System.out.println("Equals: " + solution.equals(solution1));
        System.out.println(solution.hashCode());
        System.out.println(solution1.hashCode());
    }
}
