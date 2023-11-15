package com.example.matomogenerator.model

import jakarta.persistence.Embeddable

@Embeddable
data class Metadata (
        val name: String,
        val namespace: String
)