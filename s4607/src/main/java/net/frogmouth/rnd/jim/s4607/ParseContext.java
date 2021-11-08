package net.frogmouth.rnd.jim.s4607;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class ParseContext {

    private final MappedByteBuffer mappedByteBuffer;

    ParseContext(Path path) throws IOException {
        try (FileChannel fileChannel =
                (FileChannel) Files.newByteChannel(path, EnumSet.of(StandardOpenOption.READ))) {
            mappedByteBuffer =
                    fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        }
    }

    boolean hasRemaining() {
        return mappedByteBuffer.hasRemaining();
    }

    long position() {
        return mappedByteBuffer.position();
    }

    void get(byte[] dest) {
        mappedByteBuffer.get(dest);
    }

    int getInt() {
        return mappedByteBuffer.getInt();
    }

    int get() {
        return mappedByteBuffer.get();
    }

    long getLong() {
        return mappedByteBuffer.getLong();
    }

    int getShort() {
        return mappedByteBuffer.getShort();
    }
}
