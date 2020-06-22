import entities.User

fun main() {

    val scores = listOf(1, 2, 3, 4)
    scores.asSequence()
            .map {it * 2}
            .filter { it > 5 }
            .forEach { println(it) }


    val names = listOf("John", "Mary", "Peter")
    println(nameSequence(names, "Israel"))

    val michael = User("login", 123)
    println(michael.toString())

    val str: String = "Hello"
    str.toByte()

}

fun nameSequence(names: List<String>, query: String) =
    names.asSequence()
            .filter {it == query}
            .firstOrNull()