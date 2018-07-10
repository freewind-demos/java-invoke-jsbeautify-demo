package demo;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.apache.commons.io.FileUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Hello {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        Invocable inv = (Invocable) engine;

        hello(engine, inv);
    }

    private static void hello(ScriptEngine engine, Invocable inv) throws Exception {
        Global global = new Global();
        engine.put("global", global);
        engine.eval(contentOf(new File("./beautify.js")));

        String result = global.format("var a =     111;");
        System.out.println(result);
    }

    private static String contentOf(File file) throws IOException {
        return FileUtils.readFileToString(file, Charset.defaultCharset());
    }
}
