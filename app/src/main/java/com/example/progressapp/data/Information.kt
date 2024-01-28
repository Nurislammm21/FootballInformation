package com.example.progressapp.data

import java.io.Serializable

data class Information(
        val id: String = "",
        val title: String = "",
        val description: String = "",
        val descriptionLong: String = "",
        val buttonText: String = "",
        val headerImageIdResource: Int = 0,
        val headerImageUrl: String? = null,
        val teamUrl: String = ""
): Serializable




