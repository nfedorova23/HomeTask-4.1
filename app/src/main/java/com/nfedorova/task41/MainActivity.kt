package com.nfedorova.task41

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.nfedorova.task41.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Transition, FragmentC.NextButtonClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportFragmentManager.findFragmentByTag(FragmentA.TAG_A) == null) {
            supportFragmentManager.commit {
                replace(
                    R.id.container,
                    FragmentA.newInstance(),
                    FragmentA.TAG_A
                )
                addToBackStack(FragmentA.TAG_A)
            }
        }
    }

    override fun onBackPressed() {
        val stackCount = supportFragmentManager.backStackEntryCount
        if (stackCount == 1) {
            moveTaskToBack(false)
        } else {
            supportFragmentManager.popBackStack()
        }
        return
        super.onBackPressed()
    }

    override fun onNextButtonClicked() {
        supportFragmentManager.commit {
            val fragment = FragmentD.newInstance()
            replace(R.id.container, fragment, FragmentD.TAG_D)
            addToBackStack(FragmentD.TAG_D)
        }
    }
    override fun next(fragmentName: String, bundle: Bundle?) {
        val fragment = when (fragmentName) {
            FragmentB.TAG_B -> FragmentB.newInstance()
            FragmentC.TAG_C -> bundle?.let { FragmentC.newInstance(it) }

            else -> {
                throw RuntimeException("Not Found")
            }
        }

        fragment?.let {
            supportFragmentManager.commit {
                replace(R.id.container, it)
                addToBackStack(fragmentName)
            }
        }
    }

    override fun back(fragmentName: String) {
        while (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name != fragmentName) {
            supportFragmentManager.popBackStackImmediate()
        }
    }
}

interface Transition {
    fun next(
        fragmentName: String,
        bundle: Bundle? = null
    )

    fun back(
        fragmentName: String
    )
}