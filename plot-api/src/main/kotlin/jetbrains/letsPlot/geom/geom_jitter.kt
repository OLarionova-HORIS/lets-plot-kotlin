/*
 * Copyright (c) 2020. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.letsPlot.geom

import jetbrains.letsPlot.Geom
import jetbrains.letsPlot.Pos
import jetbrains.letsPlot.Stat
import jetbrains.letsPlot.intern.layer.LayerBase
import jetbrains.letsPlot.intern.layer.PosOptions
import jetbrains.letsPlot.intern.layer.SamplingOptions
import jetbrains.letsPlot.intern.layer.StatOptions
import jetbrains.letsPlot.intern.layer.geom.JitterAesthetics
import jetbrains.letsPlot.intern.layer.geom.JitterMapping

@Suppress("ClassName")
/**
 * Jittered Points, especially for discrete plots or dense plots.
 * @param data dictionary or pandas DataFrame, optional.
 *     The data to be displayed in this layer. If None, the default, the data
 *     is inherited from the plot data as specified in the call to [lets_plot][jetbrains.letsPlot.lets_plot].
 * @param stat string, optional.
 *     The statistical transformation to use on the data for this layer, as a string. Supported transformations:
 *     "identity" (leaves the data unchanged), "count" (counts number of points with same x-axis coordinate),
 *     "bin" (counts number of points with x-axis coordinate in the same bin), "smooth" (performs smoothing -
 *     linear default)
 * @param position string, optional.
 *     Position adjustment, either as a string ("identity", "stack", "dodge", ...), or the result of a call to a
 *     position adjustment function.
 * @param width double, optional.
 *     width for jitter, default=0.4
 * @param height double, optional.
 *     height for jitter, default=0.4
 * @param x x-axis value.
 * @param y y-axis value.
 * @param alpha transparency level of the point
 *     Understands numbers between 0 and 1.
 * @param color (colour) color of the geometry.
 *     Can be continuous or discrete. For continuous value this will be a color gradient between two colors.
 * @param fill color to paint shape's inner points.
 *     Is applied only to the points of shapes having inner points.
 * @param shape shape of the point.
 * @param size size of the point.
 * @param mapping set of aesthetic mappings.
 *     Aesthetic mappings describe the way that variables in the data are
 *     mapped to plot "aesthetics".
 */
class geom_jitter(
    data: Any? = null,
    stat: StatOptions = Stat.identity,
    position: PosOptions = Pos.jitter,
    show_legend: Boolean = true,
    sampling: SamplingOptions? = null,
    override val x: Double? = null,
    override val y: Double? = null,
    override val alpha: Double? = null,
    override val color: Any? = null,
    override val fill: Any? = null,
    override val shape: Any? = null,
    override val size: Double? = null,
    override val stroke: Double? = null,
    override val width: Double? = null,
    override val height: Double? = null,
    mapping: JitterMapping.() -> Unit = {}
) : JitterAesthetics,
    LayerBase(
        mapping = JitterMapping().apply(mapping).seal(),
        data = data,
        geom = Geom.jitter(),
        stat = stat,
        position = when {
            // init with the given width/height if its parameters was not specified
            position.parameters.isEmpty() -> Pos.position_jitter(width, height)
            else -> position
        },
        show_legend = show_legend,
        sampling = sampling
    )