package ink.ptms.adyeshach.core.event

import ink.ptms.adyeshach.core.entity.EntityBase
import ink.ptms.adyeshach.core.entity.EntityInstance
import ink.ptms.adyeshach.core.entity.controller.Controller
import taboolib.platform.type.BukkitProxyEvent

/**
 * 单位变更 ID 事件
 */
class AdyeshachIdChangeEvent(val entity: EntityBase, val before: String, var after: String) : BukkitProxyEvent()