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
import com.example.guessnumberfragment.databinding.FragmentPlayBinding;

public class PlayFragment extends Fragment {

    private FragmentPlayBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentPlayBinding.inflate(inflater);
        binding.btTryAgain.setEnabled(false);

        binding.Try.addTextChangedListener(textWatcher());
        binding.btCheck.setOnClickListener(view -> check(binding.getGame()));
        binding.btTryAgain.setOnClickListener(view -> tryAgain(binding.getGame()));

        binding.setGame(getArguments().getParcelable(Game.KEY));

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

    private void check(Game game){
        if(game.getRespuesta() == game.getNumAdivinar() || game.getNumIntentos() ==0){
            endGame();
        }else if(game.getRespuesta() < game.getNumAdivinar()){
            binding.textResult.setText(R.string.mayor);
        }else{
            binding.textResult.setText(R.string.menor);
        }
        binding.Try.setEnabled(false);
        binding.btCheck.setEnabled(false);
        binding.btTryAgain.setEnabled(true);
    }

    private void tryAgain(Game game){
        game.setNumIntentos(game.getNumIntentos()-1);
        binding.textResult.setText(null);
        binding.Try.setText(null);
        binding.Try.setEnabled(true);
        binding.btTryAgain.setEnabled(false);
    }

    private void endGame(){
        Bundle bundle = new Bundle();
        bundle.putParcelable(Game.KEY, binding.getGame());

        NavHostFragment.findNavController(PlayFragment.this).navigate(R.id.action_PlayFragment_to_EndPlayFragment, bundle);
    }

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
                binding.btCheck.setEnabled(binding.getGame().getRespuesta() > 0 && binding.getGame().getRespuesta() <= 100);
            }
        });
    }

    //region SaveState
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(binding != null && outState != null) {
            outState.putParcelable(Game.KEY, binding.getGame());
            outState.putBoolean("btCheck", binding.btCheck.isEnabled());
            outState.putBoolean("btTryAgain", binding.btTryAgain.isEnabled());
            outState.putBoolean("try", binding.Try.isEnabled());
            outState.putString("textResult", binding.textResult.getText().toString());
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(binding != null && savedInstanceState != null){
            binding.setGame(savedInstanceState.getParcelable(Game.KEY));
            binding.btCheck.setEnabled(savedInstanceState.getBoolean("btCheck"));
            binding.btTryAgain.setEnabled(savedInstanceState.getBoolean("btTryAgain"));
            binding.Try.setEnabled(savedInstanceState.getBoolean("try"));
            binding.textResult.setText(savedInstanceState.getString("textResult"));
        }
    }
    //endregion
}