package io.daio.tilesktx

import android.content.ComponentName
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.wear.tiles.manager.TileClient

class MainActivity : ComponentActivity() {
    private lateinit var tileClient: TileClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = FrameLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContentView(this)
        }

        tileClient = TileClient(
            context = this,
            component = ComponentName(this, DemoTileService::class.java),
            parentView = layout
        )

        tileClient.connect()
    }

    override fun onDestroy() {
        super.onDestroy()
        tileClient.close()
    }
}
