package net.flow9.thisiskotlin.myapplication1


data class Model(
    var title: String,
    var dateTime: String,
    var url: String,
    var isLike: Boolean = false
)