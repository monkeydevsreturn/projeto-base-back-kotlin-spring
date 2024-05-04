package br.com.devs.monkey.model

import br.com.devs.monkey.utils.UtilsBanco
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_user", schema = UtilsBanco.SCHEMA_BD)
class User() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USER_SEQ")
    @SequenceGenerator(name = "ID_USER_SEQ", sequenceName = UtilsBanco.SCHEMA_BD + ".user_sequence")
    @Column(unique = true, name = "id")
    var id: Long? = null
        get() = field
        set(value) {
            field = value
        }
    var nome: String? = null
        get() = field!!.uppercase(Locale.getDefault())
        set(value) {
            field = value
        }

    var cpf: String? = null
    var email: String? = null

    constructor(nome: String, cpf: String, email: String) : this() {
        this.nome = nome
        this.cpf = cpf
        this.email = email
    }
}