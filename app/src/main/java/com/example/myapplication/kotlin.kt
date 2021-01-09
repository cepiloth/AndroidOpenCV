package com.example.myapplication


// 제어 흐름
// -if, else
fun main(args:Array<String>)
{
    val a = 5
    if(a == 5)
        println("yes")
    else
        println("no")

    // 엘비스 연산자
    // null 허용
    val number: Int? = null
    val number2 = number ?: 10
    println(number2)

    val number3: Int = 100;
    val number4 = number3 ?: 10;
    println(number4)
    println(number4)
}