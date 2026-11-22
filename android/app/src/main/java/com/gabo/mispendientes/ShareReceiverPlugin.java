package com.gabo.mispendientes;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "ShareReceiver")
public class ShareReceiverPlugin extends Plugin {
    private static String pendingText = null;
    private static String pendingSubject = null;
    private static ShareReceiverPlugin instance = null;

    @Override
    public void load() {
        instance = this;
    }

    static synchronized void setPending(String text, String subject) {
        pendingText = text;
        pendingSubject = subject;
        if (instance != null) {
            instance.notifyListeners("shared", new JSObject(), false);
        }
    }

    @PluginMethod
    public void getShared(PluginCall call) {
        JSObject ret = new JSObject();
        synchronized (ShareReceiverPlugin.class) {
            ret.put("text", pendingText);
            ret.put("subject", pendingSubject);
            pendingText = null;
            pendingSubject = null;
        }
        call.resolve(ret);
    }
}
