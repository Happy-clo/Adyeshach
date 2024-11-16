package ink.ptms.adyeshach.impl.entity.trait

import ink.ptms.adyeshach.impl.entity.trait.impl.*
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object TraitFactory {

    val traits = ArrayList<Trait>()

    @Awake(LifeCycle.ENABLE)
    fun init() {
        traits += TraitCommand
        traits += TraitPatrol
        traits += TraitSit
        traits += TraitTitle
        traits += TraitViewCondition
    }

    fun getTraitById(id: String): Trait? {
        return traits.firstOrNull { it.id() == id }
    }
}