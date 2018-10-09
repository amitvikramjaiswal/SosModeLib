package com.opensource.library.sosmodelib.view.activity;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.maps.android.clustering.ClusterManager;
import com.opensource.library.sosmodelib.R;
import com.opensource.library.sosmodelib.databinding.ActivitySosModeBinding;
import com.opensource.library.sosmodelib.model.IDUser;
import com.opensource.library.sosmodelib.viewmodel.SosModeViewModel;

import java.util.List;

public class SosModeActivity extends MapActivity implements SosModeViewModel.DataListener {

    private static final String ID_USER = "ID_USER";
    private ActivitySosModeBinding binding;
    private SosModeViewModel viewModel;
    private IDUser[] idUser;

    public static Intent getStartIntent(Context context, IDUser[] idUser) {
        Intent intent = new Intent(context, SosModeActivity.class);
        intent.putExtra(ID_USER, idUser);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().hasExtra(ID_USER)) {
            idUser = (IDUser[]) getIntent().getParcelableArrayExtra(ID_USER);
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sos_mode);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.map_container, mapFragment).commit();
        mapFragment.getMapAsync(this);

        viewModel = new SosModeViewModel(this, this);

    }

    @Override
    public void setUpClusterer() {
        clusterManager = new ClusterManager(this, googleMap);
        super.setUpClusterer();
    }

    @Override
    public void addClusterItem(List clusterItems) {
        super.addClusterItem(clusterItems);
        setBounds(clusterItems);
    }
}
