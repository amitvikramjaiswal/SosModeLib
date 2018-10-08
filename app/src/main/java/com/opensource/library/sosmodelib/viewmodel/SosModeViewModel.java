package com.opensource.library.sosmodelib.viewmodel;

import android.content.Context;

public class SosModeViewModel extends BaseViewModel {

    private DataListener dataListener;

    public SosModeViewModel(Context context, DataListener dataListener) {
        super(context);
        this.dataListener = dataListener;
    }

    public interface DataListener extends BaseViewModel.DataListener {

    }

}
