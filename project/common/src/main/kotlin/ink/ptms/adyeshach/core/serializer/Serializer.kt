package ink.ptms.adyeshach.core.serializer

import com.google.gson.GsonBuilder
import org.bukkit.inventory.ItemStack
import org.bukkit.util.io.BukkitObjectInputStream
import org.bukkit.util.io.BukkitObjectOutputStream
import taboolib.common.io.runningClassMapInJar
import taboolib.common.io.runningClasses
import taboolib.common.reflect.hasAnnotation
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.*

/**
 * Adyeshach
 * ink.ptms.adyeshach.core.serializer.Serializer
 *
 * @author sky
 * @since 2021/5/29 12:27 上午
 */
object Serializer {

    val gson = GsonBuilder()
        .setPrettyPrinting()
        .excludeFieldsWithoutExposeAnnotation().run {
            runningClassMapInJar.forEach { (_, cls) ->
                if (cls.hasAnnotation(SerializerType::class.java)) {
                    val type = cls.getAnnotation(SerializerType::class.java).type("baseClass").instance
                    registerTypeHierarchyAdapter(type, cls.newInstance())
                }
            }
            create()
        }!!

    fun toItemStack(data: String): ItemStack {
        ByteArrayInputStream(Base64.getDecoder().decode(data)).use { byteArrayInputStream ->
            BukkitObjectInputStream(byteArrayInputStream).use { bukkitObjectInputStream ->
                return bukkitObjectInputStream.readObject() as ItemStack
            }
        }
    }

    fun fromItemStack(itemStack: ItemStack): String {
        ByteArrayOutputStream().use { byteArrayOutputStream ->
            BukkitObjectOutputStream(byteArrayOutputStream).use { bukkitObjectOutputStream ->
                bukkitObjectOutputStream.writeObject(itemStack)
                return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray())
            }
        }
    }
}