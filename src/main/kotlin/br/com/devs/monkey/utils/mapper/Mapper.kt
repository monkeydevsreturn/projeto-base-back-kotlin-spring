package br.com.devs.monkey.utils.mapper

import br.com.devs.monkey.excpetion.ApplicationServiceException

interface Mapper<E, D> {
    @Throws(ApplicationServiceException::class)
    fun mapToEntity(obj: D): E;
    @Throws(ApplicationServiceException::class)
    fun mapToDTO(entity: E): D;
}