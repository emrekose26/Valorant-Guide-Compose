package com.emrekose.valorantguide.common.extensions

val String.Companion.EMPTY get() = ""

fun String?.orEmpty() = this ?: ""