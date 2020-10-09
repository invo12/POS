package com.pos.laborator

fun main(args: Array<String>) {
    var loggedIn = false
    var userName: String
    while(true){
        if(!loggedIn)
        {
            println("username")
            userName = readLine()!!
            println("parola")
            var password = readLine()!!
            println(Authentification.login(userName,password))
        }
    }
}

