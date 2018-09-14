package br.org.venturus.venturusbootcamp.feature.list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.org.venturus.venturusbootcamp.R
import br.org.venturus.venturusbootcamp.core.databinding.BindingHolder
import br.org.venturus.venturusbootcamp.core.extension.logD
import br.org.venturus.venturusbootcamp.databinding.ItemPersonBinding
import br.org.venturus.venturusbootcamp.domain.people.Person

class ListPeopleAdapter(private val onClick: ((String) -> Unit?)) :
    RecyclerView.Adapter<BindingHolder<ItemPersonBinding>>() {

    private val items: MutableList<Person> = mutableListOf()

    // Métodos que chamam apenas uma linha poderão ser associados como se fossem uma atribuição.
    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BindingHolder<ItemPersonBinding> {
        val binding = DataBindingUtil.inflate<ItemPersonBinding>(
            LayoutInflater.from(parent.context), R.layout.item_person, parent, false
        )

        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder<ItemPersonBinding>, position: Int) {
        val binding = holder.binding
        val person = items[position]
        binding.person = person
        binding.root.setOnClickListener { onClick(person.id) }
    }

    /**
     * Add the list of people to the adapter.
     */
    fun setItems(people: Collection<Person>) {
        logD { "setItems called with: people = [$people]" }

        // Em Kotlin, as Collections tem um `forEach { ... }` por padrão!
        people.forEach { person ->
            items.add(person)

            // Sempre prefira notificar a lista que um objecto entrou, saiu ou mudou de posição.
            // Chamar notifyDataSetChanged() irá fazer desenhar toda a tela e é custoso.
            notifyItemInserted(items.size)
        }
    }
}
