package uz.xsoft.mobilebank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.xsoft.mobilebank.domain.usecases.SignUpUseCase
import uz.xsoft.mobilebank.domain.usecases.impl.SignUpUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindSignUpUseCase(impl: SignUpUseCaseImpl): SignUpUseCase
}