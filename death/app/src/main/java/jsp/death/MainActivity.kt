package jsp.death

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Parser.login()
        button.setOnClickListener {
            Parser.writePost()
            Toast.makeText(applicationContext,"업로드~^_^",Toast.LENGTH_SHORT).show()
        }
    }
}
