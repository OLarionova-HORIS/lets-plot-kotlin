package com.jetbrains.datalore.plot.layer.stat

import com.jetbrains.datalore.plot.layer.WithGroupOption

class CountMapping(
    override var x: Any? = null,
    override var y: Any? = null,
    override var alpha: Any? = null,
    override var color: Any? = null,
    override var fill: Any? = null,
    override var width: Any? = null,
    override var size: Any? = null,
    override var weight: Any? = null,
    override var group: Any? = null
) : CountAesthetics, WithGroupOption {
    override fun seal() = super.seal() + group()
}