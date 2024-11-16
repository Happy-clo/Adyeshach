package ink.ptms.adyeshach.core.event

import ink.ptms.adyeshach.core.entity.EntityInstance
import org.bukkit.command.CommandSender
import taboolib.platform.type.BukkitProxyEvent

/**
 * 玩家使用指令克隆单位
 */
class AdyeshachEntityCloneByCommandEvent(val entity: EntityInstance, val newId: String, val player: CommandSender) : BukkitProxyEvent()