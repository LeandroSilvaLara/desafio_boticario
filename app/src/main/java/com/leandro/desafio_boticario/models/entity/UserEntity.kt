package com.leandro.desafio_boticario.models.entity

import com.orm.SugarRecord

class UserEntity : SugarRecord {
    var name: String? = null
    var email: String? = null
    var password: String? = null

    constructor() {}
    constructor(name: String?, email: String?, password: String?) : super() {
        this.name = name
        this.email = email
        this.password = password
    }

}