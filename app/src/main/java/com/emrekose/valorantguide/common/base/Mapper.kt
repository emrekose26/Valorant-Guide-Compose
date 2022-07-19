package com.emrekose.valorantguide.common.base

interface Mapper<F, T> {
    fun mapFrom(from: F): T
}