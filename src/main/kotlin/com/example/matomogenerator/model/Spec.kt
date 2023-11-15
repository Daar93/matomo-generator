package com.example.matomogenerator.model

import jakarta.persistence.Embeddable

@Embeddable
data class Spec (
        val host: String
)