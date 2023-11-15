package com.example.matomogenerator.service

import com.example.matomogenerator.model.MatomoResource
import com.example.matomogenerator.model.MatomoResourceRepository
import org.springframework.stereotype.Service

@Service
class MatomoResourceService(private val repository: MatomoResourceRepository) {
    fun createResource(resource: MatomoResource): MatomoResource {
        val existingResource = repository.findByMetadataNameAndMetadataNamespace(
                resource.metadata.name, resource.metadata.namespace
        )

        if (existingResource.isPresent) {
            throw IllegalArgumentException("Resource with name ${resource.metadata.name} in namespace ${resource.metadata.namespace} already exists")
        }

        return repository.save(resource)
    }
}
