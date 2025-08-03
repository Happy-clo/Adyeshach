package ink.ptms.adyeshach.core.bukkit.data

/**
 * Adyeshach
 * ink.ptms.adyeshach.core.bukkit.data.GameProfileAction
 *
 * 定义了与游戏配置文件相关的操作枚举类
 * 这些操作用于管理玩家在游戏中的显示和状态更新
 *
 * @author 坏黑
 * @since 2022/12/13 11:18
 */
enum class GameProfileAction {

    /**
     * 添加玩家到游戏
     * 用于将玩家添加到游戏世界或玩家列表中
     */
    ADD_PLAYER,

    /**
     * 更新玩家的游戏模式
     * 例如：生存模式、创造模式、冒险模式、旁观模式等
     */
    UPDATE_GAME_MODE,

    /**
     * 更新玩家在列表中的显示状态
     * 控制玩家是否在玩家列表（Tab列表）中可见
     */
    UPDATE_LISTED,

    /**
     * 更新玩家的延迟信息
     * 用于显示玩家的网络延迟（ping值）
     */
    UPDATE_LATENCY,

    /**
     * 更新玩家的显示名称
     * 修改玩家在游戏中显示的名称
     */
    UPDATE_DISPLAY_NAME,

    /**
     * 移除玩家（旧版本兼容）
     * 用于支持旧版本的玩家移除操作
     */
    LEGACY_REMOVE_PLAYER;

    companion object {

        /**
         * 初始化操作列表
         * 
         * @return 返回除LEGACY_REMOVE_PLAYER外的所有操作列表
         * 这些操作通常用于初始化或更新玩家信息
         */
        fun initActions() = listOf(ADD_PLAYER, UPDATE_GAME_MODE, UPDATE_LATENCY, UPDATE_DISPLAY_NAME, UPDATE_LISTED)
    }
}
