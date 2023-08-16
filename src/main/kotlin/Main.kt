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


    //according to assignment instructions, in here we are using random number generator to get the user inputs.
    val money = (1..1000).random()


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


    fun deposit(amount: Int): Int{

        accountBalance += amount
        println("You deposited $amount dollars to your account")
        println("You current balance is $accountBalance dollars")

        return amount
    }



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

    fun transfer(mode: String){

        val transferAmount: Int

        when(mode){

            "withdraw" ->{

                if(accountType == "debit"){
                    transferAmount = debitWithdraw(money)
                }else{
                    transferAmount = withDraw(money)
                }
                println("The amount you withdrew is $transferAmount dollars")
            }

            "deposit" ->{

                if(accountType == "credit"){
                    transferAmount = creditDeposit(money)
                }else{
                    transferAmount = deposit(money)
                }

                println("The amount you deposited is $transferAmount dollars")
            }
            else -> return
        }
    }

    var isSystemOpen = true
    var option = 0

    while(isSystemOpen){

        println("What would you like to do?")
        println("1. Check bank account balance")
        println("2. Withdraw money")
        println("3. Deposit money")
        println("4. Close the app")
        println("Which option do you choose? (1,2,3 or 4)")

        //according to assignment instructions, in here we are using random number generator to get the user inputs.
        option = (1..5).random()
        println("You selected number $option option")

        when(option){

            1 -> {
                println("Current account balance is $accountBalance dollars")
            }
            2 -> {
                transfer("withdraw")
            }
            3 -> {
                transfer("deposit")
            }
            4 -> {
                isSystemOpen = false
                println("The system is closed")
            }
            else -> continue
        }
    }
}


