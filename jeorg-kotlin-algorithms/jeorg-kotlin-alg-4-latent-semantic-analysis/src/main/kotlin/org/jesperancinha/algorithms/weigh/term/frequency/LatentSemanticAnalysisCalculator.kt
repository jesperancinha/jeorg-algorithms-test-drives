package org.jesperancinha.algorithms.weigh.term.frequency

import Jama.EigenvalueDecomposition
import Jama.Matrix
import Jama.SingularValueDecomposition
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import kotlin.math.abs
import kotlin.math.sqrt

class LatentSemanticAnalysisCalculator(sentences: List<String>) {
    private val resultTable: List<ArrayList<Any>>

    private val stopWords = arrayOf(
        "I",
        "have",
        "show",
        "and",
        "you",
        "Your",
        "your",
        "it",
        "no",
        "that",
        "the",
        "It",
        "a",
        "us",
        "an",
        "are",
        "That",
        "The",
        "at",
        "to",
        "of",
        "or",
        "with",
        "so",
        "can",
        "go",
        "for",
        "in",
        "is",
        "as"
    )
    private val roots = arrayOf("professional", "cert", "lgbt", "empat", "know", "intelli", "hashmap", "lov")


    init {
        resultTable = resultTable(sentences)
    }

    fun calculateSemanticProximity(
        word1: String,
        word2: String
    ) {
        val word1Sanitized = toSanitizedWordForm(word1)
        val word2Sanitized = toSanitizedWordForm(word2)
        val word1Filtered = resultTable.filter { word1Sanitized.startsWith(it[0].toString().toLowerCase()) }[0]
        val word2Filtered = resultTable.filter { word2Sanitized.startsWith(it[0].toString().toLowerCase()) }[0]
        ConsolerizerComposer.outSpace()
            .magenta(
                "The semantic proximity between word %s and %s is %.2f%s",
                word1,
                word2,
                findSimilarity(word1Filtered, word2Filtered) * 100,
                "%%"
            )
    }

    private fun resultTable(sentencesSympathy: List<String>): List<ArrayList<Any>> {
        val tf = calculateU(sentencesSympathy)
        val uTable = calculateUFromSVD(tf)
        val resultTable = (uTable!!.array.zip(tf)).map {
            val arrayListOf = arrayListOf(it.second[0])
            arrayListOf.addAll(it.first.toList())
            arrayListOf
        }
        return resultTable
    }

    private fun findSimilarity(word1: List<Any?>, word2: List<Any?>): Double {

        val document1: List<Double> = word1.subList(1, word1.size).map { it as Double }
        val document2: List<Double> = word2.subList(1, word2.size).map { it as Double }

        val product = multiply(document1, document2)
        val length1 = pLength(document1)
        val length2 = pLength(document2)
        val denominator = length1 * length2
        if (denominator == 0.0) {
            return 0.0
        }
        return abs(product / denominator)
    }

    private fun pLength(document1: List<Double>): Double {
        var total = 0.0
        for (i in document1.indices) {
            total += document1[i] * document1[i]
        }
        return sqrt(total)
    }

    private fun multiply(document1: List<Double>, document2: List<Double>): Double {
        var total = 0.0
        for (i in document1.indices) {
            total += document1[i] * document2[i]
        }
        return total
    }

    private fun calculateUFromSVD(tf: List<Array<Any>>): Matrix? {
        val tfArray = tf.map { it.copyOfRange(1, it.size).map { number -> (number as Int).toDouble() }.toDoubleArray() }
            .toTypedArray()
        val matrixA = Matrix.constructWithCopy(tfArray)
        print("The real A =")
        matrixA.print(2, 2)
        val singularValueDecomposition = SingularValueDecomposition(matrixA)
        print("U =")
        val u = singularValueDecomposition.u
        u.print(2, 2)
        ConsolerizerComposer.outSpace().red("S =");
        singularValueDecomposition.s.print(2, 2)
        ConsolerizerComposer.outSpace().green("V =")
        singularValueDecomposition.v.print(2, 2)
        ConsolerizerComposer.outSpace().blue("D =")
        val e: EigenvalueDecomposition = matrixA.eig()
        val d: Matrix = e.d
        d.print(2, 2)
        return u
    }

    private fun calculateU(sentences: List<String>): List<Array<Any>> {

        val wordsPerSentence =
            sentences.map {
                it
                    .replace(".", "")
                    .replace(",", "")
                    .replace("!", "")
                    .split(" ").map { word -> word.toLowerCase() }
            }


        ConsolerizerComposer.outSpace()
            .magenta("1. Stemming => We reduce the words to known root forms")
            .magenta("2. Removing stop words => We remove words thar are normally neutral and we identify as of no interest to our analysis")
        val allWords = wordsPerSentence.asSequence().flatten()
            .filter { !stopWords.contains(it) && it.isNotEmpty() }
            .map {
                toSanitizedWordForm(it)
            }
            .distinct()
            .sorted().toList()

        val tf = allWords.map {
            val mutableListOf = arrayListOf<Any>(
                it
            )
            wordsPerSentence.forEach { listWords ->
                mutableListOf.add(listWords.filter { word -> word.startsWith(it) }.count())
            }
            mutableListOf.toArray()
        }

        tf.forEach {
            ConsolerizerComposer.outSpace()
                .yellow(
                    "%s\t%s\t%s\t%s\t%s\t%s",
                    (it[0] as String).padStart(20),
                    it[1],
                    it[2],
                    it[3],
                    it[4],
                    it[5],
                    it[6],
                    it[7]
                )
        }

        return tf
    }

    private fun toSanitizedWordForm(it: String): String {
        val findLast = roots.findLast { root -> it.toLowerCase().startsWith(root) }
        return if (findLast != null) {
            if (it.length >= findLast.length) {
                findLast.toLowerCase()
            } else
                it.toLowerCase()
        } else {
            it.toLowerCase()
        }
    }
}