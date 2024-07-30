package com.cesarsandoval.firstapp
object RutValidator {

    fun isValidRut(rut: String): Boolean {
        val cleanedRut = rut.replace(".", "").replace("-", "")
        if (cleanedRut.length < 2) return false

        val numberPart = cleanedRut.dropLast(1)
        val dv = cleanedRut.takeLast(1)

        return calculateDV(numberPart) == dv.uppercase()
    }

    private fun calculateDV(numberPart: String): String {
        var sum = 0
        var multiplier = 2

        for (i in numberPart.reversed()) {
            sum += (i.toString().toInt() * multiplier)
            multiplier = if (multiplier == 7) 2 else multiplier + 1
        }

        val remainder = 11 - (sum % 11)

        return when (remainder) {
            11 -> "0"
            10 -> "K"
            else -> remainder.toString()
        }
    }
}

fun main() {
    println("Ingrese el RUT a verificar (formato: 12345678-9):")
    val inputRut = readLine() ?: ""

    if (RutValidator.isValidRut(inputRut)) {
        println("El RUT $inputRut es válido.")
    } else {
        println("El RUT $inputRut es inválido.")
    }
}
