package com.jqk.andservertest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jqk.andservertest.databinding.ActivityMainBinding
import com.yanzhenjie.andserver.AndServer
import com.yanzhenjie.andserver.Server
import java.net.InetAddress
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var b: ActivityMainBinding
    var mServer: Server? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = DataBindingUtil.setContentView(this, R.layout.activity_main)
        b.view = this

        initServer()
    }

    fun initServer() {
        mServer = AndServer.webServer(this)
            .port(8080)
            .timeout(10, TimeUnit.SECONDS)
            .listener(object : Server.ServerListener {  //服务器监听接口
                override fun onException(e: Exception?) {

                }

                override fun onStarted() {
                    L.d("onStarted")
                }

                override fun onStopped() {
                    L.d("onStopped")
                }
            })
            .build()
    }

    fun startServer(view: View) {
        if (mServer?.isRunning!!) {
            // TODO The server is already up.
        } else {
            mServer?.startup();
        }
    }

    fun stopServer(view: View) {

        if (mServer?.isRunning!!) {
            mServer?.shutdown();
        } else {
            L.d("AndServer", "The server has not started yet.");
        }
    }
}
