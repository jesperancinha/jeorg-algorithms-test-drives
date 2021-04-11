package org.jesperancinha.algorithms.weigh.term.frequency

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val sentence1 =
        "I travelled in Germany using the Deutsche Autobahn. I loved the views when going from Berlin to Köln. It is a convenient and fast way to travel. Some find it less dangerous than riding a bike"
    val sentence2 =
        "In Germany we could drive fast and for a long time in some of the Autobahn. We could experience views going very fast. It was convenient for some and dangerous for others. Many loved driving there"

    ConsolerizerComposer.outSpace()
        .blue(title("Similarity using the Weigh Term Frequency Algorithm"))
        .magenta("Sentence 1: %s", sentence1)
        .magenta("Sentence 2: %s", sentence2)
        .reset()

    val similarity = findSimilarity(sentence1, sentence2)
    ConsolerizerComposer.outSpace()
        .cyan("The similarity is %s", similarity)
    ConsolerizerComposer.outSpace()
        .cyan("Our sentences as %.2f%s similar to each other", similarity * 100, "%%")
}

fun findSimilarity(sentence1: String, sentence2: String): Double {

    val words1 = sentence1.replace(".", "").split(" ")
    val words2 = sentence2.replace(".", "").split(" ")

    val allWords = words1.plus(words2).distinct().sorted()

    println(words1)
    println(words2)
    ConsolerizerComposer.outSpace()
        .orange(allWords)

    val tf = allWords.map {
        mutableListOf(it, words1.filter { word -> word == it }.count(), words2.filter { word -> word == it }.count())
    }

    val document1: List<Int> = tf.map { it[1] as Int }
    val document2: List<Int> = tf.map { it[2] as Int }

    tf.forEach {
        ConsolerizerComposer.outSpace()
            .yellow("%s\t%s\t%s", (it[0] as String).padStart(10), it[1], it[2])
    }

    val product = multiply(document1, document2)
    println(product)
    val length1 = pLength(document1)
    val length2 = pLength(document2)
    ConsolerizerComposer.outSpace()
        .green(length1)
    ConsolerizerComposer.outSpace()
        .green(length2)
    return product.toDouble() / (length1 * length2).toDouble()
}

fun pLength(document1: List<Int>): Long {
    var total: Long = 0
    for (i in document1.indices) {
        total += document1[i] * document1[i]
    }
    return sqrt(total.toDouble()).toLong()
}

fun multiply(document1: List<Int>, document2: List<Int>): Long {
    var total: Long = 0
    for (i in document1.indices) {
        total += document1[i] * document2[i]
    }
    return total
}
