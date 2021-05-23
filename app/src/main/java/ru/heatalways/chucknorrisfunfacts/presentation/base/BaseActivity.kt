package ru.heatalways.chucknorrisfunfacts.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewbinding.ViewBinding
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.heatalways.chucknorrisfunfacts.App

abstract class BaseActivity<Binding: ViewBinding>: AppCompatActivity(){
    private var navigator: Navigator? = null
    protected lateinit var binding: Binding

    protected abstract fun getBinding(inflater: LayoutInflater): Binding

    private val app get() = application as App

    @IdRes
    abstract fun getFragmentContainerId(): Int?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getBinding(layoutInflater)
        setContentView(binding.root)

        getFragmentContainerId()?.let { fragmentContainerId ->
            navigator = AppNavigator(this, fragmentContainerId)
        }
    }

    override fun onResume() {
        super.onResume()
        navigator?.let { app.setNavigator(it) }
    }

    override fun onPause() {
        super.onPause()
        navigator?.let { app.removeNavigator() }
    }

    fun showKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        view.requestFocus()
        inputMethodManager?.showSoftInput(view, 0)
    }

    fun showKeyboard(viewId: Int) {
        val view = findViewById<View>(viewId)
        showKeyboard(view ?: return)
    }

    fun hideKeyboard() {
        if (currentFocus != null) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            inputMethodManager?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }
}