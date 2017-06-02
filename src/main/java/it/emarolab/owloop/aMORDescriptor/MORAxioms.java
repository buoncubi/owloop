package it.emarolab.owloop.aMORDescriptor;

import com.google.common.base.Objects;
import it.emarolab.amor.owlInterface.OWLReferencesInterface;
import it.emarolab.amor.owlInterface.SemanticRestriction;
import it.emarolab.owloop.core.*;
import org.semanticweb.owlapi.model.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * The main interface for {@link Semantic.Axioms} implemented in the <a href="https://github.com/EmaroLab/multi_ontology_reference">aMOR</a> API.
 * <p>
 *     This interface contains all the {@link Axioms}, {@link SemanticAxiom}
 *     and {@link SemanticAxioms} used in the {@link Concept}, {@link Individual},
 *     {@link DataProperty} and {@link ObjectProperty} {@link Descriptor}s for the
 *     OWLOOP architecture implemented with the
 *     <a href="https://github.com/EmaroLab/multi_ontology_reference">aMOR</a> framework.
 *     <br>
 *     All of those manage a collection of ontological entities, eventually attached with
 *     a specific semantic. In particular all are based on {@link AxiomsBase}, which
 *     implements the management of an {@link HashSet} with a specified type. When the type
 *     is an {@link OWLObject}, the {@link OWLAxiomsBase} in used just to extend the
 *     {@link AxiomsBase#toString()} method.
 *     <br>
 *     More in particular, the implemented axioms set are:
 *     <ul>
 *     <li><b>{@link Individuals}</b>: for describing a set of ontological individuals.</li>
 *     <li><b>{@link Concepts}</b>: for describing a set of ontological classes.</li>
 *     <li><b>{@link Literals}</b>: for describing a set of ontological data values
 *                                           (used by the {@link DataSemantic} axiom implementation).</li>
 *     <li><b>{@link DataLinks}</b>: for describing a set of ontological data properties.</li>
 *     <li><b>{@link ObjectLinks}</b>: for describing a set of ontological object properties.</li>
 *     <li><b>{@link Restrictions}</b>: for describing a set of restriction
 *                           (i.e.: for concept definition as wel as data and property range or domain definition).</li>
 *     <li><b>{@link DataSemantic}</b>: for describing a set of data values with a semantic
 *                                     (i.e.: by {@link DataSemantics}).</li>
 *     <li><b>{@link ObjectSemantic}</b>: for describing a set of data values with a semantic
 *                                     (i.e.: by {@link ObjectSemantics}).</li>
 *     </ul>
 *
 * <div style="text-align:center;"><small>
 * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
 * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
 * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
 * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
 * <b>date</b>:        21/05/17 <br>
 * </small></div>
 */
public interface MORAxioms extends Semantic{

    /**
     * The base interface for all the {@link MORAxioms} that extends {@link Axioms} or {@link SemanticAxioms}.
     * <p>
     *     This class implements common features for managing an {@link HashSet} and a {@code singleton} value
     *     for {@link Semantic.Axioms}.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     *
     * @param <T> the type of the axiom to collect.
     */
    class AxiomsBase<T>
            implements Axioms<T>{

        /**
         * the actual singleton flagging value. Constructing value is set to {@code false}.
         */
        protected boolean singleton = false;
        /**
         * the actual set collecting the axioms.
         */
        protected Set<T> set;

        /**
         * Instanciate this {@link Axioms} as an empty {@link HashSet}.
         * It is not set to be a {@code singleton}.
         */
        public AxiomsBase() {
            this.set = new HashSet<>();
        }
        /**
         * Instanciate this {@link Axioms} as a {@link HashSet} containing the given value.
         * It is not set to be {@code singleton}.
         * @param c the element with wich setGround the set of {@link Axioms}.
         */
        public AxiomsBase(Collection<? extends T> c) {
            this.set = new HashSet<>(c);
        }
        /**
         * Instanciate this {@link Axioms} as a {@link HashSet} with a given initial size and load factor.
         * It is not set to be {@code singleton}.
         * @param initialCapacity the initial capacity of the axioms {@link HashSet}.
         * @param loadFactor the load factor of the axioms {@link HashSet}
         */
        public AxiomsBase(int initialCapacity, float loadFactor) {
            this.set = new HashSet<>(initialCapacity, loadFactor);
        }
        /**
         * Instanciate this {@link Axioms} as a {@link HashSet} with a given initial size.
         * It is not set to be {@code singleton}.
         * @param initialCapacity the initial capacity of the axioms {@link HashSet}.
         */
        public AxiomsBase(int initialCapacity) {
            this.set = new HashSet<>(initialCapacity);
        }

        @Override // see Semantic.Axioms for documentation
        public boolean isSingleton() {
            return singleton;
        }

        @Override // see Semantic.Axioms for documentation
        public void setSingleton(boolean singleton) {
            this.singleton = singleton;
        }

        @Override // see Collection for documentation
        public int size() {
            return set.size();
        }

        @Override // see Collection for documentation
        public boolean isEmpty() {
            return set.isEmpty();
        }

        @Override // see Collection for documentation
        public boolean contains(Object o) {
            return set.contains( o);
        }

        @Override // see Collection for documentation
        public Iterator<T> iterator() {
            return set.iterator();
        }

        @Override // see Collection for documentation
        public Object[] toArray() {
            return set.toArray();
        }

        @Override // see Collection for documentation
        public <U> U[] toArray(U[] a) {
            return set.toArray( a);
        }

        @Override // see Collection for documentation
        public boolean add(T t) {
            return set.add( t);
        }

        @Override // see Collection for documentation
        public boolean remove(Object o) {
            return set.remove( o);
        }

        @Override // see Collection for documentation
        public boolean containsAll(Collection<?> c) {
            return set.containsAll( c);
        }
        public boolean containsAll(AxiomsBase<T> axioms) {
            return set.containsAll( axioms.set);
        }

        @Override // see Collection for documentation
        public boolean addAll(Collection<? extends T> c) {
            return set.addAll( c);
        }
        public boolean addAll(AxiomsBase<T> owlClasses) {
            return set.addAll( owlClasses.set);
        }

        @Override // see Collection for documentation
        public boolean removeAll(Collection<?> c) {
            return set.removeAll( c);
        }

        public boolean removeAll(AxiomsBase<T> axioms) {
            return set.removeAll( axioms.set);
        }

        @Override // see Collection for documentation
        public boolean retainAll(Collection<?> c) {
            return set.retainAll( c);
        }
        public boolean retainAll(AxiomsBase<T> axioms) {
            return set.retainAll( axioms.set);
        }

        @Override // see Collection for documentation
        public void clear() {
            set.clear();
        }

        /**
         * This method considers only the {@link Axioms} {@link HashSet}, no the value of {@link #isSingleton()}.
         * @param o the object to test for equality
         * @return {@code true} if o is an derived class of {@link AxiomsBase} with the same set of {@link Axioms}.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof AxiomsBase)) return false;
            AxiomsBase that = (AxiomsBase) o;
            return Objects.equal(set, that.set);
        }
        /**
         * This method considers only the {@link Axioms} {@link HashSet}, no the value of {@link #isSingleton()}.
         * @return the has code for this set of {@link Semantic.Axioms}.
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(set);
        }

        @Override
        public String toString() {
            String out = "{";
            int cnt = set.size();
            for ( T l : set) {
                out += l;
                if ( cnt-- > 1)
                    out += ", ";
            }
            out += "}";
            if ( isSingleton())
                out += "(singleton)";
            return out;
        }

    }

    /**
     * An extension of {@link AxiomsBase} for type extending {@link OWLObject}.
     * <p>
     *     This class only override the {@link AxiomsBase#toString()} method.
     *     Refer to the super class for documentation
     *     (constructors only call {@code super(..)}).
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     *
     * @param <T> the type of the axiom to collect.
     */
    class OWLAxiomsBase<T extends OWLObject>
            extends AxiomsBase<T> {

        public OWLAxiomsBase() {
        }
        public OWLAxiomsBase(Collection<? extends T> c) {
            super(c);
        }
        public OWLAxiomsBase(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        public OWLAxiomsBase(int initialCapacity) {
            super(initialCapacity);
        }

        @Override
        public boolean contains(Object o) {
            return super.contains(o);
        }

        @Override
        public boolean add(T t) {
            return super.add(t);
        }

        @Override
        public boolean remove(Object o) {
            return super.remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return super.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            return super.addAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return super.removeAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return super.retainAll(c);
        }

        @Override
        public String toString() {
            String out = "{";
            int cnt = set.size();
            for ( T l : set) {
                out += OWLReferencesInterface.getOWLName( l);
                if ( cnt-- > 1)
                    out += ", ";
            }
            out += "}";
            if ( isSingleton())
                out += "(singleton)";
            return out;
        }
    }


    /**
     * An extension of {@link AxiomsBase} for {@link OWLNamedIndividual}.
     * <p>
     *     It represent the {@link Semantic.Axioms} describing a set of
     *     ontological individuals.
     *     <br>
     *     This class does not add any other feature with respect to its super class
     *     refer to {@link MORAxioms} and {@link AxiomsBase}  for further documentation.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class Individuals
            extends OWLAxiomsBase<OWLNamedIndividual>
            implements Axioms<OWLNamedIndividual> {
        public Individuals() {
        }
        public Individuals(Collection<? extends OWLNamedIndividual> c) {
            super(c);
        }
        public Individuals(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        public Individuals(int initialCapacity) {
            super(initialCapacity);
        }
    }

    /**
     * An extension of {@link AxiomsBase} for {@link OWLClass}.
     * <p>
     *     It represent the {@link Semantic.Axioms} describing a set of
     *     ontological classes.
     *     <br>
     *     This class does not add any other feature with respect to its super class
     *     refer to {@link MORAxioms} and {@link AxiomsBase} for further documentation.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class Concepts
            extends OWLAxiomsBase<OWLClass>
            implements Axioms<OWLClass> {
        public Concepts() {
        }
        public Concepts(Collection<? extends OWLClass> c) {
            super(c);
        }
        public Concepts(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        public Concepts(int initialCapacity) {
            super(initialCapacity);
        }
    }

    /**
     * An extension of {@link AxiomsBase} for {@link OWLLiteral}.
     * <p>
     *     It represent the {@link Semantic.Axioms} describing a set of
     *     ontological literal values.
     *     <br>
     *     This class does not add any other feature with respect to its super class
     *     refer to {@link MORAxioms} and {@link AxiomsBase}  for further documentation.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class Literals
            extends OWLAxiomsBase<OWLLiteral>
            implements Axioms<OWLLiteral> {

        public Literals() {
        }
        public Literals(Collection<? extends OWLLiteral> c) {
            super(c);
        }
        public Literals(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        public Literals(int initialCapacity) {
            super(initialCapacity);
        }
    }

    /**
     * An extension of {@link AxiomsBase} for {@link OWLDataProperty}.
     * <p>
     *     It represent the {@link Semantic.Axioms} describing a set of
     *     ontological data properties.
     *     <br>
     *     This class does not add any other feature with respect to its super class
     *     refer to {@link MORAxioms} and {@link AxiomsBase}  for further documentation.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class DataLinks
            extends OWLAxiomsBase<OWLDataProperty>
            implements Axioms<OWLDataProperty> {

        public DataLinks() {
        }
        public DataLinks(Collection<? extends OWLDataProperty> c) {
            super(c);
        }
        public DataLinks(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        public DataLinks(int initialCapacity) {
            super(initialCapacity);
        }
    }

    /**
     * An extension of {@link AxiomsBase} for {@link OWLObjectProperty}.
     * <p>
     *     It represent the {@link Semantic.Axioms} describing a set of
     *     ontological object properties.
     *     <br>
     *     This class does not add any other feature with respect to its super class
     *     refer to {@link MORAxioms} and {@link AxiomsBase}  for further documentation.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class ObjectLinks
            extends OWLAxiomsBase<OWLObjectProperty>
            implements Axioms<OWLObjectProperty> {

        public ObjectLinks() {
        }
        public ObjectLinks(Collection<? extends OWLObjectProperty> c) {
            super(c);
        }
        public ObjectLinks(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        public ObjectLinks(int initialCapacity) {
            super(initialCapacity);
        }
    }


    /**
     * An extension of {@link AxiomsBase} for {@link SemanticRestriction}.
     * <p>
     *     It represent the {@link Semantic.Axioms} describing a set of
     *     ontological restrictions.
     *     <br>
     *     This class does not add any other feature with respect to its super class
     *     refer to {@link MORAxioms} and {@link AxiomsBase}  for further documentation.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class Restrictions
            extends AxiomsBase<SemanticRestriction>
            implements Axioms<SemanticRestriction> {

        public Restrictions() {
        }
        public Restrictions(Collection<? extends SemanticRestriction> c) {
            super(c);
        }
        public Restrictions(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        public Restrictions(int initialCapacity) {
            super(initialCapacity);
        }
    }


    /**
     * An implementation of {@link SemanticAxiom} for ontological data properties.
     * <p>
     *     This class is a container for all the same data properties applied to an individual
     *     (with related values). In particular, the {@link #getSemantic()} is a specific
     *     property, while {@link #getValues()} represents a set of values linked with the
     *     above property to a {@link Ground}, not specified here.
     *     For this class, the literals ({@link #getValues()}) are of the {@link Literals} type.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class DataSemantic
            implements SemanticAxiom<OWLDataProperty,OWLLiteral> {

        private OWLDataProperty semantic;
        private Literals literals;

        /**
         * Initialise this object to have {@code null} {@link #getSemantic()} and empty {@link #getValues()}.
         */
        public DataSemantic() {
            this.literals = new Literals();
        }
        /**
         * Initialise this object to have {@code null} {@link #getSemantic()} and a given set of literal ({@link #getValues()}).
         * @param c the initial set of literals to assign to {@code this} {@link SemanticAxiom}.
         */
        public DataSemantic(Collection<? extends OWLLiteral> c) {
            this.literals = new Literals(c);
        }
        /**
         * Initialise this object to have {@code null} {@link #getSemantic()} and set of literals {@link #getValues()}
         * with specified size and load factory.
         * @param initialCapacity the initial size of the literals {@link HashSet}.
         * @param loadFactor the load factor of the literals {@link HashSet}.
         */
        public DataSemantic(int initialCapacity, float loadFactor) {
            this.literals = new Literals(initialCapacity, loadFactor);
        }
        /**
         * Initialise this object to have {@code null} {@link #getSemantic()} and set of literals {@link #getValues()}
         * with specified size and load factory.
         * @param initialCapacity the initial size of the literals {@link HashSet}.
         */
        public DataSemantic(int initialCapacity) {
            this.literals = new Literals(initialCapacity);
        }
        /**
         * Initialise this object to a specific {@link #getSemantic()} and empty {@link #getValues()}.
         * @param semantic the initial semantic of this {@link SemanticAxiom}.
         */
        public DataSemantic(OWLDataProperty semantic) {
            this.literals = new Literals();
            this.semantic = semantic;
        }
        /**
         * Initialise this object to have a specific {@link #getSemantic()} and a given set of literal ({@link #getValues()}).
         * @param semantic the initial semantic of this {@link SemanticAxiom}.
         * @param c the initial set of literals to assign to {@code this} {@link SemanticAxiom}.
         */
        public DataSemantic(OWLDataProperty semantic, Collection<? extends OWLLiteral> c) {
            this.literals = new Literals(c);
            this.semantic = semantic;
        }
        /**
         * Initialise this object to have a specific {@link #getSemantic()} and set of literals {@link #getValues()}
         * with specified size and load factory.
         * @param semantic the initial semantic of this {@link SemanticAxiom}.
         * @param initialCapacity the initial size of the literals {@link HashSet}.
         * @param loadFactor the load factor of the literals {@link HashSet}.
         */
        public DataSemantic(OWLDataProperty semantic, int initialCapacity, float loadFactor) {
            this.literals = new Literals(initialCapacity, loadFactor);
            this.semantic = semantic;
        }
        /**
         * Initialise this object to have a specific {@link #getSemantic()} and set of literals {@link #getValues()}
         * with specified size and load factory.
         * @param semantic the initial semantic of this {@link SemanticAxiom}.
         * @param initialCapacity the initial size of the literals {@link HashSet}.
         */
        public DataSemantic(OWLDataProperty semantic, int initialCapacity) {
            this.literals = new Literals(initialCapacity);
            this.semantic = semantic;
        }

        @Override // see super class for documentation
        public OWLDataProperty getSemantic() {
            return semantic;
        }

        /**
         * Set the semantic (i.e.: data property) for all the {@link #getValues()}
         * @param semantic the semantic described by {@code this} container.
         */
        public void setSemantic(OWLDataProperty semantic) {
            this.semantic = semantic;
        }

        @Override // see super class for documentation
        public Literals getValues() {
            return literals;
        }

        @Override // see super class for documentation
        public DataSemantic getNewData(Set<OWLLiteral> values) {
            return new DataSemantic( semantic, values);
        }

        @Override // see super class for documentation
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DataSemantic)) return false;
            DataSemantic morSemanticData = (DataSemantic) o;
            return Objects.equal(getSemantic(), morSemanticData.getSemantic()) &&
                    Objects.equal(literals, morSemanticData.literals);
        }

        @Override // see super class for documentation
        public int hashCode() {
            return Objects.hashCode(getSemantic());//, objects);
        }

        @Override // see super class for documentation
        public String toString() {
            return semantic.getIRI().getRemainder().get() + "." + getValues();
        }
    }

    /**
     * An implementation of {@link SemanticAxiom} for ontological object properties.
     * <p>
     *     This class is a container for all the same object properties applied to an individual
     *     (with related values). In particular, the {@link #getSemantic()} is a specific
     *     property, while {@link #getValues()} represents a set of values linked with the
     *     above property to a {@link Ground}, not specified here.
     *     For this class, the individuals ({@link #getValues()}) are of the {@link Individuals} type.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class ObjectSemantic
            implements SemanticAxiom<OWLObjectProperty,OWLNamedIndividual> {

        private OWLObjectProperty semantic;
        private Individuals objects;

        /**
         * Initialise this object to have {@code null} {@link #getSemantic()} and empty {@link #getValues()}.
         */
        public ObjectSemantic() {
            this.objects = new Individuals();
        }
        /**
         * Initialise this object to have {@code null} {@link #getSemantic()} and a given set of individuals ({@link #getValues()}).
         * @param c the initial set of individuals to assign to {@code this} {@link SemanticAxiom}.
         */
        public ObjectSemantic(Collection<? extends OWLNamedIndividual> c) {
            this.objects = new Individuals(c);
        }
        /**
         * Initialise this object to have {@code null} {@link #getSemantic()} and set of individuals {@link #getValues()}
         * with specified size and load factory.
         * @param initialCapacity the initial size of the individuals {@link HashSet}.
         * @param loadFactor the load factor of the individuals {@link HashSet}.
         */
        public ObjectSemantic(int initialCapacity, float loadFactor) {
            this.objects = new Individuals(initialCapacity, loadFactor);
        }
        /**
         * Initialise this object to have {@code null} {@link #getSemantic()} and set of individuals {@link #getValues()}
         * with specified size and load factory.
         * @param initialCapacity the initial size of the individuals {@link HashSet}.
         */
        public ObjectSemantic(int initialCapacity) {
            this.objects = new Individuals(initialCapacity);
        }
        /**
         * Initialise this object to a specific {@link #getSemantic()} and empty {@link #getValues()}.
         * @param semantic the initial semantic of this {@link SemanticAxiom}.
         */
        public ObjectSemantic(OWLObjectProperty semantic) {
            this.objects = new Individuals();
            this.semantic = semantic;
        }
        /**
         * Initialise this object to have a specific {@link #getSemantic()} and a given set of individuals ({@link #getValues()}).
         * @param semantic the initial semantic of this {@link SemanticAxiom}.
         * @param c the initial set of individuals to assign to {@code this} {@link SemanticAxiom}.
         */
        public ObjectSemantic(OWLObjectProperty semantic, Collection<? extends OWLNamedIndividual> c) {
            this.objects = new Individuals( c);
            this.semantic = semantic;
        }
        /**
         * Initialise this object to have a specific {@link #getSemantic()} and set of individuals {@link #getValues()}
         * with specified size and load factory.
         * @param semantic the initial semantic of this {@link SemanticAxiom}.
         * @param initialCapacity the initial size of the individuals {@link HashSet}.
         * @param loadFactor the load factor of the individuals {@link HashSet}.
         */
        public ObjectSemantic(OWLObjectProperty semantic, int initialCapacity, float loadFactor) {
            this.objects = new Individuals(initialCapacity, loadFactor);
            this.semantic = semantic;
        }
        /**
         * Initialise this object to have a specific {@link #getSemantic()} and set of individuals {@link #getValues()}
         * with specified size and load factory.
         * @param semantic the initial semantic of this {@link SemanticAxiom}.
         * @param initialCapacity the initial size of the individuals {@link HashSet}.
         */
        public ObjectSemantic(OWLObjectProperty semantic, int initialCapacity) {
            this.objects = new Individuals(initialCapacity);
            this.semantic = semantic;
        }

        @Override // see super class for documentation
        public OWLObjectProperty getSemantic() {
            return semantic;
        }

        /**
         * Set the semantic (i.e.: object property) for all the {@link #getValues()}
         * @param semantic the semantic described by {@code this} container.
         */
        public void setSemantic(OWLObjectProperty semantic) {
            this.semantic = semantic;
        }

        @Override // see super class for documentation
        public Individuals getValues() {
            return objects;
        }

        @Override // see super class for documentation
        public ObjectSemantic getNewData(Set<OWLNamedIndividual> values) {
            return new ObjectSemantic( semantic, values);
        }

        @Override // see super class for documentation
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ObjectSemantic)) return false;
            ObjectSemantic morData = (ObjectSemantic) o;
            return Objects.equal(getSemantic(), morData.getSemantic()) &&
                    Objects.equal(objects, morData.objects);
        }

        @Override // see super class for documentation
        public int hashCode() {
            return Objects.hashCode(getSemantic());//, objects);
        }

        @Override // see super class for documentation
        public String toString() {
            return semantic.getIRI().getRemainder().get() + "." + getValues();
        }
    }



    /**
     * An extension of {@link AxiomsBase} for {@link SemanticAxioms} for data properties.
     * <p>
     *     It represent the {@link SemanticAxioms} describing a set of
     *     ontological data properties as a collection of {@link DataSemantic}.
     *     <br>
     *     This class does not add any other feature with respect to its super class
     *     refer to {@link MORAxioms} and {@link AxiomsBase}  for further documentation.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class DataSemantics
            extends AxiomsBase<DataSemantic>
            implements SemanticAxioms<DataSemantic,OWLLiteral> {

        public DataSemantics() {
        }
        public DataSemantics(Collection<? extends DataSemantic> c) {
            super(c);
        }
        public DataSemantics(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        public DataSemantics(int initialCapacity) {
            super(initialCapacity);
        }

        /**
         * Searches in the {@link SemanticAxiom} for the given property and
         * returns all its values.
         * @param semantic the properties to look for.
         * @return all the synchronised values of the given property.
         * An {@code empty} {@link HashSet} if the values is not available.
         */
        public Set<OWLLiteral> getLiterals(OWLDataProperty semantic){
            for ( DataSemantic s : set){
                if ( semantic.equals( s.getSemantic()))
                    return s.getValues().set;
            }
            return new HashSet<>();
        }

        /**
         * Searches in the {@link SemanticAxiom} for the given property and
         * returns one of its values. If {@link Axioms#isSingleton()},
         * other values are ignored.
         * @param semantic the properties to look for.
         * @return one of the synchronised values of the given property.
         * An {@code null} if the values is not available.
         */
        public OWLLiteral getLiteral( OWLDataProperty semantic){
            for ( DataSemantic s : set){
                if ( semantic.equals( s.getSemantic())) {
                    if ( ! s.getValues().isSingleton())
                        System.out.println( " !! search for only one literal in a not singleton object property: " + s);
                    for (OWLLiteral l : s.getValues())
                        return l;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            String out = set.toString();
            if ( isSingleton())
                out += "(singleton)";
            return out;
        }
    }

    /**
     * An extension of {@link AxiomsBase} for {@link SemanticAxioms} for object properties.
     * <p>
     *     It represent the {@link SemanticAxioms} describing a set of
     *     ontological object properties as a collection of {@link ObjectSemantic}.
     *     <br>
     *     This class does not add any other feature with respect to its super class
     *     refer to {@link MORAxioms} and {@link AxiomsBase}  for further documentation.
     * </p>
     * <div style="text-align:center;"><small>
     * <b>File</b>:        it.emarolab.owloop.aMORDescriptor.MORAxioms <br>
     * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
     * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
     * <b>affiliation</b>: EMAROLab, DIBRIS, University of Genoa. <br>
     * <b>date</b>:        21/05/17 <br>
     * </small></div>
     */
    class ObjectSemantics
            extends AxiomsBase<ObjectSemantic>
            implements SemanticAxioms<ObjectSemantic,OWLNamedIndividual> {

        public ObjectSemantics() {
        }
        public ObjectSemantics(Collection<? extends ObjectSemantic> c) {
            super(c);
        }
        public ObjectSemantics(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        public ObjectSemantics(int initialCapacity) {
            super(initialCapacity);
        }


        /**
         * Searches in the {@link SemanticAxiom} for the given property and
         * returns all its values.
         * @param semantic the properties to look for.
         * @return all the synchronised values of the given property.
         * An {@code empty} {@link HashSet} if the values is not available.
         */
        public Set<OWLNamedIndividual> getLinks(OWLObjectProperty semantic){
            for ( ObjectSemantic s : set){
                if ( semantic.equals( s.getSemantic()))
                    return s.getValues().set;
            }
            return new HashSet<>();
        }

        /**
         * Searches in the {@link SemanticAxiom} for the given properties and
         * returns one of its values. If {@link Axioms#isSingleton()},
         * other values are ignored.
         * @param semantic the properties to look for.
         * @return one of the synchronised values of the given property.
         * An {@code null} if the values is not available.
         */
        public OWLNamedIndividual getLink( OWLObjectProperty semantic){
            for ( ObjectSemantic s : set){
                if ( semantic.equals( s.getSemantic())) {
                    if ( ! s.getValues().isSingleton())
                        System.out.println( " !! search for only one individual in a not singleton data property: " + s);
                    for (OWLNamedIndividual l : s.getValues())
                        return l;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            String out = set.toString();
            if ( isSingleton())
                out += "(singleton)";
            return out;
        }
    }


}
