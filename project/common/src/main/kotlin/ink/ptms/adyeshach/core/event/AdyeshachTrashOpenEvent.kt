package ink.ptms.adyeshach.core.event

import org.bukkit.entity.Player
import taboolib.platform.type.BukkitProxyEvent

/**
 * 玩家打开垃圾篓面板
 */
class AdyeshachTrashOpenEvent(val player: Player) : BukkitProxyEvent()