package app.futured.academyproject.tools.serialization

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Custom serializer for ZonedDateTime properties. The serialization is using ISO-8601 [2021-01-13T13:17:32+00:00] format.
 *
 * The usage:
 * @Contextual @SerialName("dateTime") val dateTime: ZonedDateTime,
 */
object ZonedDateTimeSerializer : KSerializer<ZonedDateTime> {

    override val descriptor = PrimitiveSerialDescriptor(ZonedDateTime::class.simpleName.toString(), PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: ZonedDateTime) {
        val format = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        val string = format.format(value)
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): ZonedDateTime {
        val string = decoder.decodeString()
        return ZonedDateTime.parse(string)
    }
}
