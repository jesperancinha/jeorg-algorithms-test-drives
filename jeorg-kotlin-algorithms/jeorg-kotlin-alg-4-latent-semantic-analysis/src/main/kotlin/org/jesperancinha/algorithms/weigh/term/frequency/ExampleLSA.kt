package org.jesperancinha.algorithms.weigh.term.frequency

import Jama.EigenvalueDecomposition
import Jama.Matrix
import Jama.SingularValueDecomposition

class ExampleLSA {
    fun runExample() {
        val n = 4

        var a: Matrix = Matrix.constructWithCopy(
            arrayOf(
                doubleArrayOf(2.0, 4.0),
                doubleArrayOf(1.0, 3.0),
                doubleArrayOf(0.0, 0.0),
                doubleArrayOf(0.0, 0.0),
            )
        )

        val singularValueDecomposition = SingularValueDecomposition(a)
        print("The real V =")
        singularValueDecomposition.v.print(9, 6)
        print("The real U =")
        singularValueDecomposition.u.print(9, 6)
        print("The real S =")
        singularValueDecomposition.s.print(9, 6)
        print("A =")
        a.print(9, 6)
        a = a.times(a.transpose())
        print("ATA =")
        a.print(9, 6)

        val e: EigenvalueDecomposition = a.eig()
        val v: Matrix = e.v
        val d: Matrix = e.d

        print("A =")
        a.print(2, 0)
        print("D =")
        d.print(9, 6)
        print("V =")
        v.print(9, 6)
        print("||V * V^T - I|| = ")
        println(v.times(v.transpose()).minus(Matrix.identity(n, n)).normInf())
        print("||AV - DV|| = ")
        println(a.times(v).minus(v.times(d)).normInf())
    }
}