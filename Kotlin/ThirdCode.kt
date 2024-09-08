// src/Main.kt
package main

// Base class
open class Animal(val name: String, val age: Int) {
    open fun makeSound() {
        println("$name makes a sound.")
    }

    fun describe() {
        println("This is $name, and it is $age years old.")
    }
}

// Subclass for Dog
class Dog(name: String, age: Int, val breed: String) : Animal(name, age) {
    override fun makeSound() {
        println("$name barks.")
    }

    fun fetch() {
        println("$name is fetching the ball.")
    }
}

// Subclass for Cat
class Cat(name: String, age: Int, val color: String) : Animal(name, age) {
    override fun makeSound() {
        println("$name meows.")
    }

    fun purr() {
        println("$name is purring.")
    }
}

// Extension functions
fun Animal.isOld(): Boolean {
    return age > 10
}

fun Animal.introduce() {
    println("Hi, I am $name. I am $age years old.")
}

// Special classes
data class AnimalStatus(val animal: Animal, val healthStatus: String)

sealed class AnimalType {
    object Mammal : AnimalType()
    object Bird : AnimalType()
}

// Main function
fun main() {
    val dog = Dog("Buddy", 5, "Golden Retriever")
    val cat = Cat("Whiskers", 12, "Siamese")

    dog.introduce()
    dog.makeSound()
    dog.fetch()

    cat.introduce()
    cat.makeSound()
    cat.purr()

    println("Is ${dog.name} old? ${dog.isOld()}")
    println("Is ${cat.name} old? ${cat.isOld()}")
}
