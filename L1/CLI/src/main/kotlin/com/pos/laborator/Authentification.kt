package com.pos.laborator

import java.io.File
import java.lang.Exception
import java.sql.DriverManager

class Authentification {
    companion object {
        fun login(username: String, password: String): String {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                val con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=Europe/Paris",
                    "manager",
                    File("parola.txt").readText()
                );
                val stmt = con.createStatement()
                val rs = stmt.executeQuery("select id from User where nume='$username' and parola='$password'")
                while (rs.next())
                {
                    val id = rs.getInt(1)
                    val rs1 = stmt.executeQuery("select n.nume from NivAcc n,UserNiv u where u.id_user=$id and u.id_niv=n.id")
                    var result: String = ""
                    while(rs1.next())
                    {
                        result += rs1.getString(1) + " "
                    }
                    return result
                };
                con.close();
            } catch (e: Exception) {
                println(e.printStackTrace());
            }
            return ""
        }
    }
}