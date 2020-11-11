package app.weather.extensions

fun CharSequence?.isLongerThan(other: CharSequence?) = lengthOrZero() > other.lengthOrZero()

fun CharSequence?.lengthOrZero() = this?.length ?: 0
