package br.org.venturus.venturusbootcamp.core.extension

import timber.log.Timber

/**
 * Logs with [Timber] in a debug way.
 */
inline fun logD(lambda: () -> String) = Timber.d(lambda())

/**
 * Logs with [Timber] in a error way.
 */
inline fun logE(lambda: () -> String) = Timber.e(lambda())
