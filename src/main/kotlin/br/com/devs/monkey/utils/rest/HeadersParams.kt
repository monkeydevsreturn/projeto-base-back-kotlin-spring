package br.com.devs.monkey.utils.rest

enum class HeadersParams {
    APPLICATION_JSON {
        override fun getDescricao(): String {
            return "application/json"
        }

    },
    CONTENT_TYPE {
        override fun getDescricao(): String {
            return "Content-Type"
        }
    },
    AUTHORIZATION {
        override fun getDescricao(): String {
            return "Authorization"
        }
    },
    CONSUMER_ID {
        override fun getDescricao(): String {
            return "consumerId"
        }
    };

    abstract fun getDescricao(): String
}