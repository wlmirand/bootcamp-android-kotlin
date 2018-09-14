package br.org.venturus.venturusbootcamp.feature.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.org.venturus.venturusbootcamp.R
import br.org.venturus.venturusbootcamp.core.extension.logD

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        logD { "onCreate savedInstanceState" }

        loadPerson()
    }

    private fun loadPerson() {
        // Seria necessário checar cada object se não era nulo, para enfim, pegar o id do objeto.
        // Com Kotlin, usando null safe basta colocar uma interrogação.
        val personId = intent?.extras?.getString(EXTRA_PERSON_ID)
        logD { "loadPerson = [$personId]" }

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
