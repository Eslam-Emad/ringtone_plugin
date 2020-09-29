import 'dart:async';

import 'package:flutter/services.dart';

class RingtonePlugin {
  static const MethodChannel _channel = const MethodChannel('ringtone_plugin');

  static Future<dynamic> start() async {
    final String version = await _channel.invokeMethod('startService');
    return version;
  }

  static Future<dynamic> stop() async {
    final String version = await _channel.invokeMethod('stopService');
    return version;
  }
}
