package ca.tetervak.kittymessage5.model

import java.io.Serializable

data class Envelope(val isUrgent: Boolean, val textMessage: String): Serializable