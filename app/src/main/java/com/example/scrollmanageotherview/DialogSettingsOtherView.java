package com.example.scrollmanageotherview;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class DialogSettingsOtherView extends BottomSheetDialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog builder = new BottomSheetDialog(getContext(), getTheme());
        builder.setContentView(R.layout.dialog_settings_other_view);

        return builder;
    }
}
