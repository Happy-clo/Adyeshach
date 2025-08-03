package ink.ptms.adyeshach.core.bukkit

/**
 * Minecraft Ender Dragon's flight and behavior phases
 * Minecraft 末影龙的飞行和行为阶段
 *
 * @author sky
 * @since 2020-08-05 0:36
 */
enum class BukkitDragonPhase {

    /**
     * Dragon circling around the center portal
     * 末影龙绕着中央传送门盘旋
     */
    CIRCLING,

    /**
     * Dragon performing strafing attacks
     * 末影龙进行扫射攻击
     */
    STRAFING,

    /**
     * Dragon flying towards portal to land
     * 末影龙飞向传送门准备降落
     */
    FLYING_TO_THE_PORTAL_TO_LAND,

    /**
     * Dragon landing on the portal
     * 末影龙在传送门上降落
     */
    LANDING_ON_THE_PORTAL,

    /**
     * Dragon taking off from the portal
     * 末影龙从传送门起飞
     */
    TAKING_OFF_FROM_THE_PORTAL,

    /**
     * Dragon landed and performing breath attack
     * 末影龙已降落并进行龙息攻击
     */
    LANDED_PREFORMING_BREATH_ATTACK,

    /**
     * Dragon landed and searching for player to attack
     * 末影龙已降落并寻找玩家进行攻击
     */
    LANDED_LOOKING_FOR_A_PLAYER_FOR_BREATH_ATTACK,

    /**
     * Dragon roaring before breath attack
     * 末影龙在进行龙息攻击前的咆哮
     */
    LANDED_ROAR_BEFORE_BEGINNING_BREATH_ATTACK,

    /**
     * Dragon charging towards player
     * 末影龙向玩家冲刺
     */
    CHARGING_PLAYER,

    /**
     * Dragon flying to portal before death
     * 末影龙飞向传送门准备死亡
     */
    FLYING_TO_PORTAL_TO_DIE,

    /**
     * Dragon hovering without AI control
     * 末影龙悬停且无AI控制
     */
    HOVERING_WITH_NO_AI;

    companion object {

        /**
         * Get dragon phase by index
         * 通过索引获取龙的阶段
         *
         * @param index phase index 阶段索引
         * @return corresponding dragon phase 对应的龙阶段
         */
        fun of(index: Int): BukkitDragonPhase {
            return values()[index]
        }
    }
}