import java.time.LocalDateTime

// constant to store current date for building calendar, getting date information
val current:LocalDateTime = LocalDateTime.now()

fun main(args: Array<String>) {

    println("Displaying calendar for " +
            "${current.dayOfWeek.toString().lowercase().replaceFirstChar { it.uppercase() }}:")
    showCalendar()
}

// get details for the current day including day of week, month, current year
fun getCurrentDay(): String {

    return "Today is ${current.dayOfWeek.toString().lowercase().replaceFirstChar { it.uppercase()}}, " +
            "${current.month.toString().lowercase().replaceFirstChar { it.uppercase() }} " +
            "${current.dayOfMonth}, ${current.year}"
}

// build a calendar based on current date/time values, print to the screen
// current date will be surrounded by '[]'
fun showCalendar() {
    println(getCurrentDay()) // print the current day and month before showing the calendar
    println("=========================================")
    println("|Sun|Mon|Tues|Wed|Thur|Fri|Sat|")
    for(i in 1..current.month.length(false)){
        if(i % 7 == 0){
            println("${current.withDayOfMonth(i).dayOfMonth}  ")
        } else if(current.withDayOfMonth(i).dayOfMonth == current.dayOfMonth) {
            print("[${current.withDayOfMonth(i).dayOfMonth}]  ")
        }
        else {
            print("${current.withDayOfMonth(i).dayOfMonth}  ")
        }
    }
    println("\n=========================================")
}