package ink.ptms.adyeshach.core.bukkit.data

import org.bukkit.entity.Villager
import taboolib.library.xseries.XMaterial

/**
 * @author sky
 * @since 2020-08-19 17:24
 */
data class VillagerData(val type: Type = Type.PLAINS, val profession: Profession = Profession.NONE) {

    override fun toString(): String {
        return "$type $profession"
    }

    /**
     * 村民的生物群系类型
     * 
     * 每种类型对应一个 Minecraft 中的材料，用于在界面中表示
     * 
     * @property material 与该村民类型关联的材料
     */
    enum class Type(val material: XMaterial) {

        /**
         * 沙漠村民类型，使用沙子材质表示
         */
        DESERT(XMaterial.SAND),

        /**
         * 丛林村民类型，使用丛林原木材质表示
         */
        JUNGLE(XMaterial.JUNGLE_LOG),

        /**
         * 平原村民类型，使用草方块材质表示
         */
        PLAINS(XMaterial.GRASS_BLOCK),

        /**
         * 热带草原村民类型，使用金合欢原木材质表示
         */
        SAVANNA(XMaterial.ACACIA_LOG),

        /**
         * 雪地村民类型，使用雪方块材质表示
         */
        SNOW(XMaterial.SNOW_BLOCK),

        /**
         * 沼泽村民类型，使用史莱姆方块材质表示
         */
        SWAMP(XMaterial.SLIME_BLOCK),

        /**
         * 针叶林村民类型，使用云杉原木材质表示
         */
        TAIGA(XMaterial.SPRUCE_LOG);

        /**
         * 将枚举值转换为 Bukkit 的 Villager.Type 类型
         * 
         * @return 对应的 Bukkit 村民类型
         */
        fun toBukkit(): Villager.Type {
            return Villager.Type.valueOf(name)
        }
    }

    /**
     * 村民的职业类型
     * 
     * 每种职业对应一个 Minecraft 中的工作站方块材料，用于在界面中表示
     * 
     * @property material 与该职业关联的材料
     */
    enum class Profession(val material: XMaterial) {

        /**
         * 无职业，使用石头材质表示
         */
        NONE(XMaterial.STONE),

        /**
         * 盔甲匠，使用高炉材质表示
         */
        ARMORER(XMaterial.BLAST_FURNACE),

        /**
         * 屠夫，使用烟熏炉材质表示
         */
        BUTCHER(XMaterial.SMOKER),

        /**
         * 制图师，使用制图台材质表示
         */
        CARTOGRAPHER(XMaterial.CARTOGRAPHY_TABLE),

        /**
         * 牧师，使用酿造台材质表示
         */
        CLERIC(XMaterial.BREWING_STAND),

        /**
         * 农民，使用堆肥桶材质表示
         */
        FARMER(XMaterial.COMPOSTER),

        /**
         * 渔夫，使用木桶材质表示
         */
        FISHERMAN(XMaterial.BARREL),

        /**
         * 制箭师，使用制箭台材质表示
         */
        FLETCHER(XMaterial.FLETCHING_TABLE),

        /**
         * 皮匠，使用炼药锅材质表示
         */
        LEATHERWORKER(XMaterial.CAULDRON),

        /**
         * 图书管理员，使用附魔台材质表示
         */
        LIBRARIAN(XMaterial.ENCHANTING_TABLE),

        /**
         * 石匠，使用切石机材质表示
         */
        MASON(XMaterial.STONECUTTER),

        /**
         * 傻子，使用绿色羊毛材质表示
         */
        NITWIT(XMaterial.GREEN_WOOL),

        /**
         * 牧羊人，使用织布机材质表示
         */
        SHEPHERD(XMaterial.LOOM),

        /**
         * 工具匠，使用锻造台材质表示
         */
        TOOLSMITH(XMaterial.SMITHING_TABLE),

        /**
         * 武器匠，使用砂轮材质表示
         */
        WEAPONSMITH(XMaterial.GRINDSTONE);

        /**
         * 将枚举值转换为 Bukkit 的 Villager.Profession 类型
         * 
         * @return 对应的 Bukkit 村民职业
         */
        fun toBukkit(): Villager.Profession {
            return Villager.Profession.valueOf(name)
        }
    }
}