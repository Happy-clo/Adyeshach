package ink.ptms.adyeshach.core.event

import ink.ptms.adyeshach.core.entity.type.AdyHuman
import taboolib.platform.type.BukkitProxyEvent
import java.util.*

class AdyeshachPlayerUUIDGenerateEvent(val entity: AdyHuman, var uniqueId: UUID) : BukkitProxyEvent()