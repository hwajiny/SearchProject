package net.flow9.thisiskotlin.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import net.flow9.thisiskotlin.myapplication1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var likedItems: ArrayList<Model> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.run {
            bSearchFragment.setOnClickListener{
                setFragment(Search())
            }
            bBookmarkFragment.setOnClickListener {
                setFragment(BookMark())
            }
        }
        setFragment(Search())
    }

    private fun setFragment(frag : Fragment) {
        supportFragmentManager.commit {
            replace(R.id.framesLayout, frag)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

    fun addLikedItem(item: Model) {
        if(!likedItems.contains(item)) {
            likedItems.add(item)
        }
    }

    fun removeLikedItem(item: Model) {
        likedItems.remove(item)
    }
}
