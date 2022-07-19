package com.emrekose.valorantguide.common.extensions

import com.emrekose.valorantguide.BuildConfig

fun debug(body: () -> Unit) {
    if (BuildConfig.DEBUG) body()
}