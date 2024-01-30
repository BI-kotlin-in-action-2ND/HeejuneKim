package kr.bi

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val operators = readln().split(" ").map { it.toInt() }.toIntArray()

    val (max, min) = calculateMaxMin(n, numbers, operators)
    println(max)
    println(min)
}

fun calculateMaxMin(
    n: Int,
    numbers: List<Int>,
    operators: IntArray,
): Pair<Int, Int> {
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    fun calculate(
        current: Int,
        index: Int,
        add: Int,
        subtract: Int,
        multiply: Int,
        divide: Int,
    ) {
        if (index == n) {
            max = maxOf(max, current)
            min = minOf(min, current)
            return
        }

        if (add > 0) calculate(current + numbers[index], index + 1, add - 1, subtract, multiply, divide)
        if (subtract > 0) calculate(current - numbers[index], index + 1, add, subtract - 1, multiply, divide)
        if (multiply > 0) calculate(current * numbers[index], index + 1, add, subtract, multiply - 1, divide)
        if (divide > 0) calculate(current / numbers[index], index + 1, add, subtract, multiply, divide - 1)
    }

    calculate(numbers[0], 1, operators[0], operators[1], operators[2], operators[3])
    return Pair(max, min)
}
