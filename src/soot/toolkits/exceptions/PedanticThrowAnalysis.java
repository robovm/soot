/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 John Jorgensen
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package soot.toolkits.exceptions;

import soot.Unit;
import soot.Singletons;
import soot.G;
import soot.jimple.ThrowStmt;

/**
 * A {@link ThrowAnalysis} that says that every unit can throw every
 * possible exception type.  Strictly speaking, this is correct, since
 * the deprecated {@link java.lang.Thread#stop(Throwable)} method
 * allows one thread to cause any {@link Throwable} it wants to be
 * thrown in another thread, meaning that all {@link Throwable}s may
 * arrive asynchronously from the perspective of the victim thread.
 */
public class PedanticThrowAnalysis extends AbstractThrowAnalysis {

    /**
     * Constructs a <code>PedanticThrowAnalysis</code> for inclusion in 
     * Soot's global variable manager, {@link G}.
     *
     * @param g guarantees that the constructor may only be called 
     * from {@link Singletons}.
     */
    public PedanticThrowAnalysis(Singletons.Global g) {}

    /**
     * Returns the single instance of <code>PedanticThrowAnalysis</code>.
     *
     * @return Soot's <code>PedanticThrowAnalysis</code>.
     */
    public static PedanticThrowAnalysis v() { 
	return G.v().soot_toolkits_exceptions_PedanticThrowAnalysis(); 
    }


    /**
     * Returns the set of all <code>Throwable</code>s as the set
     * of types that the specified unit might throw, regardless of the
     * unit's identity.
     *
     * @param u {@link Unit} whose exceptions are to be returned.
     *
     * @return the set of all <code>Throwable</code>s.
     */
    public ThrowableSet mightThrow(Unit u) {
	return ThrowableSet.Manager.v().ALL_THROWABLES;
    }




    /**
     * Returns the set of all <code>Throwable</code>s as the set
     * of types that a <code>throw</code> statement may throw implicitly, 
     * that is, the possible types of errors which might arise in
     * the course of executing the <code>throw</code> statement, rather
     * than the type of the <code>throw</code>'s operand.
     *
     * @param t the {@link ThrowStmt} whose exceptions are to be returned.
     *
     * @return the set of all <code>Throwable</code>s.
     */
    public ThrowableSet mightThrowImplicitly(ThrowStmt t) {
	return ThrowableSet.Manager.v().ALL_THROWABLES;
    }
}

