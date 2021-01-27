package ca.tetervak.kittymessage5.domain

import java.io.Serializable

data class Envelope(val isUrgent: Boolean, val textMessage: String): Serializable