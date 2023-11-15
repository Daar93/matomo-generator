package com.example.matomogenerator

import com.example.matomogenerator.service.YamlConverter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MatomoGeneratorApplication

fun main(args: Array<String>) {
	runApplication<MatomoGeneratorApplication>(*args)
}
