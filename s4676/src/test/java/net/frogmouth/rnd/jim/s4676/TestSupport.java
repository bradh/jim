package net.frogmouth.rnd.jim.s4676;

import net.frogmouth.rnd.jim.s4676.s4774.ConfidentialityInformation;

public class TestSupport {

    public TestSupport() {}

    protected void setJunkSecurity(NitsRoot rootElement) {
        ConfidentialityInformation confidentialityInformation =
                rootElement.getOriginatorConfidentialityLabel().getConfidentialityInformation();
        confidentialityInformation.setPolicyIdentifier(
                "AUSTRALIAN PROTECTIVE SECURITY POLICY FRAMEWORK");
        confidentialityInformation.setClassification("UNOFFICIAL");
        rootElement
                .getOriginatorConfidentialityLabel()
                .setCreationDateTime("2021-10-10T22:24:33.734Z");
    }
}
