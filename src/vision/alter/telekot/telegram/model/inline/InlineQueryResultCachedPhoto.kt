package vision.alter.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.InlineKeyboardMarkup
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a link to a photo stored on the Telegram servers (https://core.telegram.org/bots/api#inlinequeryresultcachedphoto).
 * By default, this photo will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the photo.
 */
@Serializable
data class InlineQueryResultCachedPhoto(
    /**
     * Type of the result, must be photo
     */
    val type: String = "photo",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * A valid file identifier of the photo
     */
    val photoFileId: String = "",
    /**
     * Optional. Title for the result
     */
    val title: String? = null,
    /**
     * Optional. Short description of the result
     */
    val description: String? = null,
    /**
     * Optional. Caption of the photo to be sent, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the photo caption. See formatting options for more details.
     */
    val parseMode: String? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the photo
     */
    val inputMessageContent: InputMessageContent? = null
) : TelegramObject,
    InlineQueryResult
