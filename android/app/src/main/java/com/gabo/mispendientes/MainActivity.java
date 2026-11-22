package com.gabo.mispendientes;

import android.content.Intent;
import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(ShareReceiverPlugin.class);
        super.onCreate(savedInstanceState);
        handleShare(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleShare(intent);
    }

    private void handleShare(Intent intent) {
        if (intent == null || !Intent.ACTION_SEND.equals(intent.getAction())) return;
        String type = intent.getType();
        if (type == null || !type.startsWith("text/")) return;
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (text == null || text.trim().isEmpty()) return;
        String subject = intent.getStringExtra(Intent.EXTRA_SUBJECT);
        ShareReceiverPlugin.setPending(text, subject);
        intent.setAction(Intent.ACTION_MAIN);
    }
}
