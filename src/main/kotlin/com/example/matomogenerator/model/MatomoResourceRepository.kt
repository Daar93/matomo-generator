package com.example.matomogenerator.model

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MatomoResourceRepository : JpaRepository<MatomoResource, Long> {
    fun findByMetadataNameAndMetadataNamespace(name: String, namespace: String): Optional<MatomoResource>
}
