package org.jesperancinha.algorithms.weigh.term.frequency

import org.jesperancinha.algorithms.weigh.term.frequency.TestCases.Companion.testCase1Sympathy
import org.jesperancinha.algorithms.weigh.term.frequency.TestCases.Companion.testCase2FishesAndSalads

fun main(args: Array<String>) {
    val sentencesSympathy = testCase1Sympathy()
    val lsaSympathy = LatentSemanticAnalysisCalculator(sentencesSympathy)
    lsaSympathy.calculateSemanticProximity("sympathy", "professional")
    lsaSympathy.calculateSemanticProximity("important", "professional")
    lsaSympathy.calculateSemanticProximity("empathy", "professional")
    lsaSympathy.calculateSemanticProximity("lgbt", "professional")
    lsaSympathy.calculateSemanticProximity("trust", "professional")
    lsaSympathy.calculateSemanticProximity("lead", "professional")
    lsaSympathy.calculateSemanticProximity("knowledge", "professional")
    lsaSympathy.calculateSemanticProximity("work", "professional")
    lsaSympathy.calculateSemanticProximity("professional", "professional")
    lsaSympathy.calculateSemanticProximity("team", "professional")
    lsaSympathy.calculateSemanticProximity("love", "professional")
    lsaSympathy.calculateSemanticProximity("intelligence", "professional")
    lsaSympathy.calculateSemanticProximity("algorithms", "professional")
    lsaSympathy.calculateSemanticProximity("hashmaps", "professional")

    val sentencesFishAndSalads = testCase2FishesAndSalads()
    val lsaFishAndSalads = LatentSemanticAnalysisCalculator(sentencesFishAndSalads)
    lsaFishAndSalads.calculateSemanticProximity("salad", "fish")
    lsaFishAndSalads.calculateSemanticProximity("sardine", "fish")
    lsaFishAndSalads.calculateSemanticProximity("fish", "barbeque")
    lsaFishAndSalads.calculateSemanticProximity("cabbage", "fish")
    lsaFishAndSalads.calculateSemanticProximity("sauerkraut", "fish")
    lsaFishAndSalads.calculateSemanticProximity("alternative", "fish")

}

