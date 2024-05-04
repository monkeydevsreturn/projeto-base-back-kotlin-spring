package br.com.devs.monkey.service

import br.com.devs.monkey.excpetion.ApplicationServiceException
import br.com.devs.monkey.service.dto.ResponsePagedDTO

interface BasicService<E, D> {
    @Throws(ApplicationServiceException::class)
    fun createdEntity(dto: D): E;
    @Throws(ApplicationServiceException::class)
    fun updatedEntity(dto: D): E;
    @Throws(ApplicationServiceException::class)
    fun deleteEntity(dto: D): E;
    @Throws(ApplicationServiceException::class)
    fun getEntity(dto: D): E;
    @Throws(ApplicationServiceException::class)
    fun getPaged(dto: D): ResponsePagedDTO<D>;
}