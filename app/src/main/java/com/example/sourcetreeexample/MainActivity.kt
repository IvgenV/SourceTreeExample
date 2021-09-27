package com.example.sourcetreeexample

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.pm.PackageInfoCompat
import com.example.sourcetreeexample.dagger.appComponent
import com.example.sourcetreeexample.domain.NewsCloudUseCase
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var mExpandableTV: TextView
    private lateinit var mParentLayout: ConstraintLayout
    private lateinit var card: CardView
    private lateinit var textRemote: TextView

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

    @Inject
    lateinit var news: NewsCloudUseCase

    lateinit var pInfo: PackageInfo
    var longVersionCode: Long? = null
    var myVersionCode: Int? = null
    lateinit var firebaseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textRemote = findViewById(R.id.textRemote)
        firebaseButton = findViewById(R.id.firebaseButton)



        appComponent.inject(this)

        val defaultValue = hashMapOf<String, Any?>()
        defaultValue["new_version_code"] = "defaultValueError!"
        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 10
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(defaultValue)
        textRemote.text = remoteConfig.getString("new_version_code")
        firebaseButton.setOnClickListener {
            remoteConfig.fetchAndActivate().addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Log.d("MYLOG", "isSuccessful")
                    Toast.makeText(this, "remoteconfig!", Toast.LENGTH_SHORT).show()
                    textRemote.text = remoteConfig.getString("new_version_code")
                }else{
                    Toast.makeText(this, "remoteconfigError!", Toast.LENGTH_SHORT).show()
                    textRemote.text = remoteConfig.getString("new_version_code")
                }
            }
        }



        if (supportActionBar != null) {
            supportActionBar?.hide()
        }

    }

    @Inject
    fun getNewsFromCloud(news: NewsCloudUseCase) {
        Log.d("sdsdsdsdgdsg", "getNewsFromCloud")
    }

    fun getVersionCode(): String {
        try {
            pInfo = packageManager.getPackageInfo(packageName, 0)
            longVersionCode = PackageInfoCompat.getLongVersionCode(pInfo)
            myVersionCode = longVersionCode?.toInt()
        } catch (e: PackageManager.NameNotFoundException) {
            Log.i("MYLOG", "NameNotFoundException ${e.message}")
        }
        return myVersionCode.toString()
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