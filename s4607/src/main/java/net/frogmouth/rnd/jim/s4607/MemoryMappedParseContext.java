package net.frogmouth.rnd.jim.s4607;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

/**
 * Memory Mapped Parsing context.
 *
 * <p>This is used to provide state between parsing stages, implemented in terms of a memory mapped
 * file.
 */
public class MemoryMappedParseContext extends AbstractByteBufferParseContext {

    /**
     * Constructor.
     *
     * @param path the path to the file to load
     * @throws IOException if the file could not be loaded
     */
    public MemoryMappedParseContext(Path path) throws IOException {
        try (FileChannel fileChannel =
                (FileChannel) Files.newByteChannel(path, EnumSet.of(StandardOpenOption.READ))) {
            buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        }
    }
}
