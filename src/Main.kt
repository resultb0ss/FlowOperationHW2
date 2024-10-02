import kotlinx.coroutines.flow.*

suspend fun main() {

    val persons = arrayOf(
        Person("Виктор", 22),
        Person("Степан", 23),
        Person("Анжела", 22),
        Person("Алина", 21),
        Person("Петр", 20),
        Person("Иван", 20),
        Person("Катя", 18),
        Person("Руслан", 19),
        Person("Елена", 29),
        Person("Яна", 17),
    ).asFlow()

    println("Введите первый символ имени")
    val inputFirstCharName = readln()
    println("Введите возраст")
    val inputAgePerson = readln().toInt()

    persons.getPerson(inputFirstCharName,inputAgePerson)


}


suspend fun Flow<Person>.getPerson(first: String, age: Int){
    this.filter { it.name.elementAt(0).toString() == first }
        .filter { it.age == age }
        .collect{ it -> println("${it.name} ${it.age}") }
}


class Person(val name: String, val age: Int)
