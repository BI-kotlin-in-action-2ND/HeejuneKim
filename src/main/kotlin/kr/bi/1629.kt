package kr.bi

/*
    https://www.acmicpc.net/problem/1629
 */

fun main(args: Array<String>) {
    val (a, b, c) = readlnOrNull()?.split(" ")!!.map { it.toLong() }

    println(go(a, b, c))
}

fun go(
    a: Long,
    b: Long,
    c: Long,
): Long {
    if (b == 1L) return a % c

    var result = go(a, b / 2, c)
    result = (result * result) % c
    if (b % 2L == 1L) result = (result * a) % c
    return result
}
