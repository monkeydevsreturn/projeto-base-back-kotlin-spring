package br.com.devs.monkey.utils

import java.io.InputStream
import java.util.*

class MessageLoader {
    companion object {
        private val properties: Properties = Properties()

        init {
            val inputStream: InputStream = MessageLoader::class.java.classLoader.getResourceAsStream("messageApplication.properties")
                ?: throw RuntimeException("Arquivo de propriedades não encontrado")

            properties.load(inputStream)
        }

        @JvmStatic
        fun getMessage(key: String?): String? {
            if(key.isNullOrBlank()){
                return properties.getProperty("message.default")
            }
            return properties.getProperty(key)
        }
    }
}