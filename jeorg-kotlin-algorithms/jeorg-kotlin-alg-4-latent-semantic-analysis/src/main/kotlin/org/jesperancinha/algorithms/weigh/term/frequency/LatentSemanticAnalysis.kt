package org.jesperancinha.algorithms.weigh.term.frequency

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jetbrains.numkt.array
import org.jetbrains.numkt.core.ExperimentalNumkt
import org.jetbrains.numkt.core.KtNDArray
import org.jetbrains.numkt.linalg.Linalg

val stopWords = arrayOf(
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
    "is"
)
val roots = arrayOf("professional", "cert", "LGBT")

fun main(args: Array<String>) {
    val sentence1 =
        "Your sympathy is such an important quality to have at work. That way you show professionalism and people will trust you better"
    val sentence2 =
        "I love it that you show vulnerability. Some people call it being unsure, but I call it being empathetic. It is a real important quality for the professional life in our company"
    val sentence3 =
        "The fact that you can remain calm and smile in face of our difficult questions makes me want to work with you"
    val sentence4 =
        "I have seen that you show to defend LGBTIQA+ rights everywhere you go. It is really important for us to have someone like you. It shows that you have no prejudice within and outside the professional sphere"
    val sentence5 =
        "I have seen that you have taken lots or courses and certifications and you showed us with your assignment that you are very professional. The fact that you are also filled with sympathy is really a major plus"
    val sentence6 =
        "Your smile will definitely motivate our professional life. Very good on you that you are so intelligent at the same time!"
    val sentence7 =
        "An open professional environment where an LGBTIQA+ feels that they can be themselves is always more professional. This is why I also think you are a perfect match."
    val tf = calculateU(listOf(sentence1, sentence2, sentence3, sentence4, sentence5, sentence6, sentence7))

    calculateSVD(tf)
}

@ExperimentalNumkt
fun calculateSVD(tf: List<Array<Any>>) {
//    array(arrayOf(1, 2, 3))
    val tfArray =  tf.map { it.copyOfRange(1,it.size).map { number -> number as Int } } as List<List<Int>>
//    val ktndArray  = org.jetbrains.numkt.array<Long>(tfArray)
//    print(ktndArray)
//    Linalg.svd(ktndArray)
}

fun calculateU(sentences: List<String>): List<Array<Any>> {

    val wordsPerSentence =
        sentences.map {
            it
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .split(" ")
        }


    ConsolerizerComposer.outSpace()
        .magenta("1. Stemming => We reduce the words to known root forms")
        .magenta("2. Removing stop words => We remove words thar are normally neutral and we identify as of no interest to our analysis")
    val allWords = wordsPerSentence.asSequence().flatten()
        .filter { !stopWords.contains(it) && it.isNotEmpty() }
        .map {
            val findLast = roots.findLast { root -> it.startsWith(root) }
            if (findLast != null) {
                if (it.length >= findLast.length) {
                    findLast
                } else
                    it
            } else {
                it
            }
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