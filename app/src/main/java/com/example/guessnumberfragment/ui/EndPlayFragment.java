package com.example.guessnumberfragment.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guessnumberfragment.R;
import com.example.guessnumberfragment.data.Game;
import com.example.guessnumberfragment.databinding.FragmentEndPlayBinding;


public class EndPlayFragment extends Fragment {

    private FragmentEndPlayBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEndPlayBinding.inflate(inflater);
        binding.setGame(getArguments().getParcelable(Game.KEY));
        binding.btPlayAgain.setOnClickListener(view -> playAgain());
        finalView(binding.getGame());
        return binding.getRoot();
    }

    private void finalView(Game game){
        if(game.getNumIntentos() > 0){
            successView();
        }else{
            failView();
        }
    }

    private void successView(){
        binding.textResult.setText(R.string.success);
        binding.textNumIntentosRestantes.setText(R.string.numIntentos);
        binding.textNumIntentosRestantes.append(String.valueOf(binding.getGame().getNumIntentos()));
    }

    private void failView(){
        binding.textResult.setText(R.string.fail);
    }

    private void playAgain(){
        NavHostFragment.findNavController(EndPlayFragment.this).navigate(R.id.action_EndPlayFragment_to_ConfigFragment);
    }
}