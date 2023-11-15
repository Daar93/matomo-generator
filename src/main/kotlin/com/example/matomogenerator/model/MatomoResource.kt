package com.example.matomogenerator.model

import jakarta.persistence.*
import com.example.matomogenerator.model.Spec;
import com.example.matomogenerator.model.Metadata;
@Entity
@Table(name = "matomo_resource")
data class MatomoResource(
    val apiVersion: String = "glasskube.eu/v1alpha1",
    val kind: String = "Matomo",
    @Column(unique = true)
    @Embedded
    val metadata: Metadata,
    @Embedded
    val spec: Spec
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}