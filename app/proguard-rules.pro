# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class dagger.** { *; }
-keep class javax.inject.** { *; }
-keep class ** extends dagger.hilt.** { *; }
-keep @dagger.hilt.android.internal.** class * { *; }
-keep @dagger.hilt.** class * { *; }
-keep class * extends dagger.hilt.android.components.** { *; }
-keepclassmembers class * {
    @dagger.Provides <methods>;
    @dagger.Binds <methods>;
}
-keep class com.studio35.data.** { *;}
-keep class com.studio35.domain.** { *; }
-keep class com.studio35.designsystem.** { *; }
