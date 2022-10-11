import java.util.*

fun <T: Comparable<T>> merge(left_part: List<T>, right_part: List<T>) : List<T> {
    val b: MutableList<T> = mutableListOf()
    var p1 = 0
    var p2 = 0
    while (p1 < left_part.size && p2 < right_part.size) {
        if (left_part[p1] == right_part[p2]) {
            b.add(left_part[p1])
            p1++
            p2++
        } else if (left_part[p1] < right_part[p2])
            b.add(left_part[p1++])
        else
            b.add(right_part[p2++])
    }
    while (p1 < left_part.size) b.add(left_part[p1++])
    while (p2 < right_part.size) b.add(right_part[p2++])

    return b
}

fun <T: Comparable<T>> List<T>.mergeSorted(l: Int = 0, r: Int = size) : List<T> {
    if (l+1 == r)
        return listOf(this[l])
    val m = (l+r)/2	// [l, r) -> [l, m) + [m, r)
    return merge(mergeSorted(l, m), mergeSorted(m, r))
}


fun main() {

    for (test in 1..100) {
        val a = List(50) { Random().nextInt() }
        if (a.sorted() != a.mergeSorted())
            throw Exception("Sorting is invalid, test $test")
    }
    println("OK")

}
