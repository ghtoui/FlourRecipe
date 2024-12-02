package com.ghtoui.core.extensions.string

/**
 * 文字列がURLかどうかチェックする
 *
 * @return [Boolean]
 */
val String.isURL: Boolean
    get() = URL_START_PATTERN
        .containsMatchIn(this)

private val URL_START_PATTERN = Regex(
    pattern = "^https?://",
)
