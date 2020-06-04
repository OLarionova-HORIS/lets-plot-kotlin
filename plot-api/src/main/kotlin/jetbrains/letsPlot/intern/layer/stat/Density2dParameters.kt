/*
 * Copyright (c) 2020. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.letsPlot.intern.layer.stat

import jetbrains.letsPlot.intern.Options
import jetbrains.letsPlot.intern.layer.OptionsCapsule

interface Density2dParameters : OptionsCapsule {
    val bw: Any?
    val kernel: Any?
    val n: Any?
    val adjust: Any?
    val contour: Any?
    val bins: Any?
    val binWidth: Any?

    override fun seal() = Options.of(
        "bw" to bw,
        "kernel" to kernel,
        "n" to n,
        "adjust" to adjust,
        "contour" to contour,
        "bins" to bins,
        "binwidth" to binWidth
    )
}