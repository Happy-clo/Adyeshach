package ink.ptms.adyeshach.core.bukkit

/**
 * Bukkit 实体动画枚举类
 *
 * @author sky
 * @since 2020-08-28 1:49
 */
enum class BukkitAnimation(val id: Int) {

    /**
     * 主手挥动动画
     */
    SWING_MAIN_HAND(0),

    /**
     * 受伤动画
     */
    TAKE_DAMAGE(1),

    /**
     * 离开床动画
     */
    LEAVE_BED(2),

    /**
     * 副手挥动动画
     */
    SWING_OFFHAND(3),

    /**
     * 暴击效果动画
     */
    CRITICAL_EFFECT(4),

    /**
     * 魔法暴击效果动画
     */
    MAGIC_CRITICAL_EFFECT(5)

}