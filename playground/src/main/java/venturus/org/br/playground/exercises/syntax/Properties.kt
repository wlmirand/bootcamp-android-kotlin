package venturus.org.br.playground.exercises.syntax

class Foo {
    var foo = "foo" // mutable
    val bar = "bar" // immutable
    var baz = "baz"
        set(value) {
            // Propriedades em Kotlin não quebram encapsulamento.
            TODO("Remover essa linha")
            field = value
        }
}

fun main(args: Array<String>) {
    var foo = Foo()

    foo = Foo()
//    foo.bar = "goosfraba"

    foo.foo = "wololo"
    foo.baz = "tijolo do mal"
    println("foo = ${foo.foo}, bar = ${foo.bar}, baz = ${foo.baz}")
}
