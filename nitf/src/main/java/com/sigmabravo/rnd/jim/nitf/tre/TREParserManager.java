package com.sigmabravo.rnd.jim.nitf.tre;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/** @author bradh */
public class TREParserManager {

    private final ServiceLoader<ITREParser> loader;
    protected final Map<String, ITREParser> parsers = new HashMap<>();

    private TREParserManager() {
        loader = ServiceLoader.load(ITREParser.class);
        for (ITREParser factory : loader) {
            factory.init();
            parsers.put(factory.getTag(), factory);
        }
    }

    public static TREParserManager getInstance() {
        return TREParserManagerHolder.INSTANCE;
    }

    public ITREParser getParser(String tag) {
        // TODO: decent default parser
        ITREParser treParser = parsers.getOrDefault(tag, null);
        return treParser;
    }

    private static class TREParserManagerHolder {

        private static final TREParserManager INSTANCE = new TREParserManager();
    }
}
