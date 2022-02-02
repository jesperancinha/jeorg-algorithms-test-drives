package org.jesperancinha.algorithms.bfs.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StationTest : FunSpec({

    test("should return name") {
        val station = Station("Moncarapacho", "Carnaval", mutableListOf())
        station.name shouldBe "Moncarapacho"
    }
})
