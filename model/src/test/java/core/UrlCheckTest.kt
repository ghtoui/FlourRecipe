package core

import com.ghtoui.core.extensions.string.isURL
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UrlCheckTest {
    @Test
    fun `文字列がhttp始まりのとき`() {
        val resultMap: Map<String, Boolean> = mapOf(
            "https://exampl.com" to true,
            "http://exampl.com" to true,
            "パン作りの本 2ページ目" to false,
            "パン http://exampl.com" to false,
            "" to false,
        )

        resultMap.map {
            assertThat(it.key.isURL).isEqualTo(it.value)
        }
    }
}
