package com.example.sourcetreeexample

import android.animation.LayoutTransition
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.card.MaterialCardView
import android.view.ViewTreeObserver
import androidx.cardview.widget.CardView
import com.example.sourcetreeexample.dagger.DaggerAppComponent
import com.example.sourcetreeexample.dagger.appComponent
import com.example.sourcetreeexample.domain.NewsCloudUseCase
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var mExpandableTV:TextView
    private lateinit var mParentLayout:ConstraintLayout
    private lateinit var card:CardView

    private val LONG_TEXT = "Lorem ipsum dolor sit amet, et" +
            " alienum inciderint efficiantur nec, posse causae molestie" +
            " eos in. Ea vero praesent vix, nam soleat recusabo id." +
            " Qui ut exerci option laboramus. In habeo posse ridens quo," +
            " eligendi volutpat interesset ut est, mel nibh accusamus no." +
            " Te eam consulatu repudiare adipiscing, usu et choro quodsi euripidis."

    private val SHORT_TEXT = " For the 2009 model " +
            "the G35 sedan was replaced by the G37 sedan."


    @Inject
    lateinit var computer: Computer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appComponent.inject(this)

        


        if(supportActionBar!=null){
            supportActionBar?.hide()
        }

    }

    @Inject
    fun getNewsFromCloud(news:NewsCloudUseCase){
        Log.d("sdsdsdsdgdsg","getNewsFromCloud")
    }

   /* private fun setupChecking(){
        card.setOnClickListener {
            card.isChecked = !card.isChecked
        }
    }*/

    /*private fun setupDragging() {
        coordinatorLayout.addDraggableChild(card)
        coordinatorLayout.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
            override fun onViewCaptured(view: View, i: Int) {
                card.isDragged = true
            }

            override fun onViewReleased(view: View, v: Float, v1: Float) {
                card.isDragged = false
            }

        })
    }
*/
}