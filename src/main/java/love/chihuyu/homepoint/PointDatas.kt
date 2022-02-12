package love.chihuyu.homepoint

import love.chihuyu.homepoint.HomePoint.Companion.plugin
import love.chihuyu.homepoint.point.Point
import org.bukkit.Location
import java.util.UUID

object PointDatas {

    val points: MutableMap<UUID, MutableList<Point>> = mutableMapOf()

    fun save() {
        points.forEach {
            plugin.config.set(it.key.toString(), it.value)
        }
        plugin.saveConfig()
    }

    fun load() {
        points.clear()
        plugin.config.getKeys(false).forEach {
            points[UUID.fromString(it)] = plugin.config.get(it) as MutableList<Point>
        }
    }
}