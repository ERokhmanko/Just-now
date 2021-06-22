fun main() {
    val timeSec = 720

    println("Был(а) в сети ${agoToText(timeSec)}")
}

fun agoToText(timeSec: Int): String {
    return when (timeSec) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> "${minutesToText(timeSec)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "${hoursToText(timeSec)} назад"
        in 24 * 60 * 60 + 1..24 * 2 * 60 * 60 -> "сегодня"
        in 24 * 2 * 60 * 60 + 1..24 * 3 * 60 * 60 -> "вчера"
        else -> "давно"
    }
}

fun minutesToText(timeSec: Int): String {
    val timeMinutes = timeSec / 60

    return when {
        timeMinutes % 10 == 1 && timeMinutes % 100 !== 11 -> "$timeMinutes минуту"
        timeMinutes % 10 in 2..4 && timeMinutes % 100 !in 11..19 -> "$timeMinutes минуты"
        else -> "$timeMinutes минут"
    }
}

fun hoursToText(timeSec: Int): String {
    val timeHours = timeSec / 60 / 60

    return when {
        timeHours % 10 == 1 && timeHours % 100 !== 11 -> "$timeHours час"
        timeHours % 10 in 2..4 && timeHours % 100 !in 11..19 -> "$timeHours часа"
        else -> "$timeHours часов"
    }
}