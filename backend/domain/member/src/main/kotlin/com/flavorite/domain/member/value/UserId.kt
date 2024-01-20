package com.flavorite.domain.member.value

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.flavorite.domain.member.value.UserId.*

@JsonSerialize(using = UserIdSerializer::class)
@JsonDeserialize(using = UserIdDeserializer::class)
data class UserId(
    val value: String
) {

    class UserIdSerializer : JsonSerializer<UserId>() {
        override fun serialize(userId: UserId, p1: JsonGenerator, p2: SerializerProvider) {
            p1.writeString(userId.value)
        }
    }

    class UserIdDeserializer : JsonDeserializer<UserId>() {
        override fun deserialize(jp: JsonParser, p1: DeserializationContext): UserId {
            return UserId(jp.valueAsString)
        }
    }

}