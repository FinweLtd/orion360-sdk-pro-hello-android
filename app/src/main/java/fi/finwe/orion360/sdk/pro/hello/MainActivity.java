package fi.finwe.orion360.sdk.pro.hello;

import android.os.Bundle;

import fi.finwe.orion360.sdk.pro.SimpleOrionActivity;

public class MainActivity extends SimpleOrionActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setOrionView(R.id.orion_view);
        setContentUri("https://s3.amazonaws.com/orion360-us/Orion360_test_video_2d_equi_360x180deg_1920x960pix_30fps_30sec_x264.mp4");
    }

}
