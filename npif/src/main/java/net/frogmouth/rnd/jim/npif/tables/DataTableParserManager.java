package net.frogmouth.rnd.jim.npif.tables;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class DataTableParserManager {

    private final ServiceLoader<DataTableParser> loader;
    protected final List<DataTableParser> parsers = new ArrayList<>();

    private DataTableParserManager() {
        loader = ServiceLoader.load(DataTableParser.class);
        for (DataTableParser factory : loader) {
            factory.init();
            parsers.add(factory);
        }
    }

    public static DataTableParserManager getInstance() {
        return TREParserManagerHolder.INSTANCE;
    }

    public DataTableParser getParser(int sourceAddress, int fileAddress) {
        for (DataTableParser parser : parsers) {
            if (parser.canHandle(sourceAddress, fileAddress)) {
                return parser;
            }
        }
        return null;
    }

    private static class TREParserManagerHolder {

        private static final DataTableParserManager INSTANCE = new DataTableParserManager();
    }
}
