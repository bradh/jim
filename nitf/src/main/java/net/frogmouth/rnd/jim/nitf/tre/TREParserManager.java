package net.frogmouth.rnd.jim.nitf.tre;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class TREParserManager {

    private final ServiceLoader<AbstractTaggedRecordExtensionParser> loader;
    protected final Map<String, AbstractTaggedRecordExtensionParser> parsers = new HashMap<>();

    private TREParserManager() {
        loader = ServiceLoader.load(AbstractTaggedRecordExtensionParser.class);
        for (AbstractTaggedRecordExtensionParser factory : loader) {
            parsers.put(factory.getTag(), factory);
        }
    }

    public static TREParserManager getInstance() {
        return TREParserManagerHolder.INSTANCE;
    }

    public AbstractTaggedRecordExtensionParser getParser(String tag) {
        // TODO: decent default parser
        AbstractTaggedRecordExtensionParser treParser = parsers.getOrDefault(tag, null);
        return treParser;
    }

    private static class TREParserManagerHolder {

        private static final TREParserManager INSTANCE = new TREParserManager();
    }
}
