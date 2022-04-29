package com.example.newkotlingame

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var leftTop: ImageView
    private lateinit var leftMiddle: ImageView
    private lateinit var leftBottom: ImageView
    private lateinit var centerTop: ImageView
    private lateinit var centerMiddle: ImageView
    private lateinit var centerBottom: ImageView
    private lateinit var rightTop: ImageView
    private lateinit var rightMiddle: ImageView
    private lateinit var rightBottom: ImageView

    private lateinit var surprisedPikachu: ImageView
    private lateinit var congratulations: TextView
    private lateinit var completed: TextView

    private val pikachuPieceImages = listOf(
        listOf(
            R.drawable.pikachu_left_top,
            R.drawable.pikachu_left_top_2,
            R.drawable.pikachu_left_top_3,
            R.drawable.pikachu_left_top_4
        ),
        listOf(
            R.drawable.pikachu_left_middle,
            R.drawable.pikachu_left_middle_2,
            R.drawable.pikachu_left_middle_3,
            R.drawable.pikachu_left_middle_4
        ),
        listOf(
            R.drawable.pikachu_left_bottom,
            R.drawable.pikachu_left_bottom_2,
            R.drawable.pikachu_left_bottom_3,
            R.drawable.pikachu_left_bottom_4
        ),
        listOf(
            R.drawable.pikachu_center_top,
            R.drawable.pikachu_center_top_2,
            R.drawable.pikachu_center_top_3,
            R.drawable.pikachu_center_top_4
        ),
        listOf(
            R.drawable.pikachu_center_middle,
            R.drawable.pikachu_center_middle_2,
            R.drawable.pikachu_center_middle_3,
            R.drawable.pikachu_center_middle_4
        ),
        listOf(
            R.drawable.pikachu_center_bottom,
            R.drawable.pikachu_center_bottom_2,
            R.drawable.pikachu_center_bottom_3,
            R.drawable.pikachu_center_bottom_4
        ),
        listOf(
            R.drawable.pikachu_right_top,
            R.drawable.pikachu_right_top_2,
            R.drawable.pikachu_right_top_3,
            R.drawable.pikachu_right_top_4
        ),
        listOf(
            R.drawable.pikachu_right_middle,
            R.drawable.pikachu_right_middle_2,
            R.drawable.pikachu_right_middle_3,
            R.drawable.pikachu_right_middle_4
        ),
        listOf(
            R.drawable.pikachu_right_bottom,
            R.drawable.pikachu_right_bottom_2,
            R.drawable.pikachu_right_bottom_3,
            R.drawable.pikachu_right_bottom_4
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startTime = System.nanoTime()
        var indexes = arrayOf((0..3).random(), (0..3).random(), (0..3).random(), (0..3).random(), (0..3).random(), (0..3).random(), (0..3).random(), (0..3).random(), (0..3).random())
        completed = findViewById(R.id.time_score)
        congratulations = findViewById(R.id.congrats)

        completed.visibility = View.INVISIBLE
        congratulations.visibility = View.INVISIBLE

        leftTop = findViewById(R.id.pikachu_left_top)
        leftMiddle = findViewById(R.id.pikachu_left_middle)
        leftBottom = findViewById(R.id.pikachu_left_bottom)
        centerTop = findViewById(R.id.pikachu_center_top)
        centerMiddle = findViewById(R.id.pikachu_center_middle)
        centerBottom = findViewById(R.id.pikachu_center_bottom)
        rightTop = findViewById(R.id.pikachu_right_top)
        rightMiddle = findViewById(R.id.pikachu_right_middle)
        rightBottom = findViewById(R.id.pikachu_right_bottom)

        surprisedPikachu = findViewById(R.id.complete_pikachu)

        surprisedPikachu.visibility = View.INVISIBLE

        var images = listOf(
            leftTop,
            leftMiddle,
            leftBottom,
            centerTop,
            centerMiddle,
            centerBottom,
            rightTop,
            rightMiddle,
            rightBottom
        )

        for (a in images) {
            a.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    pikachuPieceImages[images.indexOf(a)][indexes[images.indexOf(a)]]
                )
            )
            a.setOnClickListener {
                if (indexes[images.indexOf(a)] < 3) {
                    indexes[images.indexOf(a)] += 1
                } else {
                    indexes[images.indexOf(a)] = 0
                }
                a.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        pikachuPieceImages[images.indexOf(a)][indexes[images.indexOf(a)]]
                    )
                )
                var completedImage = true
                for (a in indexes) {
                    if (a != 0) {
                        completedImage = false
                    }
                }
                if (completedImage == true) {
                    for (a in images) {
                        a.visibility = View.INVISIBLE
                        surprisedPikachu.visibility = View.VISIBLE
                    }
                    val stopTime = System.nanoTime()
                    val timeScore = (stopTime - startTime) / 1000000000
                    completed.setText("Time: $timeScore seconds")
                    completed.visibility = View.VISIBLE
                    congratulations.visibility = View.VISIBLE
                }
            }

        }
    }
}
