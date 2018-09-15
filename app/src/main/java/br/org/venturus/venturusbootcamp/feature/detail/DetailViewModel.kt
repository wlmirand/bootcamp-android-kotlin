package br.org.venturus.venturusbootcamp.feature.detail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.org.venturus.venturusbootcamp.core.extension.logD
import br.org.venturus.venturusbootcamp.core.extension.logE
import br.org.venturus.venturusbootcamp.domain.people.GetPeopleUseCase
import br.org.venturus.venturusbootcamp.domain.people.Person
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailViewModel(private val getPeopleUseCase: GetPeopleUseCase) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val livePerson = MutableLiveData<Person>()

    fun loadPerson(
            personId: String,
            onLoading: (showLoading: Boolean) -> Unit,
            onLoadError: (error: Throwable) -> Unit
    ) {
        val person = getPeopleUseCase.getPerson(personId)
                .subscribeOn(Schedulers.io()) // Executa a chamada na thread de IO
                .observeOn(AndroidSchedulers.mainThread()) // Envia a resposta para a thread do Android
                .doOnSubscribe { onLoading(true) } // Quando assinar, inicia o loading
                .doOnEvent { _, _ -> onLoading(false) } // Assim que receber um evento, para
                .subscribe(
                        { result ->
                            livePerson.value = result
                            logD{ "BRUTUS ${result.name}" }
                        },
                        { error ->
                            logE { "Error while fetching: ${error.message}" }
                            onLoadError(error)
                        }
                )

        // Adiciona o disposable no container de dispobles, para ser limpo afim de evitar um Leak!
        compositeDisposable.add(person)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}