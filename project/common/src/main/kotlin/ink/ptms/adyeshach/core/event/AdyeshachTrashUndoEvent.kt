package ink.ptms.adyeshach.core.event

import org.bukkit.command.CommandSender
import taboolib.platform.type.BukkitProxyEvent
import java.io.File

/**
 * 玩家从垃圾篓里回收单位
 */
class AdyeshachTrashUndoEvent(val player: CommandSender, val file: File) : BukkitProxyEvent()