package br.com.devs.monkey.service.usuario

import br.com.devs.monkey.service.dto.ResponsePagedDTO
import br.com.devs.monkey.service.usuario.utils.UserDTO
import br.com.devs.monkey.model.User
import br.com.devs.monkey.service.BasicService
import br.com.devs.monkey.service.usuario.utils.MapperUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService() : BasicService<User, UserDTO> {
    private lateinit var mapperUser: MapperUser;
    @Autowired
    constructor(mapperUser: MapperUser) : this() {
        this.mapperUser = mapperUser;
    }

    override fun createdEntity(dto: UserDTO): User {
        return this.mapperUser.mapToEntity(dto);
    }

    override fun updatedEntity(dto: UserDTO): User {
        return this.mapperUser.mapToEntity(dto);
    }

    override fun deleteEntity(dto: UserDTO): User {
        return this.mapperUser.mapToEntity(dto);
    }

    override fun getEntity(dto: UserDTO): User {
        return this.mapperUser.mapToEntity(dto);
    }

    override fun getPaged(dto: UserDTO): ResponsePagedDTO<UserDTO> {
        return ResponsePagedDTO(UserDTO(null, null, null), 10, 10, 10);
    }

}