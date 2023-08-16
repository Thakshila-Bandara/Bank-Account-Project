


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

    //according to assignment instructions, in here we are using random number generator to get the user inputs.
    var accountBalance = (1..1000).random()
    println("Current account balance is $accountBalance dollars")

    //according to assignment instructions, in here we are using random number generator to get the user inputs.
    val money = (1..1000).random()
//    println("You deposided/withdrawed $money dollars")

    var output = 0

    fun withDraw (amount: Int): Int{
        accountBalance -= amount

        println("You have withdrawn $amount dollars from your account.")
        println("Your current account balance is $accountBalance dollars")

        return amount
    }

    fun debitWithdraw(amount: Int): Int{

        if (accountBalance == 0){

            println("Can't withdraw, no money in this account")
            return accountBalance
        }else if(amount > accountBalance){

            println("Not enough money on this account! The checking balance is $accountBalance dollars.")
            return 0
        }else{
            return withDraw(amount)
        }
    }

    output = debitWithdraw(money)
    println("The amount you withdraw is $output dollars")

    fun deposit(amount: Int): Int{

        accountBalance += amount
        println("You deposited $amount dollars to your account")
        println("You current balance is $accountBalance dollars")

        return amount
    }

//    output = deposit(money)
//    println(output)

    fun creditDeposit(amount: Int): Int{

        if(accountBalance == 0){
            println("You don't need to deposit anything in order to pay off the account since it has already been paid off")
            return accountBalance
        }else if(accountBalance + amount > 0){

            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The checking balance is $accountBalance dollsrs.")
            return 0
        }else if(amount == -accountBalance){
            accountBalance = 0
            println("You have paid off this account!")
            return amount
        }else{
            return deposit(amount)
        }
    }

    output = creditDeposit(money)
    println(output)
}


