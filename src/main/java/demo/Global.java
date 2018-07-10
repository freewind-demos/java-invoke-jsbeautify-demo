package demo;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class Global {

    public ScriptObjectMirror js_beautify;

    public String format(String jsCode) {
        return (String) js_beautify.call(null, jsCode);
    }

}
