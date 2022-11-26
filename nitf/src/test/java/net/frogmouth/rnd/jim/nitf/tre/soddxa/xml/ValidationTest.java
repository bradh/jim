package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog.SourceCatalog;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog.SourceCatalogName;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection.CollectionData;
import net.frogmouth.rnd.jim.nitf.validation.ValidationResults;
import org.testng.annotations.Test;

public class ValidationTest {

    @Test
    public void shouldBeGoodNonSatellite() {
        DateWithOptionalUTCTime catalogDate =
                new DateWithOptionalUTCTime(LocalDate.of(2022, 11, 26), null);
        SourceCatalog catalog = new SourceCatalog(SourceCatalogName.SPACE_TRACK, catalogDate);
        CollectionData collectionData = new CollectionData();
        SpaceObjectDescriptionData uut =
                new SpaceObjectDescriptionData(SpaceObjectType.TRANSIENT, catalog, collectionData);
        ValidationResults results = uut.checkValidity();
        assertTrue(results.isConformant());
    }
}
