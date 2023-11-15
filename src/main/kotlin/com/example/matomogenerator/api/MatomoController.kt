package com.example.matomogenerator.api

import com.example.matomogenerator.model.*
import com.example.matomogenerator.service.MatomoResourceService
import com.example.matomogenerator.service.YamlConverter
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/matomo")
class MatomoController(
    private val repository: MatomoResourceRepository,
    private val matomoResourceService: MatomoResourceService,
    private val yamlConverter: YamlConverter
) {
    @PostMapping
    fun createMatomoResource(@RequestBody request: MatomoResourceRequest): ResponseEntity<Any> {
        return try {
            val resource = MatomoResource(
                metadata = Metadata(request.name, request.namespace),
                spec = Spec(request.host)
            )
            matomoResourceService.createResource(resource)
            val yamlString = yamlConverter.toYaml(resource)
            ResponseEntity
                    .ok()
                    .contentType(MediaType.parseMediaType("application/x-yaml"))
                    .body(yamlString)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @GetMapping
    fun listMatomoResources(): ResponseEntity<List<MatomoResource>> {
        return ResponseEntity.ok(repository.findAll())
    }
}