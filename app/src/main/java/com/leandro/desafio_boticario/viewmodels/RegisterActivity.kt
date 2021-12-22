package com.leandro.desafio_boticario.viewmodels

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.leandro.desafio_boticario.R

class RegisterActivity : AppCompatActivity() {

    lateinit var layoutRegister: ConstraintLayout

    lateinit var inputRegisterName: TextInputLayout
    lateinit var inputRegisterEmail: TextInputLayout
    lateinit var inputRegisterPassword: TextInputLayout
    lateinit var inputRegisterConfirmPassword: TextInputLayout

    lateinit var editRegisterName: TextInputEditText
    lateinit var editRegisterEmail: EditText
    lateinit var editRegisterPassword: TextInputEditText
    lateinit var editRegisterConfirmPassword: TextInputEditText

    lateinit var btnRegister: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setComponents()
    }

    private fun setComponents() {
        layoutRegister = findViewById(R.id.layout_register)

        inputRegisterName = findViewById(R.id.input_register_name)
        inputRegisterEmail = findViewById(R.id.input_register_email)
        inputRegisterPassword = findViewById(R.id.input_register_password)
        inputRegisterConfirmPassword = findViewById(R.id.input_register_confirm_password)

        editRegisterName = findViewById(R.id.register_edit_name)
        editRegisterEmail = findViewById(R.id.register_edit_email)
        editRegisterPassword = findViewById(R.id.register_edit_password)
        editRegisterConfirmPassword = findViewById(R.id.register_edit_confirm_password)

        btnRegister = findViewById(R.id.btn_register)

        btnRegister.setOnClickListener {
            register()
        }
    }

    private fun register() {
        TODO("Not yet implemented")
    }


}