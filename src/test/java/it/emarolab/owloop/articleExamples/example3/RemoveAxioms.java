package it.emarolab.owloop.articleExamples.example3;

import it.emarolab.amor.owlInterface.OWLReferences;
import it.emarolab.owloop.articleExamples.exampleDescriptors.ObjectLinkIndividualDesc;
import it.emarolab.owloop.core.Axiom.Descriptor.*;
import org.junit.Before;
import org.junit.Test;

/**
 * An example to show how to remove axioms from an ontology.
 *
 * <p>
 * <div style="text-align:center;"><small>
 * <b>File</b>:         it.emarolab.owloop.core.Axiom <br>
 * <b>Licence</b>:      GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
 * <b>Authors</b>:      Syed Yusha Kareem (kareem.syed.yusha@dibris.unige.it) <br>
 * <b>affiliation</b>:  EMAROLab, DIBRIS, University of Genoa. <br>
 * <b>date</b>:         08/09/19 <br>
 * </small></div>
 */
public class RemoveAxioms {

    private OWLReferences ontoRef;

    @Before
    public void beforeTest() {

        // Disables printing of amor logs
        OntologyReference.aMORlogging( false);

        ontoRef = OntologyReference.newOWLReferenceFromFileWithPellet(
                "robotAtHomeOnto", // ontology reference name
                "src/test/resources/robotAtHomeOntology.owl", // the ontology file path
                "http://www.semanticweb.org/emaroLab/robotAtHomeOntology", // the ontology IRI path
                true // if (true) you must synchronize the reasoner manually. Else, it synchronizes itself.
        );
    }

    @Test
    public void removeStuff() {

        // robot individual
        ObjectLinkIndividualDesc robot_Desc1 = new ObjectLinkIndividualDesc( "Robot1", ontoRef);

        // synchronize axioms from the Ontology to the internal state of the Descriptor
        robot_Desc1.readExpressionAxioms();

        // print the Descriptor
        System.out.println(robot_Desc1);

        // remove Object Property associated to the Individual Descriptor (i.e., from Descriptor's internal state)
        robot_Desc1.removeObject("isIn");

        // synchronize axioms from the internal state of the Descriptor and Ontology
        robot_Desc1.writeExpressionAxioms();

        // synchronize reasoner of the ontology, so that its axioms are updated with inferences based on latest assertions
        ontoRef.synchronizeReasoner();

        // save the current state of the ontology
        robot_Desc1.saveOntology(ontoRef.getFilePath());

        // A new Descriptor associated to the same individual as before
        ObjectLinkIndividualDesc robot_Desc2 = new ObjectLinkIndividualDesc( "Robot1", ontoRef);

        // synchronize axioms from the Ontology to the internal state of the Descriptor
        robot_Desc2.readExpressionAxioms();

        // print the Descriptor
        System.out.println(robot_Desc2);
    }

}