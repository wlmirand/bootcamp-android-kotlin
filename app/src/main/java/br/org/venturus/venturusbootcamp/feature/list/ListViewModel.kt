package br.org.venturus.venturusbootcamp.feature.list

import android.arch.lifecycle.ViewModel
import br.org.venturus.venturusbootcamp.core.extension.logE
import br.org.venturus.venturusbootcamp.domain.people.GetPeopleUseCase
import br.org.venturus.venturusbootcamp.domain.people.Person
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListViewModel(private val getPeopleUseCase: GetPeopleUseCase) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    /**
     * Starts to fetch all people from server.
     *
     * @param onLoading HOF to receive the status of loading.
     * @param onPeopleLoaded HOF to receive the [List] of [Person].
     * @param onLoadError HOF to receive the [Throwable] in case of any error.
     */
    fun loadPeople(
        onLoading: (showLoading: Boolean) -> Unit,
        onPeopleLoaded: (personList: List<Person>) -> Unit,
        onLoadError: (error: Throwable) -> Unit
    ) {
        val peopleUseCase = getPeopleUseCase.getPeopleList() // Inicia o serviço
            .subscribeOn(Schedulers.io()) // Executa a chamada na thread de IO
            .observeOn(AndroidSchedulers.mainThread()) // Envia a resposta para a thread do Android
            .doOnSubscribe { onLoading(true) } // Quando assinar, inicia o loading
            .doOnEvent { _, _ -> onLoading(false) } // Assim que receber um evento, para
            .subscribe(
                { result -> onPeopleLoaded(result) },
                { error ->
                    logE { "Error while fetching: ${error.message}" }
                    onLoadError(error)
                }
            )

        // Adiciona o disposable no container de dispobles, para ser limpo afim de evitar um Leak!
        compositeDisposable.add(peopleUseCase)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
