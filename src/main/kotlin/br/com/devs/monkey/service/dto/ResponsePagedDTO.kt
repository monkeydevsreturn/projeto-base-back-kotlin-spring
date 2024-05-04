package br.com.devs.monkey.service.dto

data class ResponsePagedDTO<T>(val response: T, val perPage: Int, val totalRows: Int, var legthList: Int?) {
    override fun toString(): String {
        return "itens por página $perPage, total de itens $totalRows"
    }
}
