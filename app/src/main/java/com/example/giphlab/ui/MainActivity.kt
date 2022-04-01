package com.example.giphlab.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.giphlab.R
import com.example.giphlab.databinding.ActivityMainBinding
import com.google.android.material.switchmaterial.SwitchMaterial
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    private lateinit var drawerToggle: ActionBarDrawerToggle

    private lateinit var btnSwitchTheme: SwitchMaterial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        initUiComponents()
        setupToolbar()
        setupDrawerLayout()
        setupNavigationView()
    }

    private fun initUiComponents() {
        btnSwitchTheme =
            mBinding.navigationView.menu.findItem(R.id.mi_night_mode).actionView as SwitchMaterial
        btnSwitchTheme.setOnCheckedChangeListener { _, isChecked ->
            var mode = when (isChecked) {
                true -> AppCompatDelegate.MODE_NIGHT_YES
                false -> AppCompatDelegate.MODE_NIGHT_NO
            }
            AppCompatDelegate.setDefaultNightMode(mode)
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(mBinding.toolbar)
        //toDo : connect drawer layout to navigation component later
    }

    private fun setupDrawerLayout() {
        drawerToggle = ActionBarDrawerToggle(
            this,
            mBinding.drawerLayout,
            mBinding.toolbar,
            R.string.action_open_drawer,
            R.string.action_close_drawer
        )
        mBinding.drawerLayout.addDrawerListener(drawerToggle)
        //sync stat for shwoing humberger :D
        // when i delete this code humburger was shown : this is for back key on the action bar
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    private fun setupNavigationView() {
        mBinding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {

            }
            mBinding.drawerLayout.closeDrawer(GravityCompat.START)

            true
        }
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }
    override fun onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START))
            mBinding.drawerLayout.closeDrawer(GravityCompat.START)
        else {
            super.onBackPressed()
        }
    }


}
