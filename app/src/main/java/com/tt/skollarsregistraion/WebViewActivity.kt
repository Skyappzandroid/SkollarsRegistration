package com.tt.skollarsregistraion

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.tt.skollarsregistraion.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebViewBinding
    var url: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.getStringExtra("type") != null) {
            url = intent.getStringExtra("type")!!
        }

        val customIntent = CustomTabsIntent.Builder()

        customIntent.setToolbarColor(
            ContextCompat.getColor(
                this@WebViewActivity,
                R.color.secondary_color
            )
        )

        openCustomTab(
            this@WebViewActivity,
            customIntent.build(),
            Uri.parse(url)
        )


    }


    fun openCustomTab(activity: Activity, customTabsIntent: CustomTabsIntent, uri: Uri?) {
        // package name is the default package
        // for our custom chrome tab
        val packageName = "com.android.chrome"
        if (packageName != null) {
            customTabsIntent.intent.setPackage(packageName)
            customTabsIntent.launchUrl(activity, uri!!)
            finish()
        } else {
            activity.startActivity(Intent(Intent.ACTION_VIEW, uri))
            finish()
        }
    }

}