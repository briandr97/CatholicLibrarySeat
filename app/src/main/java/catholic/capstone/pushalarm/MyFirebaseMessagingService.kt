package catholic.capstone.pushalarm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelID = "notification_channel"
const val channelName = "catholic.capstone.pushalarm"

class MyFirebaseMessagingService : FirebaseMessagingService(){
    private val TAG = "FirebaseService"

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "new Token: $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        if(remoteMessage.data.isNotEmpty()){
            //푸시알림을 data 형식으로 받는다면, 여기서 처리
            //아래와 같이 데이터가 오면
//            val data = remoteMessage.data
//            val title = data["title"]
//            data:{
//                title:randomTitle as string,
//                body:reminder.ogTitle as string,
//                image:reminder.ogImage as string,
//                url:reminder.url as string,
//            }

//            Log.d(TAG, "From: " + remoteMessage.from)
//            if(remoteMessage.notification!=null){
//                sendNotification(remoteMessage.notification?.body!!, remoteMessage.notification?.title!!)
//            }
        }

        remoteMessage.notification?.let{
            //푸시알림을 notification 형식으로 받는다면, 여기서 처리
            sendNotification(it.title!!, it.body!!)
            Log.d("TokenTest", "리모트 메시지 실행됐나? Yes")
        }
    }

    private fun sendNotification(title:String, text:String){
        //푸시알림 클릭 했을 때 이동할 Activity 지정
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

//        val intent=Intent(this, MainActivity::class.java).apply{
//            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//            putExtra("Notification", title)
//            putExtra("Notification", text)
//        }

        val pendingIntent= PendingIntent.getActivity(this, 0/*Request code*/, intent, PendingIntent.FLAG_ONE_SHOT)
        val defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder= NotificationCompat.Builder(this, channelID)
            .setSmallIcon(R.drawable.ic_catholic_blue)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
            .setContentTitle(title)
            .setContentText(text)
//            .setContent(getRemoteView(title, text))
//            커스텀 토스트를 사용하지 않고, 안드로이드 디폴트 푸시알림을 사용하려면
//            위 setContent() 한 줄을 지우고, setContentTitle(), setContentText()를 추가하면됨

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        val notificationManager2 = NotificationManagerCompat.from(this)
//        notificationManager2.notify(0, notificationBuilder.build())

        //Oreo Version 이하일 때 처리하는 코드
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }
        notificationManager.notify(0, notificationBuilder.build())
    }

//    푸시알림 커스텀 하는 메소드
//    private fun getRemoteView(title: String, text: String):RemoteViews{
//        val remoteView = RemoteViews("com.sopt.androidsharing", R.layout.item_main)
//
//    }

    companion object{
        fun getDeviceToken(){
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener{ task->
                if(!task.isSuccessful){
                    Log.d("TokenTest", "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token = task.result
                Log.d("TokenTest", token!!)
            })
        }

        private const val TAG = "ExampleMessagingService"
    }
}

