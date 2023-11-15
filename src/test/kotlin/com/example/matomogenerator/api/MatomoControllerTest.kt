package com.example.matomogenerator.api

import com.example.matomogenerator.model.MatomoResource
import com.example.matomogenerator.model.MatomoResourceRequest
import com.example.matomogenerator.service.MatomoResourceService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity.post
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

//@WebMvcTest(MatomoController::class)
//class MatomoControllerTest {
//    @MockBean
//    private lateinit var service: MatomoResourceService
//    @Autowired
//    private lateinit var mockMvc: MockMvc
//    @Test
//    fun createMatomoResource() {
//        val resourceRequest = MatomoResourceRequest("test", "namespace", "host")
//        val resource = MatomoResource("test", "namespace", "host")
//
//        Mockito.`when`(service.createResource(any())).thenReturn(resource)
//
//        mockMvc.perform(post("/api/matomo")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(ObjectMapper().writeValueAsString(resourceRequest)))
//                .andExpect(status().isOk)
//    }
//}