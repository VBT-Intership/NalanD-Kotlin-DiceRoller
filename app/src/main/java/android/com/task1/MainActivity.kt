package android.com.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloText: TextView = findViewById(R.id.hello_text)
        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener{rollDice()}
        helloText.text = "Dice Rolled!"

        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener{count()}
    }

    private fun rollDice() {
        val rollText: TextView = findViewById(R.id.roll_text)
        val randomInt = (1..6).random()
        rollText.text = randomInt.toString()
        Toast.makeText(this, "Roll Clicked", Toast.LENGTH_SHORT).show()

        lateinit var diceImage : ImageView
        diceImage = findViewById(R.id.dice_image)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)

    }

    private fun count() {
        val countText: TextView = findViewById(R.id.count_text)
        Toast.makeText(this, "Count Clicked", Toast.LENGTH_SHORT).show()
        if (countText.text == "Hello") {
            countText.text = "1"
        } else {
            var countInt = countText.text.toString().toInt()
            if (countInt < 6){
                countInt++
                countText.text = countInt.toString()
            }
        }
    }
}