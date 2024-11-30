package com.aysenurgokce.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.aysenurgokce.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var number = 0
    //Runnable-handler
    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler(Looper.getMainLooper() )
    //handler runnableyi kullanmamız için geliştirilen bir sınıftır


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
    fun startButton(view: View){
        number = 0
        runnable = object : Runnable{
            override fun run() {
                //burada ne yapacağımızı yazıyoruz
                number = number + 1
                binding.textView.text = "Time: ${number}"



                // kaç saniyede yapacağımıza karar verelim
                handler.postDelayed(runnable,1000) //->burada runnable yerine this de yazabilirizz
            }
        }
        handler.post(runnable)//runnable başlat demek
        binding.button.isEnabled = false//bu starta bastığımız an start butonunu tekrar kullanılmaz hale getirir

    }
    fun stopButton(view: View){
        //start buutonunu stopa bastıktan sonra aktive edebiliriz
        binding.button.isEnabled = true
        number = 0
        binding.textView.text = "Time: 0"
        handler.removeCallbacks(runnable)


    }

}
