![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057016/bf5fffb2-a4f1-11e6-9e25-0a8efa6203ff.png)

# Hello World with Orion360 SDK (Pro) for Android

This repository contains a minimal Hello World -style example of adding 360 video playback capability into an Android application project using Android Studio and Orion360 SDK for Android.

> This application is available in [Google Play](https://play.google.com/store/apps/details?id=fi.finwe.orion360.sdk.pro.hello)

Table of Contents
-----------------
1. [Prerequisities](#prerequisities)
2. [Cloning the project](#cloning-the-project)
3. [Creating an empty application project](#creating-an-empty-application-project)
4. [Acquiring Orion360 SDK binaries](#acquiring-orion360-sdk-binaries)
5. [Adding OrionVideoView to the XML layout](#adding-orionvideoview-to-the-xml-layout)
6. [Writing Java code](#writing-java-code)
7. [Adding Android permissions](#adding-android-permissions)
8. [Acquiring Orion360 SDK license file](#acquiring-orion360-sdk-license-file)
9. [Running the application](#running-the-application)
10. [What next?](#what-next)

Prerequisities
--------------

Install Android Studio IDE (recommended version is 2.2 or newer):
https://developer.android.com/studio/install.html

Then, using the SDK Manager tool, install one or more Android SDKs. Notice that for Orion360 SDK Pro, minimum API level is 19: Android 4.4 KitKat.

Cloning the project
-------------------

> You can either create the project from scratch by following the instructions below, or clone the ready project from GitHub as explained here.

To clone the project from GitHub, start Android Studio, select "Check out project from Version Control" and "Git" from the popup dialog.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20058263/c0470d06-a4f8-11e6-976f-805ae8027973.png)

Set repository URL, parent directory, and project directory. 

Notice that the repository URL is easy to copy-paste from browser to Android Studio: click the green "Clone or download" button on the project's GitHub page, copy the URL from the dialog that appears, and paste it to Android Studio's dialog.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20058276/d3cabf8a-a4f8-11e6-904b-73740a1df849.png)

Cloning the project will take a moment. Android Studio then asks if you want to open the project. Answer "Yes".

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20058289/e32e764c-a4f8-11e6-95b5-e47247569ac0.png)

The project opens, and Android Studio performs Gradle sync that will take some time (please wait). After Gradle sync finishes, you can find the project files by opening the Project view on the left.

You can now proceed to connecting an Android device to your computer via a USB cable, and then run the app on device.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20058305/f22b5d5e-a4f8-11e6-9b77-8916a2589bc8.png)


Creating an empty application project
-------------------------------------

Start Android Studio application. From the welcome screen, select 'Start a new Android Studio project'.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057508/968046b2-a4f4-11e6-8e77-170ee3f06398.png)

Fill in your application name, company domain, package name, and project location. Click Next button.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057520/afd7c270-a4f4-11e6-92e8-0d4a9edfcf61.png)

Check that "Phone and Tablet" is selected, and the minimum SDK is at least "API 19: Android 4.4 (KitKat)". Click Next.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057538/c7fb0132-a4f4-11e6-9a6b-0c09d3b70363.png)

Choose "Empty Activity". Click Next.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057571/fa75faf4-a4f4-11e6-9de4-216b76de152b.png)

Accept the default settings for activity name and layout file. Click Finish. New application project will be created.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057580/0bfddbca-a4f5-11e6-9423-5b42a24051a1.png)

After a moment of processing, you should see Android Studio IDE with your newly created project files. 

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057608/227c5188-a4f5-11e6-9e30-129adbc2e1b9.png)

Connect an Android phone or tablet to your computer using a USB cable, and check that developer mode has been enabled: you should find "Developer options" under your device's Settings view. If not, navigate to Settings > About phone > Build number, and tap the section 7 times to become a developer.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057620/30f58b08-a4f5-11e6-8382-cef6cf23be2f.png)

From Android Studio menu, select Run > Run 'app', and when the 'Select Deployment Target' dialog appears, check that your device shows up in the "Connected Devices" list, and is selected. Click OK. The application will be built and deployed to your device.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057632/45c31f46-a4f5-11e6-8e77-aace5b0e4bb8.png)

After a moment of processing, the app should start on your Android device.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20057643/581236b4-a4f5-11e6-8bf8-1382af90cab7.png)

Acquiring Orion360 SDK binaries
-------------------------------

Now that the application project skeleton is working, let's add 360 video playback capability using Orion360 SDK.

First, we need to acquire Orion360 SDK binaries. To make this super easy for developers, we distribute them via our public repository at bintray.com. Let's add the repository to the project.

In Android Studio's Project view, expand Gradle Scripts and double click build.gradle file for the Project.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20058775/581f416e-a4fb-11e6-9b07-b0bd1349b20d.png)

Find section 'allprojects' and add the following line inside 'repositories':

```gradle
maven { url 'https://finwe.bintray.com/orion360-sdk-public' } // For Orion360 SDK
```

After editing a gradle file, the IDE suggests to sync the project. Accept the suggestion, or click the Sync button from the toolbar.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20058788/6cf0953e-a4fb-11e6-9c9a-4596872db28c.png)

After gradle sync has finished, in Android Studio's Project view, double click build.gradle file for the app module. Find section 'dependencies', and add the following line inside it:

```gradle
compile 'fi.finwe.orion360:orion360-sdk-pro:3.0.01' // From Finwe maven repo at Bintray
```

After editing a gradle file, the IDE suggests to sync the project. Accept the suggestion, or click the Sync button from the toolbar.

Notice that here we will use version '3.0.01' of the SDK binaries. When new versions are released, you can simply type here the version number that you wish to use in your project. Upgrading to the latest Orion360 version requires nothing more than changing the version number, performing gradle sync, and rebuilding the app (unless there are API changes).

![alt tag](https://cloud.githubusercontent.com/assets/12032146/20058808/86abfb4e-a4fb-11e6-84d3-f010e27de611.png)

Now we can use Orion360 SDK in the project. 

Adding OrionVideoView to the XML layout
---------------------------------------

In Android Studio's Project view, expand res > layout and double click activity_main.xml. Select 'Text' pane to hide the designer and show the layout's XML code. Then, above TextView item, add the following lines:

```xml
<fi.finwe.orion360.OrionVideoView
  android:id="@+id/orion_video_view"
  android:layout_width="match_parent"
  android:layout_height="match_parent" />
```

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18171902/39551fc4-706c-11e6-919d-8ab34323f89d.png)

If you now switch back to 'Design' tab, you can see that the video view will expand to fill the layout.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18171955/68955dee-706c-11e6-8d00-690fea36c5ef.png)

Writing Java code
-----------------

In Android Studio's Project view, expand java > [package name] and double click MainActivity. 

Add a class member variable for the video view, and press ALT+ENTER when Android Studio suggests to import the missing class (fi.finwe.orion360.OrionVideoView).

```java
private OrionVideoView mOrionVideoView;
```

Then append to onCreate() method a line to retrieve the video view object that we defined in the activity's XML layout:

```java
mOrionVideoView = (OrionVideoView) findViewById(R.id.orion_video_view);
```

Preparing a video for playback always takes a moment, therefore we need to become a listener for a callback that tells when the video player is ready. When the callback comes, we can start the player.

```java
mOrionVideoView.setOnPreparedListener(new OrionVideoView.OnPreparedListener() {
  @Override
  public void onPrepared(OrionVideoView orionVideoView) {
    mOrionVideoView.start();
  }
});
```

You can play a 360 video file by calling the prepare() method. When called, Orion360 SDK will first check if a valid license file is available, and then proceed to preparing the video player. When done, onPrepared() will be called - and the playback begins, as we have requested above.

```java
try {
  mOrionVideoView.prepare("http://www.finwe.mobi/orion360/test/equi/Orion360_test_video_1920x960.mp4");
} catch (OrionVideoView.LicenseVerificationException e) {
  Log.e("OrionVideoView", "Orion360 SDK license could not be verified!", e);
}
```

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18172784/8fd0f53c-706f-11e6-895f-f8e137e0c30a.png)

Finally, we need to let the video player to respond to the activity's life cycle events, so that it can automatically pause and resume along the activity, and clean up when the activity gets destroyed. Let's propagate them to the video view as follows:

```java
    @Override
    public void onStart() {
        super.onStart();

        mOrionVideoView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        mOrionVideoView.onResume();
    }

    @Override
    public void onPause() {
        mOrionVideoView.onPause();

        super.onPause();
    }

    @Override
    public void onStop() {
        mOrionVideoView.onStop();

        super.onStop();
    }

    @Override
    public void onDestroy() {
        mOrionVideoView.onDestroy();

        super.onDestroy();
    }
```

Now we have written all Java code that is required for a basic 360 video player.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18172876/f9ef3924-706f-11e6-9829-fc5e418486fe.png)

Adding Android permissions
--------------------------

Since we are going to stream a video file from the network, we must add INTERNET permission to the application project's manifest file, as usual. In Android Studio's Project view, expand app > manifests, and double click AndroidManifest.xml. Then add the following line above 'application' section:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18173579/c98d8706-7072-11e6-8d7c-5c9aecf39abf.png)

Acquiring Orion360 SDK license file
-----------------------------------

As Orion360 SDK is a commercial product, it requires a license file to work. In order to get a license file for your own app, you need to buy the SDK. Your license file will be locked to the package name you have selected for your app. To apply the license file, in the Android Studio's Project view, create a directory 'assets' under the 'app' root, and download and copy the license file there.

However, to continue evaluating the SDK with the hello app, you can use the (watermarked) license file that is provided with this tutorial. Following the instructions above, download and copy this file under your project's /assets folder:

[Orion Hello License File](app/src/main/assets/fi.finwe.orion360.sdk.basic.hello.key.lic)

> **Notice that the license file is a simple text file, but since it is signed, any kind of editing makes it invalid. Especially, watch out line endings - file editors, version control software and copy-paste operation may silently convert between CR/LF and LF characters, and even though the file looks exactly the same, it isn't!**

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18173330/e3fb482c-7071-11e6-9056-0d0cbba3c17a.png)

Running the application
-----------------------

Now we are ready to try the app on device. From Android Studio menu, select Run > Run 'app', and when the 'Select Deployment Target' dialog appears, check that your device shows up in the "Connected Devices" list, and is selected. Click OK. The application will be built and deployed to your device.

![alt tag](https://cloud.githubusercontent.com/assets/12032146/18173844/e18644f0-7073-11e6-84ea-82275531210e.png)

The application begins to stream the video file from network, and when the media player has buffered enough content, video starts to play on screen. Since this is a 360 video, you can look around: try out panning by rotating the device around you or by pulling the image with a finger. Use 2-finger pinch and rotate to zoom and rotate the image, respectively.

In just a few minutes, you have created your own 360 video player app that can play equirectangular MP4 video files from the network and supports gyro and touch panning, as well as pinch zooming and rotating. Pretty cool, ha?

What next?
----------

You have barely scratched the surface! To learn more about the Orion360 SDK, clone the Orion360 SDK example app from the following Github repository, and open the project in Android Studio. Go through the examples to learn how to play videos and images from different locations, apply VR mode, add interactive hotspots, and lots of other cool features.

https://github.com/FinweLtd/orion360-sdk-basic-examples-android
