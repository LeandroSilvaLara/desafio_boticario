package com.leandro.desafio_boticario.viewmodels

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.leandro.desafio_boticario.R
import com.leandro.desafio_boticario.models.entity.PostsEntity
import com.leandro.desafio_boticario.service.Constants
import com.leandro.desafio_boticario.viewmodels.main.MainActivity
import java.util.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences =
            androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()

        val firstLogin = sharedPreferences.getBoolean(Constants.FIRST_LOGIN, true)

        if (firstLogin) {
            insertFakePosts()
            editor.putBoolean(Constants.FIRST_LOGIN, false).apply()
        }

        val userId = sharedPreferences.getLong(Constants.USER_LOGGED_ID, 0)

        Handler(Looper.getMainLooper()).postDelayed({
            if (userId > 0) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 2500)

    }

    private fun insertFakePosts() {
        val post1 = PostsEntity("Ricardo", "Hoje está um ótimo dia", Date(), 0)
        post1.save()

        val post2 = PostsEntity(
            "Maria",
            "A vida exige muito de nós, mas quem tem coragem de arriscar pode conquistar o mundo.",
            Date(),
            0
        )
        post2.save()

        val post3 = PostsEntity(
            "Fernando",
            "O sucesso é a soma de pequenos esforços repetidos dia após dia.",
            Date(),
            0
        )
        post3.save()

        val post4 = PostsEntity(
            "José",
            "Todos os dias faça um pouco mais do que você acha que consegue.",
            Date(),
            0
        )
        post4.save()
    }

}