package ink.ptms.adyeshach.core.event

import ink.ptms.adyeshach.core.entity.EntityInstance
import org.bukkit.entity.Player
import taboolib.platform.type.BukkitProxyEvent

/**
 * 玩家打开编辑器面板
 */
class AdyeshachEditPanelOpenEvent(val entity: EntityInstance, val player: Player) : BukkitProxyEvent()