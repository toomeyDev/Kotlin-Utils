import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    println("Enter path of a file or directory, program will " +
            "\noutput size of file(s) present to the terminal:")
    // if valid path argument provided as argument, get filesizes in path directory
    if(args.isNotEmpty()) getFilesInDirectory(args[0])
    else {
        while(true) {
            // continue to ask user for valid input until valid input received
            var uInput = readln()
            if(getFilesInDirectory(uInput) == 1) break
        }
    }
}

fun getFilesInDirectory(dirName: String): Int {
    var status = 0 // track success/failure of the function
    val dirPath = Paths.get(dirName)
    println(dirPath)
    try {
        Files.list(dirPath)
            .filter(Files::isRegularFile)
            .forEach { x -> getFileSize(x.toString()) };
        status = 1 // set status to 1 to signify successful operation
    } catch (e: Exception) {
        println("Error, path $dirPath does not exist in the current filesystem.")
        status =  -1 // set status to -1 to signify error during operation
    }
    return status
}

fun getFileSize(fileName: String) {
    val userFile = File(fileName)
    val fileSize = userFile.length()

    println("The size of ${userFile.name} at $fileName is $fileSize bytes")
}