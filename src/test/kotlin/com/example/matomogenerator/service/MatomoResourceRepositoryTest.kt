package com.example.matomogenerator.service

import com.example.matomogenerator.model.MatomoResource
import com.example.matomogenerator.model.MatomoResourceRepository
import com.example.matomogenerator.model.Metadata
import com.example.matomogenerator.model.Spec
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class MatomoResourceRepositoryTest {
    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var matomoResourceRepository: MatomoResourceRepository

    @Test
    fun WhenFindById_thenReturnMatomoResource() {
        val ingMatomoResource = MatomoResource("mehmet", "std", Metadata("Matomo", "Matomo"), Spec("matomo.minicube"));
        entityManager.persist(ingMatomoResource)
        entityManager.flush()
        val ingMatomoResourceFound = matomoResourceRepository.findByIdOrNull(ingMatomoResource.id!!)
        assertThat(ingMatomoResourceFound == ingMatomoResource)
    }
}


