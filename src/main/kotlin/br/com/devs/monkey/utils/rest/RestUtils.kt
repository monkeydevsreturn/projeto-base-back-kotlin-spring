package br.com.devs.monkey.utils.rest

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.logging.Level
import java.util.logging.Logger
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


class RestUtils {
    private val logger: Logger = Logger.getLogger("RestUtils");
    private fun createInsecureHttpCliente(): HttpClient {
        logger.log(Level.INFO, "TIRANDO VALIDAÇÃO SSL")
        val trustAllCerts = arrayOf<TrustManager>(
            object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return emptyArray()
                }

                override fun checkClientTrusted(certs: Array<X509Certificate?>?, authType: String?) {}
                override fun checkServerTrusted(certs: Array<X509Certificate?>?, authType: String?) {}
            }
        )
        // Cria um contexto SSL que não realiza verificação
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustAllCerts, SecureRandom())
        // Cria um HttpClient com o SSLContext configurado
        return HttpClient.newBuilder()
            .sslContext(sslContext)
            .build()
    }

    fun doGet(queryParams: MutableMap<String, String>, url: String, headersParams: MutableMap<String, String>): String {
        try {
            logger.log(Level.INFO, "INICIANDO CRIAÇÃO DA REQUEST")

            val client: HttpClient = this.createInsecureHttpCliente()
            var urlFormatada: String = url
            if (queryParams.isNotEmpty()) {
                urlFormatada += "?"
                urlFormatada += this.queryParamsBuilder(queryParams)
            }
            val requestBuilder: HttpRequest.Builder = HttpRequest
                .newBuilder()
                .uri(URI.create(urlFormatada))
                .GET()
            if (headersParams.isNotEmpty()) {
                this.headersParamsBuilder(headersParams, requestBuilder)
            }
            val response = client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                logger.log(Level.FINER,"DO GET EXECUTADO COM SUCESSO")
                return response.body()
            } else if (response.statusCode() == 400) {
                throw Exception("ERROR 400")
            } else {
                throw Exception("Error 500")
            }

        } catch (e: Exception) {
            throw Exception("NÃO FOI POSSÍVEL EXECUTAR A REQUISIÇÃO")
        }
    }

    private fun queryParamsBuilder(queryParams: Map<String, String>): String {
        val queryStringBuilder = StringBuilder()
        for ((key, value) in queryParams) {
            if (queryStringBuilder.isNotEmpty()) {
                queryStringBuilder.append("&")
            }
            queryStringBuilder.append(key).append("=").append(value)
        }
        return queryStringBuilder.toString()
    }

    private fun headersParamsBuilder(headers: Map<String, String>, requestBuilder: HttpRequest.Builder) {
        for ((key, value) in headers) {
            requestBuilder.headers(key, value)
        }
    }
}