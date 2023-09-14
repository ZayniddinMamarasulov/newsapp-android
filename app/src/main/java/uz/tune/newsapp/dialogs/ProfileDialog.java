package uz.tune.newsapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import uz.tune.newsapp.R;
import uz.tune.newsapp.databinding.DialogProfileEditBinding;

public class ProfileDialog extends DialogFragment {

    private Callback callback;
    private DialogProfileEditBinding binding;

    public ProfileDialog(Callback callback) {
        this.callback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_profile_edit, container, false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = DialogProfileEditBinding
                .inflate(LayoutInflater.from(getContext()));

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Bosildi", Toast.LENGTH_SHORT).show();
                callback.onCancelClicked();
                ProfileDialog.this.dismiss();
            }
        });

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onDeleteClicked();
                ProfileDialog.this.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());

        return builder.create();
    }

    public interface Callback {
        void onCancelClicked();

        void onDeleteClicked();
    }
}
