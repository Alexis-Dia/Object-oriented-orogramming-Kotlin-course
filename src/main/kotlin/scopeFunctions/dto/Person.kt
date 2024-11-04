package scopeFunctions.dto

class Person(var name: String, var age: Int, val city: String) {
    fun newName(newName: String) {
        name = newName
    }

    fun incrementAge() {
        age += 1
    }

    override fun toString(): String {
        return "dto.Person(name='$name', age=$age, city='$city')"
    }
}