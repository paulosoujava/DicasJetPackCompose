package com.paulo.waystoincrease.kotlinTips

import kotlin.random.Random

fun main() {
    val persons = createData()

    //TIP FOLD
    /*println(sumOfAges(persons))
    println(persons.sumOf { it.age })
    println(persons.sumOfAgesWithExtensions())*/

    //TIP ASSOCIATE
    println( createMap(persons))
    println( createMapWithAssociate(persons))
    println( persons.associate { it.name to it.age })
    println( createMapWithAssociateBy(persons))
    println( persons.associateBy { it.name  })
}

fun sumOfAges(list: List<Person>): Int {

    println("WITH FOLD ${ list.fold(0){ acc, person -> acc + person.age}}")


    var sum = 0
    for (item in list) {
        sum += item.age
    }

    return sum
}
//WITH EXTENSION
fun  List<Person>.sumOfAgesWithExtensions(): Int {


    var sum = 0
    for (item in this) {
        sum += item.age
    }

    return sum
}

fun createMap(list: List<Person>):Map<String, Person>{
    val map = mutableMapOf<String, Person>()
    for (person in  list){
        map[person.name] = person
    }
    return map
}
fun createMapWithAssociate(list: List<Person>):Map<String, Int>{
    return return list.associate { person -> Pair(person.name, person.age) }
}
fun createMapWithAssociateBy(list: List<Person>):Map<String, Person>{
    return return list.associateBy { person -> person.name}
}



data class Person(val name: String, val age: Int, val sex: Boolean)

fun createData(): List<Person> {
    val list = mutableListOf<Person>()
    repeat(10) {
        val name = (65 * it).toChar().toString()
        val age = Random.nextInt(80)
        val sex = it % 2 == 0
        list.add(Person(name, age, sex))
    }
    return list
}