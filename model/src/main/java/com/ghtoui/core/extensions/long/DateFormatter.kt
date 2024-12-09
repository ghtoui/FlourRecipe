package com.ghtoui.core.extensions.long

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * LongからZonedDateTimeに変換する
 *
 * @return [ZonedDateTime]
 */
fun Long.formatDateTime(): ZonedDateTime = ZonedDateTime.ofInstant(
    Instant.ofEpochSecond(this),
    ZoneId.systemDefault(),
)
