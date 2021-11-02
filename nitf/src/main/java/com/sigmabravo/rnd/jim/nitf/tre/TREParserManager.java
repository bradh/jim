package com.sigmabravo.rnd.jim.nitf.tre;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class TREParserManager {

    private final ServiceLoader<AbstractTREParser> loader;
    protected final Map<String, AbstractTREParser> parsers = new HashMap<>();

    private TREParserManager() {
        loader = ServiceLoader.load(AbstractTREParser.class);
        for (AbstractTREParser factory : loader) {
            factory.init();
            parsers.put(factory.getTag(), factory);
        }
    }

    public static TREParserManager getInstance() {
        return TREParserManagerHolder.INSTANCE;
    }

    public AbstractTREParser getParser(String tag) {
        // TODO: decent default parser
        AbstractTREParser treParser = parsers.getOrDefault(tag, null);
        return treParser;
    }

    private static class TREParserManagerHolder {

        private static final TREParserManager INSTANCE = new TREParserManager();
    }
}
