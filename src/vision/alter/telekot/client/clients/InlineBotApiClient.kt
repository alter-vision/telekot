package vision.alter.telekot.client.clients

import io.ktor.client.HttpClient
import vision.alter.telekot.telegram.api.InlineBotApi
import vision.alter.telekot.telegram.model.inline.InlineQueryResult

/**
 * Inline Mode Telegram Bot API implementation.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 */
class InlineBotApiClient(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
) : InlineBotApi {

    override suspend fun answerInlineQuery(
        inlineQueryId: String,
        results: List<InlineQueryResult>,
        cacheTime: Int?,
        isPersonal: Boolean?,
        nextOffset: String?,
        switchPmText: String?,
        switchPmParameter: String?
    ): Boolean =
        api.getMethodResult(
            ::answerInlineQuery, mapOf(
                "inline_query_id" to inlineQueryId,
                "results" to results,
                "cache_time" to cacheTime,
                "is_personal" to isPersonal,
                "next_offset" to nextOffset,
                "switch_pm_text" to switchPmText,
                "switch_pm_parameter" to switchPmParameter
            )
        )

    // ------------------------------------------------------------------------------------------------------------- //

    private val api = ApiClientWrapper(apiToken, apiUrl, client)
}
