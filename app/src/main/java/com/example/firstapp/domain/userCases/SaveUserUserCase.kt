package com.example.firstapp.domain.userCases

import com.example.firstapp.domain.entities.UserUIEntity
import com.example.firstapp.domain.repository.UsersRepository

class SaveUserUserCase(val userRepository: UsersRepository) {

    suspend fun invoke(users: List<UserUIEntity>) {
        userRepository.saveUsers(users)
    }
}