package de.developercity.arcanosradio.core.extension

// region Any
val Unit?.exhaustive get() = this
// endregion

// region Boolean
fun Boolean?.orFalse(): Boolean = this ?: false

fun Boolean?.orTrue(): Boolean = this ?: true
// endregion

// region Int
fun Int?.orZero(): Int = this ?: 0

// endregion

// region Long
fun Long?.orZero(): Long = this ?: 0
// endregion

// region String
inline fun String?.ifNotNullOrEmpty(block: (String) -> Unit) {
    if (this != null && isNotEmpty()) block(this)
}

fun String.Companion.empty(): String = ""

fun String.remove(value: String): String = replace(value, "")

fun String.remove(regex: Regex): String = replace(regex, "")

fun String.removeFirst(value: String): String = replaceFirst(value, "")

fun String.removeFirst(regex: Regex): String = replaceFirst(regex, "")

fun String.isInt(): Boolean = try {
    toInt()
    true
} catch (e: Exception) {
    false
}

// endregion

// region CharSequence
fun CharSequence.remove(regex: Regex): String = replace(regex, "")

fun CharSequence.removeFirst(regex: Regex): String = replaceFirst(regex, "")
// endregion

// region Map
/***
 * Map.getOrDefault was added in Java 8. This ExFun mimics its implementation.
 */
fun <K, V> Map<K, V>.getOrDefaultValue(key: K, defaultValue: V): V =
    get(key)?.let { it } ?: defaultValue

// endregion

// region List
fun <T> List<T>.random(): T = shuffled().first()
// endregion
