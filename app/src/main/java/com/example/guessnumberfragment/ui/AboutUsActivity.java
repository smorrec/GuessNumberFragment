package com.example.guessnumberfragment.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.guessnumberfragment.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AboutView view = AboutBuilder.with(this)
                .setName(R.string.name)
                .setSubTitle(R.string.activity)
                .setBrief(R.string.brief)
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGitHubLink(R.string.gitHub)
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .addLinkedInLink(R.string.linkedIn)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();



        setContentView(view);
    }
}