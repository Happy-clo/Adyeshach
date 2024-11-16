package ink.ptms.adyeshach.core.event

import ink.ptms.adyeshach.core.entity.EntityTypes
import org.bukkit.command.CommandSender
import taboolib.platform.type.BukkitProxyEvent

/**
 * 玩家使用指令创建单位
 */
class AdyeshachEntityCreateByCommandEvent(val type: EntityTypes, val id: String, val player: CommandSender) : BukkitProxyEvent()