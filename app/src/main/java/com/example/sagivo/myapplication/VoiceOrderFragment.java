package com.example.sagivo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.List;

public class VoiceOrderFragment extends Fragment {

    private static final int SPEECH_REQUEST_CODE = 10;
    TextView text_view;
    FloatingActionMenu actionMenu;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_voice_order ,container,false);

        text_view = (TextView)v.findViewById(R.id.voice_result);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this.getActivity());
        // repeat many times:
        ImageView itemIcon = new ImageView(this.getActivity());
        itemIcon.setImageDrawable(getResources().getDrawable(R.drawable.cam));
        SubActionButton button1 = itemBuilder.setContentView(itemIcon).build();

        ImageView itemIcon2 = new ImageView(this.getActivity());
        itemIcon2.setImageDrawable(getResources().getDrawable(R.drawable.voice));
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getReq();
            }
        });
        ImageView itemIcon3 = new ImageView(this.getActivity());
        itemIcon3.setImageDrawable(getResources().getDrawable(R.drawable.email));
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();


        actionMenu = new FloatingActionMenu.Builder(this.getActivity())
                .addSubActionView(button1)
                .addSubActionView(button3)
                .addSubActionView(button2)
                .attachTo(v.findViewById(R.id.action_fab)).build();

        //recordVoice();
        return v;
    }

    // This callback is invoked when the Speech Recognizer returns.
    // This is where you process the intent and extract the speech text from the intent.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        actionMenu.close(true);

        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            text_view.setText(spokenText.toString());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    void getReq(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Place Your Order...");
        // Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }
}