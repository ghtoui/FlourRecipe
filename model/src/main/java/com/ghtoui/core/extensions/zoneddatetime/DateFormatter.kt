package com.ghtoui.core.extensions.zoneddatetime

import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * 日付文字に変換する
 *
 * @return [String]
 */
fun ZonedDateTime.formatDateTime(): String {
    return this.withZoneSameLocal(ZoneId.systemDefault())
        .format(
            DateTimeFormatter.ofPattern(
                DATE_TIME_FORMAT,
            ),
        )
}

private const val DATE_TIME_FORMAT = "yyyy-MM-dd"
