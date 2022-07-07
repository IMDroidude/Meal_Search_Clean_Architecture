package uk.co.planetbeyond.meal_search_clean_architecture.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

// https://stackoverflow.com/a/64450770/17780540
///typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class AppActivity<VB : ViewBinding>(val bindingFactory: (LayoutInflater) -> VB) :
    AppCompatActivity() {
    ///private lateinit var binding: VB
    val binding: VB by lazy { bindingFactory(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ///binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }
}
// call it like
///class MainActivity : AppActivity<ActivityMainBinding>(ActivityMainBinding::inflate)

