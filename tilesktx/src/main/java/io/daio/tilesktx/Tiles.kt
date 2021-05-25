package io.daio.tilesktx

import androidx.wear.tiles.builders.LayoutElementBuilders
import androidx.wear.tiles.builders.TileBuilders
import androidx.wear.tiles.builders.TimelineBuilders

fun TileBuilders.Tile.Builder.timeline(builderFunc: TimelineBuilders.Timeline.Builder.() -> TimelineBuilders.Timeline.Builder): TileBuilders.Tile.Builder {
    return setTimeline(builderFunc(TimelineBuilders.Timeline.builder()))
}

fun TimelineBuilders.Timeline.Builder.timelineEntry(builderFunc: TimelineBuilders.TimelineEntry.Builder.() -> TimelineBuilders.TimelineEntry.Builder): TimelineBuilders.Timeline.Builder {
    return addTimelineEntry(builderFunc(TimelineBuilders.TimelineEntry.builder()))
}

fun TimelineBuilders.TimelineEntry.Builder.setLayout(layout: LayoutElementBuilders.Layout.Builder.() -> LayoutElementBuilders.Layout.Builder): TimelineBuilders.TimelineEntry.Builder {
    return setLayout(layout(LayoutElementBuilders.Layout.builder()))
}

fun root(layout: () -> LayoutElementBuilders.LayoutElement.Builder): LayoutElementBuilders.Layout.Builder {
    return LayoutElementBuilders.Layout.builder().setRoot(layout())
}

fun text(layout: LayoutElementBuilders.Text.Builder.() -> LayoutElementBuilders.Text.Builder): LayoutElementBuilders.Text.Builder {
    return layout(LayoutElementBuilders.Text.builder())
}

fun image(layout: LayoutElementBuilders.Image.Builder.() -> LayoutElementBuilders.Image.Builder): LayoutElementBuilders.Image.Builder {
    return layout(LayoutElementBuilders.Image.builder())
}

fun column(layout: LayoutElementBuilders.Column.Builder.() -> Unit): LayoutElementBuilders.LayoutElement.Builder {
    return LayoutElementBuilders.Column.builder().apply { layout(this) }
}

fun row(layout: LayoutElementBuilders.Row.Builder.() -> Unit): LayoutElementBuilders.LayoutElement.Builder {
    return LayoutElementBuilders.Row.builder().apply { layout(this) }
}

fun box(layout: LayoutElementBuilders.Box.Builder.() -> Unit): LayoutElementBuilders.LayoutElement.Builder {
    return LayoutElementBuilders.Box.builder().apply { layout(this) }
}

fun arc(layout: LayoutElementBuilders.Arc.Builder.() -> Unit): LayoutElementBuilders.LayoutElement.Builder {
    return LayoutElementBuilders.Arc.builder().apply { layout(this) }
}
