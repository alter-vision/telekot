package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents a parameter of the inline keyboard button used to automatically authorize a user.
 * Serves as a great replacement for the Telegram Login Widget when the user is coming from Telegram.
 * All the user needs to do is tap/click a button and confirm that they want to log in.
 * Telegram apps support these buttons as of version 5.7.
 */
@Serializable
data class LoginUrl(
    /**
     * An HTTP URL to be opened with user authorization data added to the query string when the button is pressed.
     * If the user refuses to provide authorization data,
     * the original URL without information about the user will be opened.
     * The data added is the same as described in Receiving authorization data.
     * NOTE: You must always check the hash of the received data to verify the authentication
     * and the integrity of the data as described in Checking authorization.
     */
    val url: String = "",
    /**
     * Optional. New text of the button in forwarded messages.
     */
    val forwardText: String? = null,
    /**
     * Optional. Username of a bot, which will be used for user authorization.
     * See Setting up a bot for more details. If not specified, the current bot's username will be assumed.
     * The url's domain must be the same as the domain linked with the bot.
     * See Linking your domain to the bot for more details.
     */
    val botUsername: String? = null,
    /**
     * Optional. Pass True to request the permission for your bot to send messages to the user.
     */
    val requestWriteAccess: Boolean? = null
) : TelegramObject
