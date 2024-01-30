package kr.bi

/*
    https://www.acmicpc.net/problem/1629
 */

fun main(args: Array<String>) {
    val (a, b, c) = readln().split(" ").map { it.toLong() }

    println(go(a, b, c))
}

fun go(
    a: Long,
    b: Long,
    c: Long,
): Long {
    if (b == 1L) return a % c

    val midResult = go(a, b / 2, c)
    val result = (midResult * midResult) * c
    return if (b % 2 == 0L) result else (result * a % c)
}
