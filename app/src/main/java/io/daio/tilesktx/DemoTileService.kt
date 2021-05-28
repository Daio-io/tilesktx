package io.daio.tilesktx

import androidx.wear.tiles.TileProviderService
import androidx.wear.tiles.builders.ResourceBuilders
import androidx.wear.tiles.builders.TileBuilders
import androidx.wear.tiles.readers.RequestReaders
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.guava.future

private const val RESOURCES_VERSION = "1"

class DemoTileService : TileProviderService() {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun onTileRequest(requestParams: RequestReaders.TileRequest): ListenableFuture<TileBuilders.Tile> {
        return scope.future {
            tile {
                setResourcesVersion(RESOURCES_VERSION)
                timeline {
                    timelineEntry {
                        setLayout {
                            root {
                                column {
                                    addContent(text { setText("Hello") })
                                    addContent(text { setText("World!") })
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResourcesRequest(requestParams: RequestReaders.ResourcesRequest) = scope.future {
        ResourceBuilders.Resources.builder()
            .setVersion(RESOURCES_VERSION)
            .build()
    }
}
