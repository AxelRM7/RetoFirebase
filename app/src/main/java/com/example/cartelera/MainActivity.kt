package com.example.cartelera

import androidx.appcompat.app.AppCompatActivity
import com.example.cartelera.databinding.ActivityMainBinding
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONArray

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val database = Firebase.database
        val dataRef = database.reference
        //dataRef.child("Movies").get().addOnSuccessListener { respuesta ->
          //  binding.RVCartelera.adapter = MainAdapter(JSONArray(respuesta.value.toString()))
        //}
        binding.BTNEnviar.setOnClickListener{
            dataRef.child("Movies").child(binding.ETID.text.toString()).setValue(
                Movies(
                    binding.ETTitulo.text.toString(),
                    binding.ETYear.text.toString(),
                    binding.ETImBDID.text.toString(),
                    binding.ETType.text.toString(),
                    binding.ETPoster.text.toString(),
                    binding.ETCountry.text.toString(),
                    binding.ETGenere.text.toString()
                )
            )
            dataRef.child("Movies").get().addOnSuccessListener {response ->
                Log.d("prueba", response.value.toString())
                val jsonArray = JSONArray(response.value.toString())
                binding.RVCartelera.adapter = MainAdapter(jsonArray)
            }
        }

    }
}