package jetbrains.datalorePlot.intern.layer.stat

import jetbrains.datalorePlot.intern.Options
import jetbrains.datalorePlot.intern.layer.geom.BarAesthetics

interface CountAesthetics : BarAesthetics {
    val weight: Any?

    override fun seal(): Options {
        return super.seal() +
                Options.of("weight" to weight)
    }
}