package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.Menu;

public class MainActivity extends Activity {

	private NotificationManager notificationManager;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        notificationManager = getNotificationManager();
        
        Builder build = new Notification.Builder(this)
        .setContentTitle("New JellyBean Notification")
        .setContentText("This is just an example")
        .setSmallIcon(R.drawable.ic_action_search)
        .setPriority(Notification.PRIORITY_HIGH)
        .setSmallIcon(R.drawable.ic_action_search)
        .addAction(
         android.R.drawable.ic_btn_speak_now,
         "Speak!",
         PendingIntent.getActivity(getApplicationContext(), 0,getIntent(), 0, null))
         .addAction(
         android.R.drawable.ic_dialog_email,
         "Email",
         PendingIntent.getActivity(getApplicationContext(), 0,getIntent(), 0, null))
         .addAction(
         android.R.drawable.ic_dialog_info,"Info", PendingIntent.getActivity(getApplicationContext(), 0,getIntent(), 0, null));

        
         Notification notification = new Notification.BigPictureStyle(build)
         .bigPicture
         (
         BitmapFactory.decodeResource(getResources(),R.drawable.jellybean)).build();
         Intent notificationIntent = new Intent(this, MainActivity.class);
         notificationManager.notify(0, notification);
         
         
    }

	private NotificationManager getNotificationManager() {
		return (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
