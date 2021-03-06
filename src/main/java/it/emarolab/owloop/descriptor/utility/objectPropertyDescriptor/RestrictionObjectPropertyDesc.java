package it.emarolab.owloop.descriptor.utility.objectPropertyDescriptor;

import it.emarolab.amor.owlInterface.OWLReferences;
import it.emarolab.owloop.descriptor.construction.descriptorEntitySet.ObjectProperties;
import it.emarolab.owloop.descriptor.construction.descriptorGround.ObjectPropertyGround;
import it.emarolab.owloop.descriptor.construction.descriptorExpression.ObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import java.util.List;


/**
 * This is an example of a 'compound' ObjectProperty Descriptor which implements 3 {@link ObjectPropertyExpression} interfaces:
 *
 * <ul>
 * <li><b>{@link ObjectPropertyExpression.Equivalent}</b>:   to describe that an ObjectProperty is equivalent to another ObjectProperty.</li>
 * <li><b>{@link ObjectPropertyExpression.Disjoint}</b>:     to describe that an ObjectProperty is disjoint to another ObjectProperty.</li>
 * <li><b>{@link ObjectPropertyExpression.Inverse}</b>:      to describe that an ObjectProperty has another inverse ObjectProperty.</li>
 * </ul>
 *
 * See {@link FullObjectPropertyDesc} for an example of a 'compound' Individual Descriptor that implements all ObjectPropertyExpressions.
 *
 * <p>
 * <div style="text-align:center;"><small>
 * <b>File</b>:         it.emarolab.owloop.core.Axiom <br>
 * <b>Licence</b>:      GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
 * <b>Authors</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it), Syed Yusha Kareem (kareem.syed.yusha@dibris.unige.it) <br>
 * <b>affiliation</b>:  EMAROLab, DIBRIS, University of Genoa. <br>
 * <b>date</b>:         01/05/19 <br>
 * </small></div>
 */
public class RestrictionObjectPropertyDesc
        extends ObjectPropertyGround
        implements ObjectPropertyExpression.Disjoint<RestrictionObjectPropertyDesc>,
        ObjectPropertyExpression.Equivalent<RestrictionObjectPropertyDesc>,
        ObjectPropertyExpression.Inverse<RestrictionObjectPropertyDesc> {

    private ObjectProperties disjointObjectProperties = new ObjectProperties();
    private ObjectProperties equivalentObjectProperties = new ObjectProperties();
    private ObjectProperties inverseObjectProperties = new ObjectProperties();

    /* Constructors from class: ObjectPropertyGround */

    public RestrictionObjectPropertyDesc(OWLObjectProperty instance, OWLReferences onto) {
        super(instance, onto);
    }
    public RestrictionObjectPropertyDesc(String instanceName, OWLReferences onto) {
        super(instanceName, onto);
    }
    public RestrictionObjectPropertyDesc(OWLObjectProperty instance, String ontoName) {
        super(instance, ontoName);
    }
    public RestrictionObjectPropertyDesc(OWLObjectProperty instance, String ontoName, String filePath, String iriPath) {
        super(instance, ontoName, filePath, iriPath);
    }
    public RestrictionObjectPropertyDesc(OWLObjectProperty instance, String ontoName, String filePath, String iriPath, boolean bufferingChanges) {
        super(instance, ontoName, filePath, iriPath, bufferingChanges);
    }
    public RestrictionObjectPropertyDesc(String instanceName, String ontoName) {
        super(instanceName, ontoName);
    }
    public RestrictionObjectPropertyDesc(String instanceName, String ontoName, String filePath, String iriPath) {
        super(instanceName, ontoName, filePath, iriPath);
    }
    public RestrictionObjectPropertyDesc(String instanceName, String ontoName, String filePath, String iriPath, boolean bufferingChanges) {
        super(instanceName, ontoName, filePath, iriPath, bufferingChanges);
    }

    /* Overriding methods in class: ObjectPropertyGround */


    // To read axioms from an ontology
    @Override
    public List<MappingIntent> readAxioms() {
        List<MappingIntent> r = ObjectPropertyExpression.Disjoint.super.readAxioms();
        r.addAll( ObjectPropertyExpression.Equivalent.super.readAxioms());
        r.addAll( ObjectPropertyExpression.Inverse.super.readAxioms());
        return r;
    }
    // To write axioms to an ontology
    @Override
    public List<MappingIntent> writeAxioms() {
        List<MappingIntent> r = ObjectPropertyExpression.Disjoint.super.writeAxioms();
        r.addAll( ObjectPropertyExpression.Equivalent.super.writeAxioms());
        r.addAll( ObjectPropertyExpression.Inverse.super.writeAxioms());
        return r;
    }

    /* Overriding methods in classes: ObjectProperty and ObjectPropertyExpression */


    // Is used by the descriptors's build() method. It's possible to change the return type based on need.
    @Override
    public RestrictionObjectPropertyDesc getNewDisjointObjectProperty(OWLObjectProperty instance, OWLReferences ontology) {
        return new RestrictionObjectPropertyDesc( instance, ontology);
    }
    // It returns disjointObjectProperties from the EntitySet (after being read from the ontology)
    @Override
    public ObjectProperties getDisjointObjectProperties() {
        return disjointObjectProperties;
    }

    // Is used by the descriptors's build() method. It's possible to change the return type based on need.
    @Override
    public RestrictionObjectPropertyDesc getNewEquivalentObjectProperty(OWLObjectProperty instance, OWLReferences ontology) {
        return new RestrictionObjectPropertyDesc( instance, ontology);
    }
    // It returns equivalentObjectProperties from the EntitySet (after being read from the ontology)
    @Override
    public ObjectProperties getEquivalentObjectProperties() {
        return equivalentObjectProperties;
    }

    // Is used by the descriptors's build() method. It's possible to change the return type based on need.
    @Override
    public RestrictionObjectPropertyDesc getNewInverseObjectProperty(OWLObjectProperty instance, OWLReferences ontology) {
        return new RestrictionObjectPropertyDesc( instance, ontology);
    }
    // It returns inverseObjectProperties from the EntitySet (after being read from the ontology)
    @Override
    public ObjectProperties getInverseObjectProperties() {
        return inverseObjectProperties;
    }

    /* Overriding method in class: Object */


    // To show internal state of the Descriptor
    public String toString() {
        return getClass().getSimpleName() + "{" + "\n" +
                "\n" +
                "\t" + getGround() + ":" + "\n" +
                "\n" +
                "\t\t≠ " +      disjointObjectProperties + "\n" +
                "\t\t≡ " +      equivalentObjectProperties + "\n" +
                "\t\t↔ " +      inverseObjectProperties + "\n" +
                "}" + "\n";
    }
}
