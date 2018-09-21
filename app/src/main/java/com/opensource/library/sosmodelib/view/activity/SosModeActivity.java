package com.opensource.library.sosmodelib.view.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.opensource.library.sosmodelib.view.fragment.SosModeFragment;

public class SosModeActivity extends AppCompatActivity implements SosModeFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
