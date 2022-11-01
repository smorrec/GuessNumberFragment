package com.example.guessnumberfragment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.guessnumberfragment.R;
import com.example.guessnumberfragment.data.Game;
import com.example.guessnumberfragment.databinding.FragmentConfigBinding;

public class ConfigFragment extends Fragment {

    private FragmentConfigBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentConfigBinding.inflate(inflater);
        binding.setGame(new Game());
        binding.btSend.setOnClickListener(view -> play());
        /**
         * Declaro un listener a cada uno de los textedit para que el botón esté
         * desabilitado si los valores introducidos en estos no son válidos
         */
        binding.User.addTextChangedListener(textWatcher());
        binding.NumIntentos.addTextChangedListener(textWatcher());
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void play(){
        Bundle bundle = new Bundle();
        bundle.putParcelable(Game.KEY, binding.getGame());

        NavHostFragment.findNavController(ConfigFragment.this).navigate(R.id.action_ConfigFragment_to_PlayFragment, bundle);

    }

    /**
     * Método que devuelve un TextWatcher con su método afterTextChanged modificado para
     * que active o desactive el botón de jugar.
     * @return
     */
    private TextWatcher textWatcher(){
        return (new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(binding.getGame().getUsuario() == null || binding.getGame().getUsuario().equals("") || binding.getGame().getNumIntentos() <= 0){
                    binding.btSend.setEnabled(false);
                }else{
                    binding.btSend.setEnabled(true);
                }
            }
        });
    }

    //region SaveState
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(binding != null && outState != null) {
            outState.putParcelable(Game.KEY, binding.getGame());
            outState.putBoolean("btSend", binding.btSend.isEnabled());
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(binding != null && savedInstanceState != null){
            binding.setGame(savedInstanceState.getParcelable(Game.KEY));
            binding.btSend.setEnabled(savedInstanceState.getBoolean("btSend"));
        }
    }
    //endregion
}