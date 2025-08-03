package ink.ptms.adyeshach.impl.nms

import taboolib.module.nms.DataSerializer
import taboolib.module.nms.createDataSerializer
import ink.ptms.adyeshach.core.Adyeshach
import ink.ptms.adyeshach.core.MinecraftEntityPlayerHandler
import ink.ptms.adyeshach.core.MinecraftPacketHandler
import ink.ptms.adyeshach.core.bukkit.data.GameProfile
import ink.ptms.adyeshach.core.bukkit.data.GameProfileAction
import ink.ptms.adyeshach.impl.nms.specific.NMS19
import org.bukkit.entity.Player
import taboolib.module.nms.MinecraftVersion
import java.util.*

/**
 * Adyeshach
 * ink.ptms.adyeshach.impl.nms.DefaultMinecraftEntityPlayerHandler
 *
 * @author 坏黑
 * @since 2022/6/28 00:10
 */
class DefaultMinecraftEntityPlayerHandler : MinecraftEntityPlayerHandler {

    val isUniversal = MinecraftVersion.isUniversal

    val majorLegacy = MinecraftVersion.majorLegacy

//    /** 1.9 ~ 1.16 */
//    val classPlayerInfoData: Class<*>? = kotlin.runCatching { nmsClass("PacketPlayOutPlayerInfo\$PlayerInfoData") }.getOrNull()
//
//    /** 1.9 ~ 1.16 */
//    val classPlayerInfoDataConstructor: Constructor<*>? = kotlin.runCatching {
//        classPlayerInfoData?.getDeclaredConstructor(
//            com.mojang.authlib.GameProfile::class.java,
//            Int::class.javaPrimitiveType,
//            NMS16EnumGameMode::class.java,
//            NMS16IChatBaseComponent::class.java
//        )?.also { it.isAccessible = true }
//    }.getOrNull()

    val packetHandler: MinecraftPacketHandler
        get() = Adyeshach.api().getMinecraftAPI().getPacketHandler()

    @Suppress("DuplicatedCode")
    override fun addPlayerInfo(player: Player, uuid: UUID, gameProfile: GameProfile) {
        // 1.19.3
        // PacketPlayOutPlayerInfo 变更为 ClientboundPlayerInfoPacket
        if (majorLegacy >= 11903) {
            packetHandler.sendPacket(player, NMS19.instance.createClientboundPlayerInfoUpdatePacket(uuid, gameProfile, GameProfileAction.initActions()))
        }
        // 1.17, 1.18, 1.19
        else if (isUniversal) {
            packetHandler.sendPacket(player, NMSPacketPlayOutPlayerInfo(createDataSerializer {
                writeAddProfileLegacy(uuid, gameProfile, majorLegacy >= 11900)
            }.build() as NMSPacketDataSerializer))
        }
        // 1.9 ~ 1.16
        else {
            packetHandler.sendPacket(player, NMS16PacketPlayOutPlayerInfo().also {
                it.a(createDataSerializer {
                    writeAddProfileLegacy(uuid, gameProfile)
                }.build() as NMS16PacketDataSerializer)
            })
        }
    }

    override fun removePlayerInfo(player: Player, uuid: UUID) {
        // 1.19.3
        // PacketPlayOutPlayerInfo 变更为 ClientboundPlayerInfoPacket
        if (majorLegacy >= 11903) {
            packetHandler.sendPacket(player, NMS19.instance.createClientboundPlayerInfoRemovePacket(uuid))
        }
        // 1.17, 1.18, 1.19
        else if (isUniversal) {
            packetHandler.sendPacket(player, NMSPacketPlayOutPlayerInfo(createDataSerializer {
                writeRemoveProfile(uuid)
            }.build() as NMSPacketDataSerializer))
        }
        // 1.9 ~ 1.16
        else {
            packetHandler.sendPacket(player, NMS16PacketPlayOutPlayerInfo().also {
                it.a(createDataSerializer {
                    writeRemoveProfile(uuid)
                }.build() as NMS16PacketDataSerializer)
            })
        }
    }

    private fun DataSerializer.writeAddProfileLegacy(uuid: UUID, gameProfile: GameProfile, profilePublicKey: Boolean = false) {
        // ADD_PLAYER
        writeVarInt(0)
        // Count
        writeVarInt(1)
        // GameProfile
        writeUUID(uuid)
        writeUtf(gameProfile.name, 16)
        writeGameProfileProperties(gameProfile.toMojang(uuid).properties)
        // GameMode
        writeVarInt(if (gameProfile.spectator) 3 else 1)
        // Ping
        writeVarInt(gameProfile.ping)
        // Name
        writeNullable(gameProfile.name) {
            val component = Adyeshach.api().getMinecraftAPI().getHelper().literalChatBaseComponent(it)
            val json = Adyeshach.api().getMinecraftAPI().getHelper().craftChatSerializerToJson(component)
            writeUtf(json, 262144)
        }
        // ProfilePublicKey
        if (profilePublicKey) {
            writeBoolean(false)
        }
    }

    private fun DataSerializer.writeRemoveProfile(uuid: UUID) {
        // REMOVE_PLAYER
        writeVarInt(4)
        // Count
        writeVarInt(1)
        // GameProfile
        writeUUID(uuid)
    }
}