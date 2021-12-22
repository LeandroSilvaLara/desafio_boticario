package com.leandro.desafio_boticario.viewmodels.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.leandro.desafio_boticario.R
import com.leandro.desafio_boticario.databinding.ActivityMainBinding
import com.leandro.desafio_boticario.models.entity.UserEntity
import com.leandro.desafio_boticario.service.Constants
import com.leandro.desafio_boticario.viewmodels.LoginActivity
import com.orm.query.Condition
import com.orm.query.Select

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    var userLogged: UserEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getUserLogged()

        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        val headerView = navView.getHeaderView(0)

        val txtNameLogged = headerView.findViewById<TextView>(R.id.txt_name_logged)
        val txtEmailLogged = headerView.findViewById<TextView>(R.id.txt_email_logged)

        userLogged?.let {
            txtNameLogged.text = it.name
            txtEmailLogged.text = it.email
        }

        val menu = navView.menu
        val menuItem = menu.findItem(R.id.nav_exit)
        menuItem.setOnMenuItemClickListener {
            exitApp()
            true
        }

        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_posts, R.id.nav_news_boticario, R.id.nav_exit), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun exitApp(){
        val sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()
        editor.putLong(Constants.USER_LOGGED_ID, 0).apply()

        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun getUserLogged(){

        val sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        val userId = sharedPreferences.getLong(Constants.USER_LOGGED_ID, 0)

        userLogged = Select.from(UserEntity::class.java)
            .where(Condition.prop("id").eq(userId))
            .first()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}