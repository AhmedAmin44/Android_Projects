fun main() {
    // Sample list of numbers
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // 1. Basic Kotlin Functions
    println("Sum of numbers: ${sum(numbers)}")

    // 2. Compact Functions
    println("Even numbers: ${numbers.filter { it % 2 == 0 }}")

    // 3. Lambdas and Higher-Order Functions
    val doubledNumbers = transformList(numbers) { it * 2 }
    println("Doubled numbers: $doubledNumbers")

    // 4. List Filters
    val largeNumbers = numbers.filterGreaterThan(5)
    println("Numbers greater than 5: $largeNumbers")
}

// 1. Basic Kotlin Functions
fun sum(numbers: List<Int>): Int {
    return numbers.sum()
}

// 2. Compact Functions
// No additional compact functions are needed; we use built-in functions directly in `main()`.

// 3. Lambdas and Higher-Order Functions
fun transformList(list: List<Int>, transform: (Int) -> Int): List<Int> {
    return list.map(transform)
}

// 4. List Filters
fun List<Int>.filterGreaterThan(threshold: Int): List<Int> {
    return this.filter { it > threshold }
}
