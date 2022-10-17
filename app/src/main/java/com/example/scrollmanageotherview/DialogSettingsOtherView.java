package com.example.scrollmanageotherview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.scrollmanageotherview.databinding.DialogSettingsOtherViewBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class DialogSettingsOtherView extends BottomSheetDialogFragment {

    private final FrameLayout otherView;
    private final CoordinatorLayout.LayoutParams layoutParams;
    private ManageActivity manageActivity;
    private final boolean horizontalScroll;

    public DialogSettingsOtherView(FrameLayout layout, boolean horizontalScroll) {
        this.otherView = layout;
        this.horizontalScroll = horizontalScroll;
        this.layoutParams = new CoordinatorLayout.LayoutParams(layout.getLayoutParams());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog builder = new BottomSheetDialog(requireContext(), getTheme());
        com.example.scrollmanageotherview.databinding.DialogSettingsOtherViewBinding binding = DialogSettingsOtherViewBinding.inflate(getLayoutInflater());
        builder.setContentView(binding.getRoot());
        manageActivity = (ManageActivity) requireContext();

        binding.checkbox.setChecked(horizontalScroll);

        binding.buttonTopStart.setOnClickListener(v -> setGravityView(Gravity.TOP | Gravity.START));
        binding.buttonTopEnd.setOnClickListener(v -> setGravityView(Gravity.TOP | Gravity.END));
        binding.buttonTopCenter.setOnClickListener(v -> setGravityView(Gravity.TOP | Gravity.CENTER));
        binding.buttonBottomStart.setOnClickListener(v -> setGravityView(Gravity.BOTTOM | Gravity.START));
        binding.buttonBottomCenter.setOnClickListener(v -> setGravityView(Gravity.BOTTOM | Gravity.CENTER));
        binding.buttonBottomEnd.setOnClickListener(v -> setGravityView(Gravity.BOTTOM | Gravity.END));

        binding.checkbox.setOnCheckedChangeListener((buttonView, isChecked) ->setHorizontalScroll(isChecked));

        return builder;
    }


    private void setHorizontalScroll(boolean checked){
        manageActivity.changeHorizontalScroll(checked);
        dismiss();
    }


    private void setGravityView(int gravityView) {
        layoutParams.gravity = gravityView;
        layoutParams.setMargins((int) getResources().getDimension(R.dimen.other_view_margin), (int) getResources().getDimension(R.dimen.other_view_margin), (int) getResources().getDimension(R.dimen.other_view_margin), (int) getResources().getDimension(R.dimen.other_view_margin));
        otherView.setLayoutParams(layoutParams);
        manageActivity.updateScrollView();
        dismiss();
    }
}