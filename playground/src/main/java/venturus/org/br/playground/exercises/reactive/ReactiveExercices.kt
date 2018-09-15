package venturus.org.br.playground.exercises.reactive

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.internal.operators.observable.ObservableRange
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.subjects.BehaviorSubject

fun main(args: Array<String>) {

    println("Start!")

    // TODO RxExercises
    // Create a stream that emits 50 random integers between 0 and 1000
    //Ignore the first 20 items
    //Get only the items that is higher than 500
    //The Observer should print the items with the text "A wild N appears!"
    // where N is the number emitted by the Observable, plus 1000

    val list = mutableListOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    Observable.fromIterable(list)
            .subscribeBy(  // named arguments for lambda Subscribers
                    onNext = { println(it) },
                    onError =  { it.printStackTrace() },
                    onComplete = { println("Done!") }
            )

    //list.toObservable() // extension function for Iterables
            //.filter { it.length >= 5 }
            //.timeInterval()


    println("---------")
    list.add("PPPP")

/*
    val obs = (0..1000).shuffled()
            .toObservable()
            .skip(20)
            .filter{ it > 50 }
            .subscribeBy { println("A Wild ${it+1000} appears") }*/

    println("Done!")
}
