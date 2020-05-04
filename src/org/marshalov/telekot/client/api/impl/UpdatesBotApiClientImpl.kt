package org.marshalov.telekot.client.api.impl

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.api.ApiClientWrapper
import org.marshalov.telekot.client.api.UpdatesBotApiClient
import org.marshalov.telekot.client.model.updates.Update
import org.marshalov.telekot.client.model.updates.WebhookInfo

/**
 * Getting Updates Telegram Bot API implementation.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 */
class UpdatesBotApiClientImpl(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
) : UpdatesBotApiClient {

    override suspend fun getUpdates(
        offset: Int?,
        limit: Int?,
        timeout: Int?,
        allowedUpdates: List<String>?
    ): List<Update> =
        api.getMethodResult(
            ::getUpdates, mapOf(
                "offset" to offset,
                "limit" to limit,
                "timeout" to timeout,
                "allowed_updates" to allowedUpdates
            )
        )

    override suspend fun setWebhook(
        url: String,
        certificate: String?,
        maxConnections: Int?,
        allowedUpdates: List<String>?
    ): Boolean =
        api.getMethodResult(
            ::setWebhook, mapOf(
                "url" to url,
                // @TODO: ????!!!!
                "certificate" to null,
                "max_connections" to maxConnections,
                "allowed_updates" to allowedUpdates
            )
        )

    override suspend fun deleteWebhook(): Boolean =
        api.getMethodResult(::deleteWebhook)

    override suspend fun getWebhookInfo(): WebhookInfo =
        api.getMethodResult(::getWebhookInfo)

    // ------------------------------------------------------------------------------------------------------------- //

    private val api = ApiClientWrapper(apiToken, apiUrl, client)

}
