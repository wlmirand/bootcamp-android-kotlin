package br.org.venturus.venturusbootcamp.feature.list

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import br.org.venturus.venturusbootcamp.R
import br.org.venturus.venturusbootcamp.core.extension.logD
import br.org.venturus.venturusbootcamp.core.extension.showToast
import br.org.venturus.venturusbootcamp.databinding.ActivityListBinding
import br.org.venturus.venturusbootcamp.domain.people.Person
import br.org.venturus.venturusbootcamp.feature.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.ext.android.inject

/**
 * [AppCompatActivity] that holds the list of [Person]
 */
class ListActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by inject()

    private lateinit var adapter: ListPeopleAdapter

    private lateinit var binding: ActivityListBinding

    private val layoutManager by lazy { LinearLayoutManager(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        // Faz o bind do ViewModel no layout
        binding.viewModel = viewModel

        setupList()
    }

    /**
     * Setup the [RecyclerView] and add all items to the list.
     */
    private fun setupList() {
        logD { "setupList called" }

        // Instancia o Adapter que usa uma high order function para determinar o click.
        adapter = ListPeopleAdapter { personId ->
            DetailActivity.startActivity(this, personId)
        }

        list_recycler_view.adapter = adapter
        list_recycler_view.layoutManager = layoutManager

        // O ViewModel irá carregar a lista de pessoas.
        // Atraves do HOF, a View consegue "ouvir" o ViewModel,
        // como se estivesse usando um Listener.
        viewModel.loadPeople(
            onLoading = { showLoading(it) },
            onPeopleLoaded = { adapter.setItems(it) },
            onLoadError = { showToast(it.localizedMessage) }
        )
    }

    /**
     * Controls when the loading should be displayed.
     *
     * @param showLoading a [Boolean] to determine if the loading should be display. `true` to
     * display, `false` to hide.
     */
    private fun showLoading(showLoading: Boolean) {
        logD { "showLoading called with: showLoading = [$showLoading]" }

        // Em Kotlin, uma condição IF pode retornar um valor.
        // Isso evita o uso de uma variável auxiliar ou multiplus retornos.
        list_loading.visibility =
                if (showLoading) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
    }
}
