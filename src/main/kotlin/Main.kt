fun main(args: Array<String>) {

    println("Welcome to your banking system")
    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Chcecking account")


    var accountType = ""
    var userChoice = 0

    //according to assignment instructions, in here we are using random number generator to get the user inputs.

    while (accountType == ""){

        println("Choose an option (1, 2 or 3)")
        userChoice = (1..5).random()
        println("The selected user input is... $userChoice")

        when(userChoice){
             1 -> accountType= "debit"
             2 -> accountType = "credit"
             3 -> accountType = "checking"
             else -> continue
        }

        println("You have created a $accountType account")
    }
}
