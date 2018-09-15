package br.org.venturus.venturusbootcamp

import br.org.venturus.venturusbootcamp.feature.detail.DetailViewModel
import br.org.venturus.venturusbootcamp.feature.list.ListViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    viewModel { ListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
