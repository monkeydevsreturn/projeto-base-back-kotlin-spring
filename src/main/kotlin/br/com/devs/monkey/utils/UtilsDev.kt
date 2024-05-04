package br.com.devs.monkey.utils

import java.util.regex.Pattern

class UtilsDev {
    companion object {
        @JvmStatic
        fun converterFormatoCpf(cpf: String?): String? {
            if (cpf.isNullOrEmpty()) {
                return null
            }
            val STR_EXP_CPF_SEM_MASCARA = "^[0-9]{11}$"
            val pattern = Pattern.compile(STR_EXP_CPF_SEM_MASCARA)
            val matcher = pattern.matcher(cpf)
            if (matcher.matches()) {
                val cpfComMascara = java.lang.StringBuilder()

                cpfComMascara.append(cpf.substring(0, 3))
                cpfComMascara.append(".")
                cpfComMascara.append(cpf.substring(3, 6))
                cpfComMascara.append(".")
                cpfComMascara.append(cpf.substring(6, 9))
                cpfComMascara.append("-")
                cpfComMascara.append(cpf.substring(9, 11))
                return cpfComMascara.toString()
            }
            return cpf
        } // converterFormatoCnpj

        @JvmStatic
        fun converterFormatoCnpj(cnpj: String?): String? {
            if (cnpj.isNullOrEmpty()) {
                return null
            }
            val STR_EXP_CNPJ_SEM_MASCARA = "^[0-9]{14}$"
            val pattern = Pattern.compile(STR_EXP_CNPJ_SEM_MASCARA)
            val matcher = pattern.matcher(cnpj)
            return if (matcher.matches()) {

                val cnpjComMascara = java.lang.StringBuilder()
                cnpjComMascara.append(cnpj.substring(0, 2))
                cnpjComMascara.append(".")
                cnpjComMascara.append(cnpj.substring(2, 5))
                cnpjComMascara.append(".")
                cnpjComMascara.append(cnpj.substring(5, 8))
                cnpjComMascara.append("/")
                cnpjComMascara.append(cnpj.substring(8, 12))
                cnpjComMascara.append("-")
                cnpjComMascara.append(cnpj.substring(12, 14))
                cnpjComMascara.toString()

            } else cnpj
        } // converterFormatoCnpj

        @JvmStatic
        fun converterCPFCensurado(cpf: String?): String? {
            if (cpf.isNullOrEmpty()) {
                return null
            }
            val STR_EXP_CPF_SEM_MASCARA = "^[0-9]{11}$"
            val pattern = Pattern.compile(STR_EXP_CPF_SEM_MASCARA)
            val matcher = pattern.matcher(cpf)
            if (matcher.matches()) {
                val cpfComMascara = StringBuilder()
                cpfComMascara.append(cpf.substring(0, 3))
                cpfComMascara.append(".")
                cpfComMascara.append("**")
                cpfComMascara.append(".")
                cpfComMascara.append(cpf.substring(6, 9))
                cpfComMascara.append("-")
                cpfComMascara.append("**")
                return cpfComMascara.toString()
            } // if
            return cpf
        } // converterCPFSensurado

    }
}