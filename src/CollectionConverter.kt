import java.util.HashMap;
import java.util.HashSet;


fun main(){
    println("Input a phrase and it will be converted to various collections " +
            "formats from both Kotlin & Java: ");
    var uInput:String = getString()
    println("Entered phrase: $uInput")

    // create a Kotlin list out of user input string
    val kotListFormat = uInput.toList()
    // create a java HashMap out of user input string
    val javaHashMapFormat = getAsHashMap(uInput)
    // create a java HashSet out of user input string
    val javaHashSetFormat = getAsHashSet(uInput)
    uInput.to
    println("In Kotlin list format: \n${kotListFormat}")
    println("In Java HashMap format: \n${javaHashMapFormat}")
    println("In Java HashSet format (unique characters only): \n" +
            "${javaHashSetFormat}")
}

fun getString(): String{
    print("Your phrase: ")
    return readln()
}

fun getAsHashMap(inputString: String): java.util.HashMap<String, String>{
    val stringInfoHash = java.util.HashMap<String, String>()
    stringInfoHash.put(inputString, "type: String")
    stringInfoHash.put("Size:", inputString.length.toString())
    stringInfoHash.put("Lowercase:", inputString.lowercase())
    stringInfoHash.put("Uppercase:", inputString.uppercase())
    return stringInfoHash;
}

fun getAsHashSet(inputString: String): java.util.HashSet<Char>{
    val characters = inputString.toList()
    // store all unique characters in the string inside this hashset
    val uniqueCharacters = java.util.HashSet<Char>();
    for(character in characters){
        uniqueCharacters.add(character)
    }
    return uniqueCharacters;
}