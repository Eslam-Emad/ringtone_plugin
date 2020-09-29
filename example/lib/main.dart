import 'package:flutter/material.dart';
import 'package:ringtone_plugin/ringtone_plugin.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              FlatButton(
                  onPressed: () async {
                    await RingtonePlugin.start();
                  },
                  child: Text('START')),
              SizedBox(
                height: 50,
              ),
              FlatButton(
                  onPressed: () async {
                    await RingtonePlugin.stop();
                  },
                  child: Text('STOP'))
            ],
          ),
        ),
      ),
    );
  }
}
