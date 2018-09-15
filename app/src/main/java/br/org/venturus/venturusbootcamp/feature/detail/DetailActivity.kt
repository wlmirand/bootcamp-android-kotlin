package br.org.venturus.venturusbootcamp.feature.detail

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.org.venturus.venturusbootcamp.R
import br.org.venturus.venturusbootcamp.core.extension.logD
import br.org.venturus.venturusbootcamp.core.extension.showToast
import br.org.venturus.venturusbootcamp.databinding.ActivityDetailBinding
import br.org.venturus.venturusbootcamp.domain.people.Person
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by inject()

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        logD { "onCreate savedInstanceState" }

        binding.varDoLayout = viewModel
        binding.setLifecycleOwner(this)
        loadPerson()
    }

    private fun loadPerson() {
        // Seria necessário checar cada object se não era nulo, para enfim, pegar o id do objeto.
        // Com Kotlin, usando null safe basta colocar uma interrogação.
        val personId = intent?.extras?.getString(EXTRA_PERSON_ID)
        logD { "loadPerson = [$personId]" }

        //procura os dados do personId
        personId?.let {id ->
            viewModel.loadPerson(
                    id,
                    onLoading = { showLoading(it) },
                    onLoadError = { showToast(it.localizedMessage) }
            )
        }


    }

    /**
     * Controls when the loading should be displayed.
     *
     * @param showLoading a [Boolean] to determine if the loading should be display. `true` to
     * display, `false` to hide.
     */
    private fun showLoading(showLoading: Boolean) {

    }

    companion object {

        private const val EXTRA_PERSON_ID = "extra_id"

        fun startActivity(activity: Activity, personId: String) {

            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(EXTRA_PERSON_ID, personId)
            activity.startActivity(intent)
        }
    }
}
