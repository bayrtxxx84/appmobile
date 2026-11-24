package com.example.firstapp.data.mappers

import com.example.firstapp.data.local.entities.UserDBEntity
import com.example.firstapp.data.network.entities.UserAPIEntity
import com.example.firstapp.domain.entities.UserUIEntity


fun UserUIEntity.toUserDBEntity(): UserDBEntity {
    return UserDBEntity(
        0,
        email.orEmpty(), gender.orEmpty(), idName.orEmpty(),
        idValue.orEmpty(), password.orEmpty(), first.orEmpty(),
        last.orEmpty(), phone.orEmpty(), picture.orEmpty()
    )
}

fun UserDBEntity.toUserUIEntity(): UserUIEntity {
    return UserUIEntity(
        email, gender, idName, idValue, password, first, last, phone, picture
    )
}

fun UserAPIEntity.toUserUIEntity(): UserUIEntity {
    return UserUIEntity(
        this.email,
        this.gender,
        this.id.name,
        this.id.value,
        this.login.password,
        this.name.first,
        this.name.last,
        this.phone,
        this.picture.medium
    )
}

fun UserAPIEntity.toUserDBEntity(): UserDBEntity {
    return UserDBEntity(
        0,
        this.email.orEmpty(),
        this.gender.orEmpty(),
        this.id.name.orEmpty(),
        this.id.value.orEmpty(),
        this.login.password.orEmpty(),
        this.name.first.orEmpty(),
        this.name.last.orEmpty(),
        this.phone.orEmpty(),
        this.picture.medium.orEmpty()
    )
}