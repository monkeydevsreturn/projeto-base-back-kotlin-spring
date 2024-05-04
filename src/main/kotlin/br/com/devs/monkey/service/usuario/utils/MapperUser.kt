package br.com.devs.monkey.service.usuario.utils

import br.com.devs.monkey.excpetion.ApplicationServiceException
import br.com.devs.monkey.model.User
import br.com.devs.monkey.utils.UtilsDev
import br.com.devs.monkey.utils.mapper.Mapper
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Component
class MapperUser : Mapper<User, UserDTO> {
    private val logger: Logger = Logger.getLogger(MapperUser::class.simpleName)
    override fun mapToEntity(obj: UserDTO): User {
        try {
            val responseUser: User = User();
            responseUser.cpf = obj.cpf
            responseUser.email = obj.email
            responseUser.nome = obj.nome
            return responseUser
        } catch (e: Exception) {
            logger.warning(
                "Erro ao executar " +
                        Thread.currentThread().stackTrace[1].methodName
                        + " linha: " +
                        Thread.currentThread().stackTrace[1].lineNumber
            )
            throw ApplicationServiceException("error.mapper.to.entity")
        }
    }

    override fun mapToDTO(entity: User): UserDTO {
        try {
            val responseUserDto: UserDTO = UserDTO(
                entity.nome,
                UtilsDev.converterFormatoCpf(entity.cpf),
                entity.email
            );
            return responseUserDto
        } catch (e: Exception) {
            logger.warning(
                "Erro ao executar " +
                        Thread.currentThread().stackTrace[1].methodName
                        + " linha: " +
                        Thread.currentThread().stackTrace[1].lineNumber
            )
            throw ApplicationServiceException("error.mapper.to.dto")
        }
    }
}