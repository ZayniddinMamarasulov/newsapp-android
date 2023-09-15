package uz.tune.newsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import uz.tune.newsapp.databinding.ActivityMainBinding;
import uz.tune.newsapp.dialogs.ProfileDialog;
import uz.tune.newsapp.views.MyViewPagerFragment;

public class MainActivity extends AppCompatActivity implements ProfileDialog.Callback {

    private ActivityMainBinding binding;

    private Map<String, Boolean> checkedAnimals;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkedAnimals = new HashMap<>();

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedAnimals = new HashMap<>();

                AlertDialog.Builder dialog =
                        new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("Bu title")
//                        .setMessage("O'chirishni xohlaysizmi ?")
                        .setMultiChoiceItems(R.array.animals, null,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                        checkedAnimals
                                                .put(getResources().getStringArray(R.array.animals)[i], b);

//                                        dialogInterface.dismiss();
                                    }
                                })
                        .setIcon(getResources().getDrawable(R.drawable.ic_launcher_background))
                        .setCancelable(false)
                        .setPositiveButton("Ha", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, checkedAnimals.toString()
                                        , Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Yo\'q", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Yo'q bosildi",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("Info", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Info",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create()
                        .show();
            }
        });

        binding.btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ProfileDialog profileDialog = new ProfileDialog(MainActivity.this);
//                profileDialog.show(getSupportFragmentManager(), ProfileDialog.class.toString());

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, new MyViewPagerFragment())
                        .addToBackStack("")
                        .commit();
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new HomeFragment())
                .addToBackStack("")
                .commit();
    }

    @Override
    public void onCancelClicked() {
        Toast.makeText(this, "Cancel bosildi", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteClicked() {
        Toast.makeText(this, "Delete bosildi", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}