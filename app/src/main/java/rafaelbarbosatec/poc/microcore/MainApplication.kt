package rafaelbarbosatec.poc.microcore

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import rafaelbarbosatec.poc.listpokemon.PokemonList
import rafaelbarbosatec.poc.microcore.di.AppModule
import rafaelbarbosatec.poc.typepokemon.PokemonsTypes

class MainApplication:Application(){

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                arrayListOf(
                    AppModule.module,
                    PokemonList.getModuleInjection(),
                    PokemonsTypes.getModuleInjection()
                )
            )
        }
    }
}