package com.example.learnup.domain


import com.example.learnup.domain.models.ItemLearn

class GetLearnItemByIdUseCase(private val learnRepository: LearnRepository) {
    suspend fun execute(id:Int): ItemLearn {

        return learnRepository.getLearnItemById(id)
    }
}