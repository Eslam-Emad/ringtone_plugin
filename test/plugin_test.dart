import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:ringtone_plugin/ringtone_plugin.dart';

void main() {
  const MethodChannel channel = MethodChannel('ringtone_plugin');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('start', () async {
    expect(await RingtonePlugin.start(), 'Started service.');
  });
}
