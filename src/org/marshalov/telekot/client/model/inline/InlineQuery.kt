package org.marshalov.telekot.client.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.Location
import org.marshalov.telekot.client.model.User
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents an incoming inline query (https://core.telegram.org/bots/api#inlinequery).
 * When the user sends an empty query, your bot could return some default or trending results.
 */
@Serializable
data class InlineQuery(
    /**
     * Unique identifier for this query
     */
    val id: String = "",
    /**
     * Sender
     */
    val from: User = User(),
    /**
     * Text of the query (up to 256 characters)
     */
    val query: String = "",
    /**
     * Offset of the results to be returned, can be controlled by the bot
     */
    val offset: String = "",
    /**
     * Optional. Sender location, only for bots that request user location
     */
    val location: Location? = null
) : TelegramObject
