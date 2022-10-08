package net.frogmouth.rnd.jim.nitf.tre;

// TODO: move this into TaggedRecordExtension when they are all serialisable
public interface SerialisableTaggedRecordExtension {

    byte[] toBytes();
}
