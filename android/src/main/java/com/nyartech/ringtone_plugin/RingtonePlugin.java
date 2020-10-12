package com.nyartech.ringtone_plugin;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import com.nyartech.ringtone_plugin.RingtonePlayingService;

public class RingtonePlugin implements FlutterPlugin, MethodCallHandler {
  private MethodChannel channel;
  private Context context;
  private Intent intent;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    context = flutterPluginBinding.getApplicationContext();
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "ringtone_plugin");
    channel.setMethodCallHandler(this);
    
    intent = new Intent(context, RingtonePlayingService.class);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {   
    switch (call.method) {
        case "startService":
          context.startService(intent);
          result.success("Started service.");
          break;
        case "stopService":
          context.stopService(intent);
          result.success("Stoppped service.");
          break;
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }

  @SuppressWarnings("deprecation")
  public static void registerWith(io.flutter.plugin.common.PluginRegistry.Registrar registrar) {
    RingtonePlugin instance = new RingtonePlugin();
    
    instance.context = registrar.context();
    instance.channel = new MethodChannel(registrar.messenger(), "ringtone_plugin");
    instance.channel.setMethodCallHandler(instance);

    instance.intent = new Intent(instance.context, RingtonePlayingService.class);
  }
}
