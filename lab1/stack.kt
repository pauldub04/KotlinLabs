import java.util.*

class Stack<T>(
    elements: Iterable<T> = mutableListOf()
) {
    private val data: MutableList<T>
    val size get() = data.size

    init {
        data = elements.toMutableList()
    }

    fun push(x: T) {
        data.add(x)
    }
    fun pop(): T {
        try {
            return data.removeLast()
        } catch (e: NoSuchElementException) {
            throw NoSuchElementException("Stack is empty.")
        }
    }
    fun clear() {
        data.clear()
    }
    fun top(): T {
        return pop().also(::push)
    }
}

fun main() {

    for (test in 1..100) {
        val a = List(50) { Random().nextInt() }
        val b = Stack<Int>(a)

        val c = mutableListOf<Int>()
        while (b.size > 0)
            c.add(b.pop())

        if (a.reversed() != c)
            throw Exception("Stack is invalid, test $test")
    }
    println("OK")

}
