package uk.co.planetbeyond.meal_search_clean_architecture.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import uk.co.planetbeyond.meal_search_clean_architecture.R
import uk.co.planetbeyond.meal_search_clean_architecture.base.AppActivity
import uk.co.planetbeyond.meal_search_clean_architecture.databinding.ActivitySearchBinding

@AndroidEntryPoint
class SearchActivity : AppActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ///setContentView(R.layout.activity_search)
    }
}