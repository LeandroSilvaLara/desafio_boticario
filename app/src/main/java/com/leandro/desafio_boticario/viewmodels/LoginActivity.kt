package com.leandro.desafio_boticario.viewmodels

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.leandro.desafio_boticario.R
import com.leandro.desafio_boticario.service.Constants

class LoginActivity : AppCompatActivity() {

    lateinit var layoutLogin: ConstraintLayout

    lateinit var inputLoginEmail: TextInputLayout
    lateinit var inputLoginPassword: TextInputLayout
    lateinit var editEmail: TextInputEditText
    lateinit var editPassword: TextInputEditText
    lateinit var btnLogin: MaterialButton
    lateinit var layoutRegister: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setComponents()

        val successfullyRegistered =
            intent.getBooleanExtra(Constants.SUCCESSFULLY_REGISTERED, false)

        if (successfullyRegistered) {
            Snackbar.make(
                layoutLogin,
                getString(R.string.successfully_registered),
                Snackbar.LENGTH_LONG
            ).show()

        }
    }

    /**
     * Adicinando layout
     */

    private fun setComponents() {
        layoutLogin = findViewById(R.id.layout_login)
        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
        btnLogin = findViewById(R.id.btn_login)
        layoutRegister = findViewById(R.id.layout_register)
        inputLoginEmail = findViewById(R.id.input_login_email)
        inputLoginPassword = findViewById(R.id.input_login_password)

        btnLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
        }
    }

}

    private fun setComponents() {
        TODO("Not yet implemented")
    }
