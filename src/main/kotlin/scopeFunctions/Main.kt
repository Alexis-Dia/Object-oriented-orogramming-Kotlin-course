package scopeFunctions

import scopeFunctions.dto.Person

inline fun <T> T?.whenNullAlt(block: (T?) -> T): T {
    if (this == null) {
        return block(this) // "this" is superfluous, but enforces same return type
    } else {
        return this
    }
}

fun <T> T?.calculate1(block: (T?) -> T) : T {
    return block(this);
}

fun Int.calculate2(x: Int, block: (y: Int) -> Int) : Int {
    println(x)
    println(block)
    return block(x)
}

fun <T> T.calculate3(block: (T) -> T) : T {
    return block(this)
}

fun main() {
    println("Hello, World!")

    Person("Alice", 20, "Amsterdam")

    val person = Person("Alice", 20, "Amsterdam")
    val ooo = person.let {
        println(it)
        it.newName("Alicea")
        it.incrementAge()
        println(it)
    }
    println("ooo = "+ ooo)




        val numberList = mutableListOf<Double>()
        numberList.also { println("Заполнение списка") }
            .apply {
                add(2.71)
                add(3.14)
                add(1.0)
            }
            .also { println("Сортировка списка") }
            .sort()
        println(numberList)


    fun printHello(name: String): Unit {
        if (name != null)
            println("Hello $name")
        else
            println("Hi there!")
        // `return Unit` or `return` is optional
    }

    //printHello(null)

    val x : Int? = null
    println(x.whenNullAlt { 42 })
    //println(x.whenNullAlt { "does not compile" })

    //val calc = x.calculate1 { 4 }
    //println(calc)

    val ttt = 100
    val calc2 = ttt.calculate2(50) {
        a -> a+a
    }
    println(calc2)

    val ttt3 = 100
    val calc3 = ttt3.calculate3 {
        a -> 2 * (a + a)
    }
    println(calc3)
}