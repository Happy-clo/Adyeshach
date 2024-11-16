package ink.ptms.adyeshach.core.event

import ink.ptms.adyeshach.core.entity.EntityInstance
import org.bukkit.command.CommandSender
import taboolib.platform.type.BukkitProxyEvent

/**
 * 玩家使用指令删除单位
 */
class AdyeshachEntityRemoveByCommandEvent(val entity: List<EntityInstance>, val player: CommandSender) : BukkitProxyEvent()