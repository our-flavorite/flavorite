package com.flavorite.application.common.command.usecases

interface SignInUseCase {

    fun execute(command: SignInCommand)
}