package com.silva021.cartaodevisita.utils.mapper

import com.silva021.cartaodevisita.data.model.UserEntity
import com.silva021.cartaodevisita.domain.model.User
import org.mapstruct.Mapper

@Mapper
interface UserMapper {
    fun userModelToUserEntity(user: User): UserEntity
    fun userEntityToUserModel(user: UserEntity): User
}