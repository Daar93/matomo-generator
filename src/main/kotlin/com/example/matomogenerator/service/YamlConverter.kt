package com.example.matomogenerator.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.springframework.stereotype.Component

@Component
class YamlConverter {
    private val objectMapper: ObjectMapper = ObjectMapper(YAMLFactory())

    fun <T> toYaml(yamlObject: T): String {
        val yamlContent = objectMapper.writeValueAsString(yamlObject).removePrefix("---\n")
        return "```yaml\n$yamlContent```"
    }
}