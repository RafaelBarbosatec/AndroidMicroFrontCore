package rafaelbarbosatec.poc.microcore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.rafaelbarbosatec.sdk.data.pokemon.model.Pokemon
import com.rafaelbarbosatec.sdk.data.pokemon.model.TypePokemon
import rafaelbarbosatec.poc.listpokemon.PokemonList
import rafaelbarbosatec.poc.listpokemon.PokemonListComunication
import rafaelbarbosatec.poc.typepokemon.PokemonTypesComunication
import rafaelbarbosatec.poc.typepokemon.PokemonsTypes

class MainActivity : AppCompatActivity(), PokemonTypesComunication.PokemonTypesListern,
    PokemonListComunication.PokemonListListern {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        initView()
        super.onStart()
    }

    private fun initView() {
        PokemonsTypes.show(supportFragmentManager,R.id.container_type,this)
        PokemonList.show(supportFragmentManager,R.id.container_pokemons,this)
    }

    override fun pokemonTypesOnClick(type: TypePokemon?) {
        PokemonList.actions?.filterByType(type)
    }

    override fun pokemonOnClick(pokemon: Pokemon) {
        Toast.makeText(this,"Pokemon ${pokemon.name}",Toast.LENGTH_SHORT).show()
    }

}
