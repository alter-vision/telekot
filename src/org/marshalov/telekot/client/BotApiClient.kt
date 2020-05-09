package org.marshalov.telekot.client

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.factories.BotApiClientFactory
import org.marshalov.telekot.telegram.api.CommonBotApiClient
import org.marshalov.telekot.telegram.api.GamesBotApiClient
import org.marshalov.telekot.telegram.api.InlineBotApiClient
import org.marshalov.telekot.telegram.api.MessageEditingBotApiClient
import org.marshalov.telekot.telegram.api.PaymentsBotApiClient
import org.marshalov.telekot.telegram.api.StickersBotApiClient
import org.marshalov.telekot.telegram.api.UpdatesBotApiClient

/**
 * General interface for accessing all Telegram APIs.
 * @property commonApi Interface for accessing Common Telegram API (https://core.telegram.org/bots/api#available-methods)
 * @property updatesApi Interface for accessing Getting Updates Telegram API (https://core.telegram.org/bots/api#getting-updates)
 * @property inlineApi Interface for accessing Inline Mode Telegram API (https://core.telegram.org/bots/api#inline-mode)
 * @property paymentsApi Interface for accessing Payments Telegram API (https://core.telegram.org/bots/api#payments)
 * @property gamesApi Interface for accessing Games Telegram API (https://core.telegram.org/bots/api#games)
 */
interface BotApiClient {
    /**
     * Interface for accessing Common Telegram API (https://core.telegram.org/bots/api#available-methods)
     */
    val commonApi: CommonBotApiClient

    /**
     * Interface for accessing Updating Messages Telegram API (https://core.telegram.org/bots/api#updating-messages)
     */
    val messageEditingApi: MessageEditingBotApiClient

    /**
     * Interface for accessing Getting Updates Telegram API (https://core.telegram.org/bots/api#getting-updates)
     */
    val updatesApi: UpdatesBotApiClient

    /**
     * Interface for accessing Inline Mode Telegram API (https://core.telegram.org/bots/api#inline-mode)
     */
    val inlineApi: InlineBotApiClient

    /**
     * Interface for accessing Payments Telegram API (https://core.telegram.org/bots/api#payments)
     */
    val paymentsApi: PaymentsBotApiClient

    /**
     * Interface for accessing Games Telegram API (https://core.telegram.org/bots/api#games)
     */
    val gamesApi: GamesBotApiClient

    /**
     * Interface for accessing Stickers Telegram API (https://core.telegram.org/bots/api#stickers)
     */
    val stickersApi: StickersBotApiClient

    companion object {
        /**
         * Special factory method for creating API Client Instance.
         * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
         * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
         * @param client KTOR HTTP Client instance
         * @return Instance of BotApiClient
         */
        operator fun invoke(
            apiToken: String,
            apiUrl: String? = null,
            client: HttpClient? = null
        ): BotApiClient =
            BotApiClientFactory.createApiClient(apiToken, apiUrl, client)
    }
}
